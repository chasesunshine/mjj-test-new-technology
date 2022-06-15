package com.dongfu.controller;

import com.dongfu.service.WorldUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("world/user")
public class WorldUserController {
    @Resource
    private WorldUserService worldUserService;

    @GetMapping("/selectOne")
    public String  selectOne(){
        String s = worldUserService.selectOne();
        return s;
    }

    /**
     * 测试重定向
     * @param httpServletResponse
     * @return
     * @throws IOException
     */
    @GetMapping("/selectOne1")
    public String  selectOne1(HttpServletResponse httpServletResponse) throws IOException {
        String s = worldUserService.selectOne1();
        //httpServletResponse.sendRedirect("https://www.baidu.com/?tn=40020637_5_oem_dg");

        return s;
    }

    /**
     * 测试重定向
     * @param httpServletResponse
     * @return
     * @throws IOException
     */
    @GetMapping("/selectOne2")
    public String  selectOne2(HttpServletResponse httpServletResponse){

        return (String) Optional.ofNullable(null)
                .orElseThrow(() -> new RuntimeException("mdProdInst查询为空"));
    }
}
