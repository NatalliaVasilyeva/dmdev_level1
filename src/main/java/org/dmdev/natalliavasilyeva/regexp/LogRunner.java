package org.dmdev.natalliavasilyeva.regexp;

import org.dmdev.natalliavasilyeva.regexp.model.Call;
import org.dmdev.natalliavasilyeva.regexp.model.Complaint;
import org.dmdev.natalliavasilyeva.regexp.parser.LogFileParser;
import org.dmdev.natalliavasilyeva.regexp.workers.Dispatcher;
import org.dmdev.natalliavasilyeva.regexp.workers.LogCallWriter;
import org.dmdev.natalliavasilyeva.regexp.workers.LogComplaintReader;
import org.dmdev.natalliavasilyeva.regexp.workers.LogComplaintWriter;
import org.dmdev.natalliavasilyeva.regexp.writer.LogFileWriter;

import java.nio.file.Path;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Stream;

public class LogRunner {
    public static void main(String[] args) {

        Path complaintPath = Path.of("src", "main", "resources", "complaintLog.csv");
        Path callPath = Path.of("src", "main", "resources", "callLog.csv");
        BlockingQueue<Complaint> complaints = new LinkedBlockingQueue<>();
        BlockingQueue<Call> calls = new LinkedBlockingQueue<>();

        LogFileParser logFileParser = new LogFileParser();
        LogFileWriter logFileWriter = new LogFileWriter();

        LogComplaintReader logComplaintReader = new LogComplaintReader(complaints, logFileParser, complaintPath);
        LogComplaintWriter logComplaintWriter = new LogComplaintWriter(logFileWriter, complaintPath);
        LogCallWriter logCallWriter = new LogCallWriter(calls, logFileWriter, callPath);
        Dispatcher firstDispatcher = new Dispatcher("First", complaints, calls);
        Dispatcher secondDispatcher = new Dispatcher("Second", complaints, calls);

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Stream.of(logComplaintReader, logComplaintWriter, logCallWriter, firstDispatcher, secondDispatcher)
                .forEach(executorService::execute);

        executorService.shutdown();
    }
}