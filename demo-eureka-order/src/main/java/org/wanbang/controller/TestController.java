package org.wanbang.controller;
/**
* @description: TODO
* @author majiajian
* @date 2023/4/14 13:42
* @version 1.0
*/

import lombok.extern.slf4j.Slf4j;
import org.wanbang.exception.SysEx;
import org.wanbang.feign.ItemFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {

    @Autowired
    private ItemFeignClient itemFeignClient;

    @GetMapping("/test")
    public ResponseEntity<String> test(@RequestParam("code") Integer code) {
        switch (code){
            case 1:
            case 2:
                try {
                    String s = itemFeignClient.hasThrowsEx(code);
                    return ResponseEntity.ok(s);
                } catch (SysEx e){
                    log.error(e.getResCode().toString());
                    return ResponseEntity.ok("抛出异常");
                }
            case 3:
                String s = itemFeignClient.noThrowsEx();
                ResponseEntity<String> ok = ResponseEntity.ok(s);
                return ok;
            default:
                return ResponseEntity.ok("异常");
        }
    }

}