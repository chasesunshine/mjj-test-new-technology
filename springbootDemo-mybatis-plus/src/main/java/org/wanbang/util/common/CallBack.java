package org.wanbang.util.common;

import org.wanbang.entity.User;

import java.util.List;

/**
 * @author lijun
 */
public interface CallBack {

    List<User> selectUserList(String sex);
}