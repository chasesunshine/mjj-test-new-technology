package org.dongfu.service.impl;

import org.dongfu.entity.User;
import org.dongfu.dao.UserDao;
import org.dongfu.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jjh
 * @since 2022-11-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

}
