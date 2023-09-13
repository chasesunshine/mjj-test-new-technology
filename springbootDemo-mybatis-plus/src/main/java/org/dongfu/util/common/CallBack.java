package org.dongfu.util.common;

import org.dongfu.entity.User;

import java.util.List;

/**
 * @author lijun
 */
public interface CallBack {

    List<User> selectUserList(String sex);
}