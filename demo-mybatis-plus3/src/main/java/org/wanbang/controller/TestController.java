package org.wanbang.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.wanbang.common.entity.Result;
import org.wanbang.service.TestService;

import javax.annotation.Resource;

/**
* @description: TODO
* @author majiajian
* @date 2022/6/22 16:14
* @version 1.0
*/

@Component
@RestController
@RequestMapping("/rpc")
public class TestController {
    @Resource
    private TestService testService;

    /**
     * 批量导入 企业培训价格
     *
     * @param file
     * @return
     */
    @PostMapping("/import/file")
    public Result importFile(@RequestParam(value = "file", required = false) MultipartFile file) {
        return testService.importFile(file);
    }

}
