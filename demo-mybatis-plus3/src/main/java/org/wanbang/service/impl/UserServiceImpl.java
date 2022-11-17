package org.wanbang.service.impl;

import org.wanbang.entity.User;
import org.wanbang.dao.UserDao;
import org.wanbang.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jjh
 * @since 2022-11-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

}
