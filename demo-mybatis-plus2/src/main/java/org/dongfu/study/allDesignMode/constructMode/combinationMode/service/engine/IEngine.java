package org.dongfu.study.allDesignMode.constructMode.combinationMode.service.engine;

import org.dongfu.study.allDesignMode.constructMode.combinationMode.model.aggregates.TreeRich;
import org.dongfu.study.allDesignMode.constructMode.combinationMode.model.vo.EngineResult;

import java.util.Map;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/11 20:23
* @version 1.0
*/

public interface IEngine {
    EngineResult process(final Long treeId, final String userId, TreeRich treeRich, final Map<String, String> decisionMatter);
}