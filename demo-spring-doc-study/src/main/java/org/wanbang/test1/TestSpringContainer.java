package org.wanbang.test1;

import org.springframework.stereotype.Component;
import org.wanbang.dao.SpringStudyDao;

import javax.annotation.Resource;

@Component
public class TestSpringContainer {
    @Resource
    private SpringStudyDao springStudyDao;

    public String test(){
        String a = "springContainer";
        return a;
    }
}
