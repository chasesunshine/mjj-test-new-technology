package org.wanbang.validationTest;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Service
@Validated
public class MyService {

    // 使用 @Validated 来校验方法参数
    public String processOrder(@Valid UserEntity userEntity) {
        // 方法逻辑
        return "Processing order: " + userEntity;
    }
}
