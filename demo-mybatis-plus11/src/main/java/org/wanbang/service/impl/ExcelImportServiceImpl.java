package org.wanbang.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.metadata.ReadSheet;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.wanbang.dao.UserDao;
import org.wanbang.entity.User;
import org.wanbang.service.ExcelImportService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ExcelImportServiceImpl implements ExcelImportService {

    // 线程池配置
    private static final int CORE_POOL_SIZE = Runtime.getRuntime().availableProcessors() * 2;
    private static final int MAX_POOL_SIZE = CORE_POOL_SIZE * 2;
    private static final int QUEUE_CAPACITY = 1000;
    private static final int BATCH_SIZE = 5000; // 每个批次处理5000条

    private final ThreadPoolExecutor executor = new ThreadPoolExecutor(
            CORE_POOL_SIZE,
            MAX_POOL_SIZE,
            60L,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(QUEUE_CAPACITY),
            new ThreadPoolExecutor.CallerRunsPolicy());

    @Resource
    private UserDao userDao;

    /**
     * 执行流程：
     *
     *  线程：Thread[http-nio-8101-exec-1,5,main]循环处理批量数据
     *  线程：Thread[http-nio-8101-exec-1,5,main]循环处理批量数据
     *  线程：Thread[http-nio-8101-exec-1,5,main]处理最后一批数据
     *  线程：Thread[http-nio-8101-exec-1,5,main]主线程执行完成
     *  ...
     *  线程：Thread[pool-1-thread-1,5,main]处理数据:50
     *  线程：Thread[pool-1-thread-2,5,main]处理数据:50
     *  线程：Thread[pool-1-thread-3,5,main]处理数据:20
     *
     * @param file
     * @return
     * @throws Exception
     */
    @Override
    public int importLargeExcel(MultipartFile file) throws Exception {
        ExcelDataListener listener = new ExcelDataListener();
        // 使用EasyExcel读取，更节省内存
        ExcelReader excelReader = EasyExcel.read(file.getInputStream())
                .head(User.class)
                .registerReadListener(listener)
                .build();

        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        excelReader.finish();

        System.out.println("线程："+Thread.currentThread()+"主线程执行完成");

        return listener.getTotal();
    }

    // Excel数据监听器，实现分片和多线程处理
    private class ExcelDataListener extends AnalysisEventListener<User> {
        private AtomicInteger total = new AtomicInteger(0);
        private List<User> batchList = new ArrayList<>(BATCH_SIZE);

        @Override
        public void invoke(User data, AnalysisContext context) {
            batchList.add(data);
            if (batchList.size() >= BATCH_SIZE) {
                // 提交批次任务到线程池
                submitBatch(new ArrayList<>(batchList));
                batchList.clear();
                System.out.println("线程："+Thread.currentThread()+"循环处理批量数据");
            }
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
            // 处理最后一批数据
            if (!batchList.isEmpty()) {
                submitBatch(batchList);
                System.out.println("线程："+Thread.currentThread()+"处理最后一批数据");
            }
        }

        private void submitBatch(List<User> batch) {
            List<User> copy = new ArrayList<>(batch);
            executor.execute(() -> {
                // 这里可以使用批量插入
                userDao.batchInsert(copy);
                total.addAndGet(copy.size());
                System.out.println("线程："+Thread.currentThread()+"处理数据:"+copy.size());
            });
        }

        public int getTotal() {
            // 等待所有任务完成
            while (executor.getActiveCount() > 0 || !executor.getQueue().isEmpty()) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            return total.get();
        }
    }
}
