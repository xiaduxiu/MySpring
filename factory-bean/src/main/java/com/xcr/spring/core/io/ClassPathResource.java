package com.xcr.spring.core.io;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

/**
 * @Author: xia
 * @Date: 2021/1/26 10:58
 * @Version: v1.0
 */
public class ClassPathResource implements Resource {

    private final String classpath;

    public ClassPathResource(String classpath) {
        this.classpath = classpath;
    }

    @Override
    public InputStream getInputStream() throws Exception {
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(classpath);
        if (resourceAsStream == null) {
            throw new NoSuchFileException(this.classpath + "file not exit");
        }
        return resourceAsStream;
    }
}
