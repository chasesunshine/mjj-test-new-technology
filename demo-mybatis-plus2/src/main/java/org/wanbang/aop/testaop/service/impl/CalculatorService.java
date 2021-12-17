package org.wanbang.aop.testaop.service.impl;

import org.springframework.stereotype.Service;
import org.wanbang.aop.testaop.service.ICalculatorService;

@Service
public class CalculatorService implements ICalculatorService {

    @Override
    public int mul(int a, int b) {
        return a*b;
    }

    @Override
    public int div(int a, int b) {
        return a/b;
    }

}