package org.dmdev.natalliavasilyeva.regexp.workers;

import org.dmdev.natalliavasilyeva.regexp.model.Call;
import org.dmdev.natalliavasilyeva.regexp.writer.LogFileWriter;

import java.io.IOException;
import java.nio.file.Path;
import java.util.concurrent.BlockingQueue;

public class LogCallWriter extends Thread{

    private final BlockingQueue<Call> calls;
    private final LogFileWriter writer;
    private final Path path;

    public LogCallWriter(BlockingQueue<Call> calls, LogFileWriter writer, Path path) {
        this.calls = calls;
        this.writer = writer;
        this.path = path;
    }

    @Override
    public void run() {
        while(true) {
            try {
                writer.writeLogs(path, calls.take());
            } catch (InterruptedException | IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}