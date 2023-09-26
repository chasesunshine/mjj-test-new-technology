package org.wanbang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.wanbang.entity.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User>{
    List<User> selectUserList(String sex);

    User selectUserList2(Integer id);

    //List<User> findAll();
}
