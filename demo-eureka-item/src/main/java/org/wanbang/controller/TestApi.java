package org.wanbang.controller;

import org.wanbang.common.ResCode;
import org.wanbang.exception.SysEx;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
* @description: TODO
* @author majiajian
* @date 2023/4/14 14:49
* @version 1.0
*/

@RestController
public class TestApi {
    @GetMapping("/no-throws-ex")
    public ResponseEntity<String> noThrowsEx(){
        return ResponseEntity.ok("noThrowsEx");
    }

    @GetMapping("/has-throws-ex")
    public ResponseEntity<String> hasThrowsEx(@RequestParam("code") Integer code){
        switch (code){
            case 1:
                throw new SysEx(ResCode.E_1000);
            default:
                return ResponseEntity.ok("hasThrowsEx");
        }
    }
}
