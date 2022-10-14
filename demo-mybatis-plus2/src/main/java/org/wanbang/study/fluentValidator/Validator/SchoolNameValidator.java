package org.wanbang.study.fluentValidator.Validator;

import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;

/**
* @description: TODO
* @author majiajian
* @date 2022/10/14 15:47
* @version 1.0
*/

public class SchoolNameValidator extends ValidatorHandler<String> implements Validator<String> {
    @Override
    public boolean validate(ValidatorContext context, String schoolName) {
        if (!"无锡中学".equals(schoolName)) {
            context.addErrorMsg("学校名称不正确");
            return false;
        }
        return true;
    }
}