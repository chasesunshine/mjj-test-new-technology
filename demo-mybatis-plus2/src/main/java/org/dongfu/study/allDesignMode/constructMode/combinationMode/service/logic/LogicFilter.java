package org.dongfu.study.allDesignMode.constructMode.combinationMode.service.logic;

import org.dongfu.study.allDesignMode.constructMode.combinationMode.model.vo.TreeNodeLink;

import java.util.List;
import java.util.Map;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/11 20:23
* @version 1.0
*/

public interface LogicFilter {
    /**
     * 逻辑决策器
     *
     * @param matterValue          决策值
     * @param treeNodeLineInfoList 决策节点
     * @return 下⼀个节点Id
     */
    Long filter(String matterValue, List<TreeNodeLink> treeNodeLineInfoList);

    /**
     * 获取决策值
     *
     * @param decisionMatter 决策物料
     * @return 决策值
     */
    String matterValue(Long treeId, String userId, Map<String, String> decisionMatter);
}
