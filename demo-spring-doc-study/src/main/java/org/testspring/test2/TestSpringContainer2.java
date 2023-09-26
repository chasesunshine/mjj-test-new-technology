package org.testspring.test2;

import org.springframework.stereotype.Component;
import org.wanbang.dao.SpringStudyDao;

import javax.annotation.Resource;

@Component
public class TestSpringContainer2 {
    @Resource
    private SpringStudyDao springStudyDao;

    public String test(){
        String a = "springContainer";
        return a;
    }
}
