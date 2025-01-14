package org.wanbang.validationTest.anno.valid;



import org.wanbang.validationTest.anno.Name;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameValid implements ConstraintValidator<Name,String> {
    private String[] orgId = {"fxjk","fxyjk"};

    @Override
    public void initialize(Name constraintAnnotation) {

    }

    @Override
    public boolean isValid(String o, ConstraintValidatorContext constraintValidatorContext) {
        if(orgId[0].equals(o) || orgId[1].equals(o)){
            return true;
        }else {
            //禁用默认的message的值
            constraintValidatorContext.disableDefaultConstraintViolation();
            if(o == null){
                //重新添加错误提示语句
                constraintValidatorContext.buildConstraintViolationWithTemplate("机构号为 null").addConstraintViolation();
            }else if("".equals(o)){
                constraintValidatorContext.buildConstraintViolationWithTemplate("机构号为 空字符串").addConstraintViolation();
            }else{
                constraintValidatorContext.buildConstraintViolationWithTemplate("机构号不为 fxjk 或 fxyjk").addConstraintViolation();
            }
            return false;
        }

    }

//    public static boolean isMobile(String str) {
//        Pattern p = null;
//        Matcher m = null;
//        boolean b = false;
//        String s2="^[1](([3|5|8][\\d])|([4][4,5,6,7,8,9])|([6][2,5,6,7])|([7][^9])|([9][1,8,9]))[\\d]{8}$";// 验证手机号
//        if(!StringUtils.isEmpty(str)){
//            p = Pattern.compile(s2);
//            m = p.matcher(str);
//            b = m.matches();
//        }
//        return b;
//    }
}