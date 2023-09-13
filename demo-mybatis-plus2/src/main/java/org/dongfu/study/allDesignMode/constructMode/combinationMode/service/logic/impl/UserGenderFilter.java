package org.dongfu.study.allDesignMode.constructMode.combinationMode.service.logic.impl;

import org.dongfu.study.allDesignMode.constructMode.combinationMode.service.logic.BaseLogic;

import java.util.Map;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/11 20:29
* @version 1.0
*/

public class UserGenderFilter extends BaseLogic {
    @Override
    public String matterValue(Long treeId, String userId, Map<String, String> decisionMatter) {
        return decisionMatter.get("gender");
    }
}
