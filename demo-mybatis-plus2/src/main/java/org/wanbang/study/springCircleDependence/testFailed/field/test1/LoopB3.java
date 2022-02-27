package org.wanbang.study.springCircleDependence.testFailed.field.test1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@Scope("prototype")
public class LoopB3 {
    @Autowired
    LoopA3 loopA3;

    public String sout() {
        return "this is class loop b";
    }
}