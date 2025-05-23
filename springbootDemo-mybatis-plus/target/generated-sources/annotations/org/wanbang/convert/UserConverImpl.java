package org.wanbang.convert;

import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import org.wanbang.entity.User;
import org.wanbang.entity.common.UserVo;
import org.wanbang.entity.common.UserVo1;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-01T13:31:54+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_282 (Azul Systems, Inc.)"
)
@Component
public class UserConverImpl implements UserConver {

    @Override
    public UserVo1 convert(User user) {
        if ( user == null ) {
            return null;
        }

        UserVo1 userVo1 = new UserVo1();

        userVo1.setName( user.getName() );
        userVo1.setAge( user.getAge() );
        userVo1.setSex( user.getSex() );

        return userVo1;
    }

    @Override
    public UserVo item2Dto(User user) {
        if ( user == null ) {
            return null;
        }

        UserVo userVo = new UserVo();

        userVo.setName1( user.getName() );
        userVo.setSex1( user.getSex() );
        userVo.setAge1( user.getAge() );
        userVo.setCurrent( user.getCurrent() );
        userVo.setSize( user.getSize() );
        userVo.setOrgId( user.getOrgId() );

        return userVo;
    }
}
