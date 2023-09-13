package org.dongfu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.dongfu.entity.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User>{
    List<User> selectUserList(String sex);

    User selectUserList2(Integer id);

    //List<User> findAll();
}
