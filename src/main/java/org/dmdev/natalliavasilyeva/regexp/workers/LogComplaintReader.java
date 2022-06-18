package org.dmdev.natalliavasilyeva.regexp.workers;

import org.dmdev.natalliavasilyeva.regexp.dto.Complaint;
import org.dmdev.natalliavasilyeva.regexp.parser.LogFileParser;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class LogComplaintReader extends Thread {

    private final BlockingQueue<Complaint> complaints;
    private final LogFileParser parser;
    private final Path path;

    public LogComplaintReader(BlockingQueue<Complaint> complaints, LogFileParser parser, Path path) {
        this.complaints = complaints;
        this.parser = parser;
        this.path = path;
    }

    @Override
    public void run() {
        while (true) {
            try {
                List<Complaint> complaintsLog = parser.parse(path);
                complaintsLog.forEach(complaint -> {
                    try {
                        complaints.put(complaint);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
                TimeUnit.MINUTES.sleep(2);
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}