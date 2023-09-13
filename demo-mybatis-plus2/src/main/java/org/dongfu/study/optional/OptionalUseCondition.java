package org.dongfu.study.optional;

import java.util.Optional;

/**
 * 五、什么场景用Optional？
 * 以前一直不懂Optional有啥用，感觉太无语了，Java8还把它当做一个噱头来宣传，最近终于发现它的用处了，
 * 当然不用函数式编程的话，是没感觉的；
 *
 * 如下提供了几个应用场景，基本上都是开发当中经常遇到的。
 */
public class OptionalUseCondition {

    public void condition1(){
//        PatientInfo patientInfo = patientInfoDao.getPatientInfoById(consultOrder.getPatientId());
//        if (patientInfo != null) {
//            consultInfoResp.setPatientHead(patientInfo.getHead());
//        }
//
//        // 使用Optional 和函数式编程，一行搞定，而且像说话一样
//        Optional.ofNullable(patientInfo).ifPresent(p -> consultInfoResp.setPatientHead(p.getHead()));

    }


    public void test1() throws Exception {
        Student student = new Student(null, 3);
        if (student == null || isEmpty(student.getName())) {
            throw new Exception();
        }
        String name = student.getName();
        // 业务省略...

        // 使用Optional改造
        Optional.ofNullable(student).filter(s -> !isEmpty(s.getName())).orElseThrow(() -> new Exception());
    }
    public static boolean isEmpty(CharSequence str) {
        return str == null || str.length() == 0;
    }


/*
    public static String getChampionName(Competition comp) throws IllegalArgumentException {
        if (comp != null) {
            CompResult result = comp.getResult();
            if (result != null) {
                User champion = result.getChampion();
                if (champion != null) {
                    return champion.getName();
                }
            }
        }
        throw new IllegalArgumentException("The value of param comp isn't available.");


        // 上面的写法用Optional改写：


        return Optional.ofNullable(comp)
                .map(Competition::getResult)  // 相当于c -> c.getResult()，下同
                .map(CompResult::getChampion)
                .map(User::getName)
                .orElseThrow(()->new IllegalArgumentException("The value of param comp isn't available."));
    }
*/


    /**
     * 类型之间的转换，并且当没有值的时候返回一个默认值
     */
    public void condition4(){
//        int timeout = Optional.ofNullable(redisProperties.getTimeout())
//                .map(x -> Long.valueOf(x.toMillis()).intValue())
//                .orElse(10000);

    }


}
