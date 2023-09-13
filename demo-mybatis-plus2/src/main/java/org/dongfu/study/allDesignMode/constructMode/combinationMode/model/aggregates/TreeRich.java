package org.dongfu.study.allDesignMode.constructMode.combinationMode.model.aggregates;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.dongfu.study.allDesignMode.constructMode.combinationMode.model.vo.TreeNode;
import org.dongfu.study.allDesignMode.constructMode.combinationMode.model.vo.TreeRoot;

import java.util.HashMap;
import java.util.Map;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/11 20:19
* @version 1.0
*/

@AllArgsConstructor
@Data
public class TreeRich {
    TreeRoot treeRoot;

    Map<Long, TreeNode> treeNodeMap = new HashMap<>();

}
