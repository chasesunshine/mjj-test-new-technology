package org.dongfu.study.threadPool.threadPool1.impl;

import org.dongfu.study.threadPool.threadPool1.ITask;
import org.dongfu.study.threadPool.threadPool1.ResultBean;

import java.util.Map;

/**
 * 任务处理接口
 * 具体业务逻辑可实现该接口
 *  T 返回值类型
 *  E 传入值类型
 * ITask<BR>
 * 创建人:wangbeidou <BR>
 * 时间：2018年8月4日-下午6:12:32 <BR>
 * @version 2.0
 *
 */
public class ITaskImpl<T, E> implements ITask<ResultBean<String>, Integer> {

    /**
     *
     * @param dealData 单线程要处理的数据
     * @param params 其他辅助参数
     * @return
     */
    @Override
    public ResultBean execute(Integer dealData, Map<String, Object> params) {
        /**
         * 具体业务逻辑：将list中的元素加上辅助参数中的数据返回
         */
        int addNum = Integer.valueOf(String.valueOf(params.get("addNum")));
        dealData = dealData + addNum;
        ResultBean<String> resultBean = ResultBean.newInstance();
        resultBean.setData(dealData.toString());
        return resultBean;
    }
}
