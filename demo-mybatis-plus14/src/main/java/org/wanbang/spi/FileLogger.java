package org.wanbang.spi;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileLogger implements Logger {
    @Override
    public void log(String message) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("log.txt", true))) {
            writer.println("File: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
