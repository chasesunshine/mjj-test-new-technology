package org.wanbang.study.allDesignMode.behaviorMode.brokeMode.dao;

import org.wanbang.study.allDesignMode.behaviorMode.brokeMode.po.User;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/19 14:03
* @version 1.0
*/

public interface IUserDao {
    User queryUserInfoById(Long id);
}
