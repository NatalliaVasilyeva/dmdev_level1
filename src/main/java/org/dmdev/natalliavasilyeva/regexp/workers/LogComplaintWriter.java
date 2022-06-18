package org.dmdev.natalliavasilyeva.regexp.workers;

import org.dmdev.natalliavasilyeva.regexp.dto.Complaint;
import org.dmdev.natalliavasilyeva.regexp.parser.LogFileParser;
import org.dmdev.natalliavasilyeva.regexp.utils.RandomUtil;
import org.dmdev.natalliavasilyeva.regexp.writer.LogFileWriter;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class LogComplaintWriter extends Thread {

    private final LogFileWriter writer;
    private final Path path;

    public LogComplaintWriter(LogFileWriter writer, Path path) {
        this.writer = writer;
        this.path = path;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(30);

            int numberOfLogRows = RandomUtil.getRandomNumberUsingInts(30, 100);
            int lastComplaintId = LogFileParser.lineCounter.get();

            writer.writeNewLine(path);
            for (int i = 0; i < numberOfLogRows; i++) {
                writer.writeLogs(path, new Complaint(++lastComplaintId, LocalDateTime.now(), "Vasia Ivanov", "+375 (29) 123 45 67", "all are bad"));
                TimeUnit.MILLISECONDS.sleep(500);
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}