package org.wanbang.util.valid;

import org.wanbang.util.anno.Odd;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//验证器有两个类型参数，第一个是所属的注解，第二个是注解作用地方的类型，这里因为作用在age上，因此这里用了Integer
//initialize()可以在验证开始前调用注解里的方法，从而获取到一些注解里的参数，这里用不到
//isValid()就是判断是否合法的地方
public class AgeValidator implements ConstraintValidator<Odd,Integer> {
    @Override
    public void initialize(Odd constraintAnnotation) {
    }

    @Override
    public boolean isValid(Integer age, ConstraintValidatorContext constraintValidatorContext) {
        return age % 2 != 0;
    }
}
