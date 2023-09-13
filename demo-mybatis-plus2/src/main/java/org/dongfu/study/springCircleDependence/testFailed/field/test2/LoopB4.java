package org.dongfu.study.springCircleDependence.testFailed.field.test2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
public class LoopB4 {
    @Autowired
    LoopA4 loopA4;

    public String sout() {
        return "this is class loop b";
    }
}
