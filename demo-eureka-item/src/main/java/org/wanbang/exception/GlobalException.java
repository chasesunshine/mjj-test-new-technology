package org.wanbang.exception;

import lombok.extern.slf4j.Slf4j;
import org.wanbang.common.R;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
* @description: TODO
* @author majiajian
* @date 2023/4/14 14:57
* @version 1.0
*/
@RestControllerAdvice
@Slf4j
public class GlobalException {

    @ExceptionHandler(SysEx.class)
    public ResponseEntity<R<?>> sysEx(SysEx e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(R.error(e.getResCode()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> runtimeEx(Exception e){
        return ResponseEntity.status(500).body("error");
    }

}
