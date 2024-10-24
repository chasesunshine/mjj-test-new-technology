package org.wanbang.spi;

import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) {
        ServiceLoader<Logger> loader = ServiceLoader.load(Logger.class);
        for (Logger logger : loader) {
            logger.log("Hello, World!");
        }
    }
}