package org.dongfu.study.allDesignMode.constructMode.combinationMode.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/11 20:19
* @version 1.0
*/

@Data
@AllArgsConstructor
public class EngineResult {
    private String userId;

    private Long treeId;

    private Long treeNodeId;

    private String nodeValue;

}
