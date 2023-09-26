package org.wanbang.study.springCircleDependence.testFailed.constuctor.test1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoopB {
    LoopA loopA;

//    public LoopB(LoopA loopA) {
//        this.loopA = loopA;
//    }

    public String sout() {
        return "this is class loop b";
    }
}