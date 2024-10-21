package org.wanbang.common.convert;

import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import org.wanbang.common.dto.UserResp;
import org.wanbang.entity.SpringWorld;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-21T17:07:45+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_282 (Azul Systems, Inc.)"
)
@Component
public class UserConvertImpl implements UserConvert {

    @Override
    public UserResp convertToResp(SpringWorld springWorld) {
        if ( springWorld == null ) {
            return null;
        }

        UserResp userResp = new UserResp();

        userResp.setId( springWorld.getId() );
        userResp.setAge( springWorld.getAge() );
        userResp.setName( springWorld.getName() );
        userResp.setSex( springWorld.getSex() );
        userResp.setValue( springWorld.getValue() );
        userResp.setUser( springWorld.getUser() );

        return userResp;
    }
}
