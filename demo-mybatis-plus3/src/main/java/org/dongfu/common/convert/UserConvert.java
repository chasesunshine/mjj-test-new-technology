package org.dongfu.common.convert;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import org.dongfu.common.dto.UserResp;
import org.dongfu.entity.SpringWorld;

/**
* @description: TODO
* @author majiajian
* @date 2022/11/23 14:30
* @version 1.0
*/

@Mapper(componentModel = "spring")
@Component
public interface UserConvert {

    UserResp convertToResp(SpringWorld springWorld);
}