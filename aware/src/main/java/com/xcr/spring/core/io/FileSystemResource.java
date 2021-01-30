package com.xcr.spring.core.io;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

/**
 * @Author: xia
 * @Date: 2021/1/26 10:54
 * @Version: v1.0
 */
public class FileSystemResource implements Resource{
    private final String filePath;

    public FileSystemResource(String path) {
        this.filePath = path;
    }

    @Override
    public InputStream getInputStream() throws Exception {
        Path path = new File(filePath).toPath();
        return Files.newInputStream(path);
    }
}
