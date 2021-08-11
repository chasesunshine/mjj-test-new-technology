package org.wanbang.convert;

import org.wanbang.pojo.User;
import org.wanbang.pojo.common.UserVo;
import org.wanbang.pojo.common.UserVo1;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface UserConver {

    UserVo1 convert(User user);

    @Mappings({
            @Mapping(source = "name",target = "name1"),
            @Mapping(source = "age",target = "age1"),
            @Mapping(source = "sex",target = "sex1")
    })
    UserVo item2Dto(User user);

}

