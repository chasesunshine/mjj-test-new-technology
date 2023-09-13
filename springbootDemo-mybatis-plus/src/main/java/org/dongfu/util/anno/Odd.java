package org.dongfu.util.anno;

import org.dongfu.util.valid.AgeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Target指明这个注解要作用在什么地方，可以是对象、域、构造器等，因为要作用在age域上，因此这里选择FIELD
//@Retention指明了注解的生命周期，可以有SOURCE（仅保存在源码中，会被编译器丢弃），CLASS（在class文件中可用，会被VM丢弃）以及RUNTIME（在运行期也被保留），
//          这里选择了生命周期最长的RUNTIME
//@Constraint是最关键的，它表示这个注解是一个验证注解，并且指定了一个实现验证逻辑的验证器
//message()指明了验证失败后返回的消息，此方法为@Constraint要求
//groups()和payload()也为@Constraint要求，可默认为空，详细用途可以查看@Constraint文档

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AgeValidator.class)
public @interface Odd {
    String message() default "Age Must Be Odd";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
