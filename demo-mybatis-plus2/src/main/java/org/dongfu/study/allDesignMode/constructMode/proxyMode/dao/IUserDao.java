package org.dongfu.study.allDesignMode.constructMode.proxyMode.dao;

import org.dongfu.study.allDesignMode.constructMode.proxyMode.anno.Select;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/18 16:08
* @version 1.0
*/

public interface IUserDao {
    @Select("select userName from user where id = #{uId}")
    String queryUserInfo(String uId);
}
