package org.dongfu.util;
/**
 * @description: TODO
 * @author majiajian
 * @date 2023/4/16 14:22
 * @version 1.0
 */
//为什么甚至路径都一样，还是com.github.shyiko.***，
// 因为com.zendesk这个包，里面包了个com.github.shyiko.***这玩意，我怀疑是收购关系

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.alibaba.otter.canal.protocol.Message;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

//此类可以监控MySQL库数据的增删改
@Component
@Slf4j  //用于打印日志
//在SpringBoot中，提供了一个接口：ApplicationRunner。
//该接口中，只有一个run方法，他执行的时机是：spring容器启动完成之后，就会紧接着执行这个接口实现类的run方法。
public class CanalMysqlListener implements ApplicationRunner {
    private final static int BATCH_SIZE = 10000;
    //Canal服务地址
    private static final String SERVER_ADDRESS = "127.0.0.1";

    //Canal Server 服务端口号
    private static final Integer PORT = 11111;

    //目的地，其实Canal Service内部有一个队列
    private static final String DESTINATION = "example";

    //用户名和密码，但是目前不支持，只能为空
    private static final String USERNAME = "canal";

    //用户名和密码，但是目前不支持，只能为空
    private static final String PASSWORD = "canal";


    @Override
    public void run(ApplicationArguments args) throws Exception {
        //项目启动完成连接bin-log
        new Thread(() -> {
            connectMysqlBinLog();
        }).start();

    }

    public void connectMysqlBinLog() {
        CanalConnector canalConnector = CanalConnectors.newSingleConnector(
                new InetSocketAddress(SERVER_ADDRESS, PORT), DESTINATION, USERNAME, PASSWORD);
        canalConnector.connect();
        //订阅所有消息
        canalConnector.subscribe(".*\\..*");
        //恢复到之前同步的那个位置
        canalConnector.rollback();

        for (; ; ) {
            //获取指定数量的数据，但是不做确认标记，下一次取还会取到这些信息
            Message message = canalConnector.getWithoutAck(100);
            //获取消息id
            long batchId = message.getId();
            if (batchId != -1) {
                System.out.println("msgId -> " + batchId);
                printEnity(message.getEntries());
                //提交确认
                //canalConnector.ack(batchId);
                //处理失败，回滚数据
                //canalConnector.rollback(batchId);
            }
        }
    }

    private static void printEnity(List<CanalEntry.Entry> entries) {
        for (CanalEntry.Entry entry : entries) {
            if (entry.getEntryType() != CanalEntry.EntryType.ROWDATA) {
                continue;
            }
            try {
                CanalEntry.RowChange rowChange = CanalEntry.RowChange.parseFrom(entry.getStoreValue());
                for (CanalEntry.RowData rowData : rowChange.getRowDatasList()) {
                    System.out.println(rowChange.getEventType());
                    switch (rowChange.getEventType()) {
                        //如果希望监听多种事件，可以手动增加case
                        case INSERT:
                            String tableName = entry.getHeader().getTableName();
                            log.info("表名 - 数据新增 {}",tableName);
                            //测试users表进行映射处
                            List<CanalEntry.Column> afterColumnsList = rowData.getAfterColumnsList();
                            System.out.println(afterColumnsList);
                            break;
                        case UPDATE:
                            List<CanalEntry.Column> afterColumnsList2 = rowData.getAfterColumnsList();
                            System.out.println("新插入的数据是：" + afterColumnsList2);
                            break;
                        case DELETE:
                            List<CanalEntry.Column> beforeColumnsList = rowData.getBeforeColumnsList();
                            System.out.println("被删除的数据是：" + beforeColumnsList);
                            break;
                        default:
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 连接mysqlBinLog
     */
//    public void connectMysqlBinLog() {
//        while (true) {
//            //canal，canal是刚才mysql为canal创建的用户的账号和密码
//            CanalConnector connector = CanalConnectors.newSingleConnector(
//                    new InetSocketAddress("127.0.0.1", 11111), "example", "canal", "canal");
//            String canalMonitorTableName="test";
//
//            try {
//                //打开连接
//                connector.connect();
//                System.out.println("数据库检测连接成功!" + canalMonitorTableName);
//                //订阅数据库表,全部表q
//                connector.subscribe("canal_mysql_listener");
//                //回滚到未进行ack的地方，下次fetch的时候，可以从最后一个没有ack的地方开始拿
//                connector.rollback();
//                while (true) {
//                    // 获取指定数量的数据
//                    Message message = connector.getWithoutAck(BATCH_SIZE);
//                    long batchId = message.getId();
////                    System.out.println("position:"+batchId);
//                    int size = message.getEntries().size();
//                    if (batchId == -1 || size == 0) {
//                    } else {
////                        System.out.println("解析到一条数据------------>"+message.getEntries());
//                        handleDATAChange(message.getEntries());
//                    }
//                    // 提交确认
//                    connector.ack(batchId);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//                System.out.println("成功断开监测连接!尝试重连");
//            } finally {
//                connector.disconnect();
//                //防止频繁访问数据库链接: 线程睡眠 10秒
//                try {
//                    Thread.sleep(10 * 1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }


    /**
     * 打印canal server解析binlog获得的实体类信息
     */
//    private void handleDATAChange(List<CanalEntry.Entry> entrys) {
//        for (CanalEntry.Entry entry : entrys) {
//            if (entry.getEntryType() == CanalEntry.EntryType.TRANSACTIONBEGIN || entry.getEntryType() == CanalEntry.EntryType.TRANSACTIONEND) {
//                continue;
//            }
//            //RowChange对象，包含了一行数据变化的所有特征
//            CanalEntry.RowChange rowChage;
//            try {
//                rowChage = CanalEntry.RowChange.parseFrom(entry.getStoreValue());
//            } catch (Exception e) {
//                throw new RuntimeException("ERROR ## parser of eromanga-event has an error , data:" + entry.toString(), e);
//            }
//            CanalEntry.EventType eventType = rowChage.getEventType();
//            if (eventType == CanalEntry.EventType.INSERT){
//                try {
//                    CanalEntry.RowChange rowChange = CanalEntry.RowChange.parseFrom(entry.getStoreValue());
//                    for (int i = 0; i < rowChange.getRowDatasCount(); i++) {
//                        CanalEntry.RowData rowDatas = rowChange.getRowDatas(i);
//                        String id=rowDatas.getAfterColumns(0).getValue();
//                        String date=rowDatas.getAfterColumns(1).getValue();
//                        String order=rowDatas.getAfterColumns(2).getValue();
//                        System.out.println(id+"---"+date+"---"+order);
//                    }
//                } catch (InvalidProtocolBufferException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }



}