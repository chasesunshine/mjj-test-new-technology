package org.dongfu.study.allDesignMode.constructMode.combinationMode.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/11 20:19
* @version 1.0
*/

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TreeNode {
    private Long treeId;

    private Long treeNodeId;

    private Integer nodeType;

    private String nodeValue;

    private String ruleKey;

    private String ruleDesc;

    List<TreeNodeLink> treeNodeLinkList = new ArrayList<>();
}
