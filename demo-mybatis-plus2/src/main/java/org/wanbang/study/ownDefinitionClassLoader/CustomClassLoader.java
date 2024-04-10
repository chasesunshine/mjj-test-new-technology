package org.wanbang.study.ownDefinitionClassLoader;

import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CustomClassLoader extends ClassLoader {

    // 自定义类加载器必须提供一个加载类文件的位置
    private String classesPath;

    public CustomClassLoader(String classesPath, ClassLoader parent) {
        // 自定义类加载器的类路径 classesPath 和父加载器 parent
        super(parent);
        this.classesPath = classesPath;
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        //首先,检查已加载的类
        Class<?> loadedClass = findLoadedClass(name);

        if (loadedClass == null) {
            // 如果已加载类中没有该类, 尝试用自定义的方法加载
            try {
                loadedClass = findClassInPath(name);
            } catch (ClassNotFoundException e) {
                // 如果自定义加载方法找不到类,则委托给父类加载器
                loadedClass = super.loadClass(name, resolve);
            }
        }

        if (resolve) {
            resolveClass(loadedClass);
        }

        return loadedClass;
    }

    private Class<?> findClassInPath(String className) throws ClassNotFoundException {
        try {
            String filePath = className.replace('.', '/') + ".class";
            byte[] classBytes = Files.readAllBytes(Paths.get(classesPath, filePath));

            return defineClass(className, classBytes, 0, classBytes.length);
        } catch (Exception e) {
            throw new ClassNotFoundException("Class not found in classes path: " + className, e);
        }
    }

    public static void main(String[] args) throws Exception {
        String pathToClasses = "src/main/java/org/wanbang/study/ownDefinitionClassLoader/classPath";
        String className = "org.wanbang.study.ownDefinitionClassLoader.classPath.SampleClass";
        String methodName = "sampleMethod";

        // 创建自定义类加载器实例，将类的加载权交给它
        CustomClassLoader customClassLoader = new CustomClassLoader(pathToClasses, CustomClassLoader.class.getClassLoader());

        // 使用自定义类加载器加载类
        Class<?> customClass = customClassLoader.loadClass(className);

        // 创建类的实例并调用方法
        Object obj = customClass.newInstance();
        Method method = customClass.getDeclaredMethod(methodName);
        method.setAccessible(true);
        method.invoke(obj);

    }
}


