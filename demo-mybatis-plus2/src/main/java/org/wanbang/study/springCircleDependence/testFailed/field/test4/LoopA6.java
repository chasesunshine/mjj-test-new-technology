package org.wanbang.study.springCircleDependence.testFailed.field.test4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoopA6 {
    @Autowired
    LoopB6 loopB6;

    public LoopA6() {
    }

    public String sout() {
        return loopB6.sout();
    }
}
