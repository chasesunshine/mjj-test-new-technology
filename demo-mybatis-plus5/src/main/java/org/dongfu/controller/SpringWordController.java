package org.dongfu.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.*;
import org.dongfu.dto.UserDTO;
import org.dongfu.dto.response.ResponseData;
import org.dongfu.entity.SpringWorld;
import org.dongfu.service.SpringWordService;

import javax.annotation.Resource;

/**
 * (SpringWord)表控制层
 *
 * @author makejava
 * @since 2022-06-16 10:17:35
 */
@Slf4j
@RestController
@RequestMapping("springWordTest5")
public class SpringWordController {
    @Resource
    private SpringWordService springWordService;

    @GetMapping("/selectOne")
    public String selectOne() {
        SpringWorld springWorld = springWordService.queryById((long) 1);
        return JSON.toJSONString(springWorld);
    }

    @GetMapping("/{id}")
    public ResponseData<UserDTO> detail(@PathVariable Long id) {
        Preconditions.checkNotNull(id, "id is null");

        log.info("user id:{}", id);

        UserDTO userDTO = new UserDTO();
        userDTO.setId(id);
        userDTO.setAge(20);
        userDTO.setUsername("加班写Bug");

        return ResponseData.success(userDTO);
    }

}

