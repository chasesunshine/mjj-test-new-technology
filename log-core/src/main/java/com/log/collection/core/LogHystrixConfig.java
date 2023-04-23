package com.log.collection.core;

import com.netflix.hystrix.strategy.HystrixPlugins;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import com.netflix.hystrix.strategy.eventnotifier.HystrixEventNotifier;
import com.netflix.hystrix.strategy.executionhook.HystrixCommandExecutionHook;
import com.netflix.hystrix.strategy.metrics.HystrixMetricsPublisher;
import com.netflix.hystrix.strategy.properties.HystrixPropertiesStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author :XXX
 * @date :2020-12-18 18:01
 * @description :
 */
public class LogHystrixConfig {
    public static final Logger log = LoggerFactory.getLogger(LogHystrixConfig.class);

    public LogHystrixConfig(){
        try {
            HystrixConcurrencyStrategy target = new MdcHystrixConcurrencyStrategy();
            HystrixConcurrencyStrategy strategy = HystrixPlugins.getInstance().getConcurrencyStrategy();
            if (strategy instanceof MdcHystrixConcurrencyStrategy) {
                return;
            }
            HystrixCommandExecutionHook commandExecutionHook = HystrixPlugins
                    .getInstance().getCommandExecutionHook();
            HystrixEventNotifier eventNotifier = HystrixPlugins.getInstance()
                    .getEventNotifier();
            HystrixMetricsPublisher metricsPublisher = HystrixPlugins.getInstance()
                    .getMetricsPublisher();
            HystrixPropertiesStrategy propertiesStrategy = HystrixPlugins.getInstance()
                    .getPropertiesStrategy();

            HystrixPlugins.reset();
            HystrixPlugins.getInstance().registerConcurrencyStrategy(target);
            HystrixPlugins.getInstance()
                    .registerCommandExecutionHook(commandExecutionHook);
            HystrixPlugins.getInstance().registerEventNotifier(eventNotifier);
            HystrixPlugins.getInstance().registerMetricsPublisher(metricsPublisher);
            HystrixPlugins.getInstance().registerPropertiesStrategy(propertiesStrategy);
        }
        catch (Exception e) {
            log.error("Failed to register Sleuth Hystrix Concurrency Strategy", e);
        }
    }
}