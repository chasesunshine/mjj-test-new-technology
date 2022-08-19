package org.wanbang.study.allDesignMode.behaviorMode.brokeMode.mediator;
/**
* @description: TODO
* @author majiajian
* @date 2022/8/19 14:03
* @version 1.0
*/

public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private final Configuration configuration;
    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }
    @Override
    public DefaultSqlSession openSession() {
        return new DefaultSqlSession(configuration.connection, configuration.mapperElement);
    }
}
