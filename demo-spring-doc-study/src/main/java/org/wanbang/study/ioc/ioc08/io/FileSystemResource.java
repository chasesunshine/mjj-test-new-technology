package org.wanbang.study.ioc.ioc08.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
* @description: TODO
* @author majiajian
* @date 2022/10/8 11:13
* @version 1.0
*/

/**
 * 通过指定文件路径的方式读取文件信息，这部分大家肯定还是非常熟悉的，经常会
 * 读取一些 txt、excel 文件输出到控制台。
 */
public class FileSystemResource implements Resource {

    private final File file;

    private final String path;

    public FileSystemResource(File file) {
        this.file = file;
        this.path = file.getPath();
    }

    public FileSystemResource(String path) {
        this.file = new File(path);
        this.path = path;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this.file);
    }

    public final String getPath() {
        return this.path;
    }

}
