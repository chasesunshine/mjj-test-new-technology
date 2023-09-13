package org.dongfu.study.allDesignMode.constructMode.combinationMode.service.engine.impl;

import org.dongfu.study.allDesignMode.constructMode.combinationMode.model.aggregates.TreeRich;
import org.dongfu.study.allDesignMode.constructMode.combinationMode.model.vo.EngineResult;
import org.dongfu.study.allDesignMode.constructMode.combinationMode.model.vo.TreeNode;
import org.dongfu.study.allDesignMode.constructMode.combinationMode.service.engine.EngineBase;

import java.util.Map;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/11 20:21
* @version 1.0
*/

public class TreeEngineHandle extends EngineBase {
    @Override
    public EngineResult process(Long treeId, String userId, TreeRich treeRich, Map<String, String> decisionMatter) {
        // 决策流程
        TreeNode treeNode = engineDecisionMaker(treeRich, treeId, userId, decisionMatter);
        // 决策结果
        return new EngineResult(userId, treeId, treeNode.getTreeNodeId(), treeNode.getNodeValue());
    }
}
