package org.wanbang.common.convert;

import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import org.wanbang.common.dto.UserResp;
import org.wanbang.entity.SpringWorld;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-23T14:37:20+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_221 (Oracle Corporation)"
)
@Component
public class UserConvertImpl implements UserConvert {

    @Override
    public UserResp convertToResp(SpringWorld springWorld) {
        if ( springWorld == null ) {
            return null;
        }

        UserResp userResp = new UserResp();

        return userResp;
    }
}