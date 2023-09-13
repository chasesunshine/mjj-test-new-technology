package org.dongfu.study.fluentValidator.controller;

import com.alibaba.fastjson.JSON;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.dongfu.study.fluentValidator.Validator.SchoolNameValidator;
import org.dongfu.study.fluentValidator.entity.StudentDto;

import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toSimple;

@Slf4j
@RestController
@RequestMapping("test")
public class ValidatorTestController {

    @GetMapping("/selectOne")
    public String  selectOne(){
        StudentDto studentDto = new StudentDto("张三", 18, "苏州中学", "无锡");
        Result result = FluentValidator.checkAll()
                        .on(studentDto.getSchoolName(), new SchoolNameValidator())
                        .doValidate()
                        .result(toSimple());
        return JSON.toJSONString(result);
    }
}
