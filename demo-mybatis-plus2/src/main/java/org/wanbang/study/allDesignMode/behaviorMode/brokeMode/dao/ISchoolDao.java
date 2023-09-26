package org.wanbang.study.allDesignMode.behaviorMode.brokeMode.dao;

import org.wanbang.study.allDesignMode.behaviorMode.brokeMode.po.School;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/19 14:02
* @version 1.0
*/

public interface ISchoolDao {
    School querySchoolInfoById(Long treeId);
}
