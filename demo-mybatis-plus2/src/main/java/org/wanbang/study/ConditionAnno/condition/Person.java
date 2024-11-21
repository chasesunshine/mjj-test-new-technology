package org.wanbang.study.ConditionAnno.condition;

import lombok.Data;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

@Data
public class Person implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //返回true，则注入bean，否则忽略bean
        return false;
    }
}
