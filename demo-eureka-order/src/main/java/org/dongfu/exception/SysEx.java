package org.dongfu.exception;

import lombok.Builder;
import lombok.Data;
import org.dongfu.common.ResCode;

/**
* @description: TODO
* @author majiajian
* @date 2023/4/14 14:35
* @version 1.0
*/

@Data
@Builder
public class SysEx extends RuntimeException{
    private ResCode resCode;

    public SysEx(ResCode resCode) {
        super(resCode.getMsg());
        this.resCode = resCode;
    }
}