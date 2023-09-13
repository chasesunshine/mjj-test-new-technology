package org.dongfu.study.springCircleDependence.testFailed.field.test3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoopB5 {
    @Autowired
    LoopA5 loopA5;

    public String sout() {
        return "this is class loop b";
    }
}

