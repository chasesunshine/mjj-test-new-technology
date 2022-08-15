package org.wanbang.study.allDesignMode.constructMode.appearanceMode.config;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/12 19:25
* @version 1.0
*/

@Service
public class StarterService {
    private static String userStr;

    public String[] split(String separatorChar) {
        String[] split = StringUtils.split(this.userStr, separatorChar);
        return split;
    }

    public StarterService setvalue(String userStr) {
        this.userStr = userStr;
        return new StarterService();
    }
}
