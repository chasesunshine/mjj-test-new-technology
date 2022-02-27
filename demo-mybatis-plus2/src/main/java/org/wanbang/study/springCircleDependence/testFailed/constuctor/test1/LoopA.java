package org.wanbang.study.springCircleDependence.testFailed.constuctor.test1;

import org.springframework.stereotype.Service;

@Service
public class LoopA {
    LoopB loopB;

//    public LoopA(LoopB loopB) {
//        this.loopB = loopB;
//    }

    public String sout() {
        return loopB.sout();
    }
}
