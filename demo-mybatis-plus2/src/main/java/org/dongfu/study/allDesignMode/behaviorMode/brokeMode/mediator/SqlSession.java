package org.dongfu.study.allDesignMode.behaviorMode.brokeMode.mediator;

import java.util.List;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/19 14:04
* @version 1.0
*/

public interface SqlSession {
    <T> T selectOne(String statement);
    <T> T selectOne(String statement, Object parameter) throws Exception;
    <T> List<T> selectList(String statement);
    <T> List<T> selectList(String statement, Object parameter);
    void close();
}
