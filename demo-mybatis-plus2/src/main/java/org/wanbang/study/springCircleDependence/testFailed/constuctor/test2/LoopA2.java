package org.wanbang.study.springCircleDependence.testFailed.constuctor.test2;

import org.springframework.stereotype.Service;

@Service
public class LoopA2 {

    public LoopA2(LoopB2 loopB2) {
    }

}
