package org.dongfu.study.springCircleDependence.testFailed.field.test4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class LoopB6 {
    @Autowired
    LoopA6 loopA6;

    public LoopB6() {
    }

    public String sout() {
        return "this is class loop b";
    }
}