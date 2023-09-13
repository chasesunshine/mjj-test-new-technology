package org.dongfu.study.springCircleDependence.testFailed.field.test3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoopA5 {
    @Autowired
    LoopB5 loopB5;

    public String sout() {
        return loopB5.sout();
    }
}

