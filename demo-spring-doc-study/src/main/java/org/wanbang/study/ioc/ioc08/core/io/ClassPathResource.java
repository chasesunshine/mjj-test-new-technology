package org.wanbang.study.ioc.ioc08.core.io;

import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @description: TODO
 * @author majiajian
 * @date 2022/10/8 11:13
 * @version 1.0
 */

/**
 * 这一部分的实现是用于通过 ClassLoader 读取 ClassPath 下的文件信息，
 * 具体的读取过程主要是：classLoader.getResourceAsStream(path)
 */
public class ClassPathResource implements Resource {

    private final String path;

    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, (ClassLoader) null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path, "Path must not be null");
        this.path = path;
        this.classLoader = (classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader());
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = classLoader.getResourceAsStream(path);
        if (is == null) {
            throw new FileNotFoundException(
                    this.path + " cannot be opened because it does not exist");
        }
        return is;
    }
}
