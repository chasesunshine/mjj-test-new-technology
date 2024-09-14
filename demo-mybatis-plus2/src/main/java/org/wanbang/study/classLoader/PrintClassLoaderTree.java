package org.wanbang.study.classLoader;

/**
 * 从输出结果可以看出：我们编写的 Java 类 PrintClassLoaderTree 的 ClassLoader 是AppClassLoader；
 *      AppClassLoader的父 ClassLoader 是ExtClassLoader；
 *      ExtClassLoader的父ClassLoader是Bootstrap ClassLoader，因此输出结果为 null
 */
public class PrintClassLoaderTree {

    public static void main(String[] args) {

        ClassLoader classLoader = PrintClassLoaderTree.class.getClassLoader();

        StringBuilder split = new StringBuilder("|--");
        boolean needContinue = true;
        while (needContinue){
            System.out.println(split.toString() + classLoader);
            if(classLoader == null){
                needContinue = false;
            }else{
                classLoader = classLoader.getParent();
                split.insert(0, "\t");
            }
        }
    }

}

