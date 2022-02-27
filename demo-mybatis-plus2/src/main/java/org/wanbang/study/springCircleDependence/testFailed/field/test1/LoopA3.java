package org.wanbang.study.springCircleDependence.testFailed.field.test1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@Scope("prototype")
public class LoopA3 {
    @Autowired
    LoopB3 loopB3;

    public String sout() {
        return loopB3.sout();
    }
}

