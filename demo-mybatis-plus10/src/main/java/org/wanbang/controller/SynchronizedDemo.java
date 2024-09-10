package org.wanbang.controller;

/**
 * 通过 JDK 自带的 javap 命令查看类的相关字节码信息:
 * 首先切换到类的对应目SynchronizedDemo命令生成编译后的 .class 文件，
 * 然后执行 javap -c -s -v -l SynchronizedDemo.class
 *
 */
public class SynchronizedDemo {
    public void method() {
        synchronized (this) {
            System.out.println("synchronized 􀕤􁎱􀣘");
        }
    }
}
