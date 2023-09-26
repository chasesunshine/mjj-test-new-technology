package org.wanbang.study.springCircleDependence.testFailed.field.test2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//先被controller调用该类
@Service
//@Scope("prototype")
public class LoopA4 {
    @Autowired
    LoopB4 loopB4;

    public String sout() {
        return loopB4.sout();
    }
}