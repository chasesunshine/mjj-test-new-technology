package org.wanbang.study.threadPool.test;


import com.alibaba.fastjson.JSON;
import org.wanbang.study.threadPool.ITask;
import org.wanbang.study.threadPool.ITaskImpl;
import org.wanbang.study.threadPool.MultiThreadUtils;
import org.wanbang.study.threadPool.ResultBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * 具体执行业务任务 需要 实现ITask接口  在execute中重写业务逻辑
 * TestTask<BR>
 * 创建人:wangbeidou <BR>
 * 时间：2018年8月8日-下午8:40:32 <BR>
 * @version 2.0
 *
 */
// https://www.cnblogs.com/qixing/p/9451714.html
public class TestTask{
    public static void main(String[] args) {
        // 需要多线程处理的大量数据list
        List<Integer> data = new ArrayList<>(10000);
        for(int i = 0; i < 10000; i ++){
            data.add(i + 1);
        }

        // 创建多线程处理任务
        MultiThreadUtils<Integer> threadUtils = MultiThreadUtils.newInstance(5);
        ITask<ResultBean<String>, Integer> task = new ITaskImpl();

        // 辅助参数  加数
        Map<String, Object> params = new HashMap<>();
        params.put("addNum", 4);

        // 执行多线程处理，并返回处理结果
        ResultBean<List<ResultBean<String>>> resultBean = threadUtils.execute(data, params, task);
        System.out.println(JSON.toJSONString(resultBean));
    }
}
