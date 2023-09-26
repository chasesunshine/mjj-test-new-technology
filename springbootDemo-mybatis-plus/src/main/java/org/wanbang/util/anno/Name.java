package org.wanbang.util.anno;

import org.wanbang.util.anno.valid.NameValid;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author chasesunshine
 */
@Documented
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NameValid.class)
public @interface Name {

    String message() default "名字未填或格式错误";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}