package org.dmdev.natalliavasilyeva.regexp.writer;

import org.dmdev.natalliavasilyeva.regexp.dto.Entity;
import org.dmdev.natalliavasilyeva.regexp.utils.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;


public class LogFileWriter {

    public void writeLogs(Path path, Entity... logs) throws IOException {
        Files.write(path, toContentRepresentation(List.of(logs)), CREATE, APPEND);
    }

    public void writeNewLine(Path path) throws IOException {
        Files.write(path, "\n".getBytes(), APPEND);
    }
    
    private List<String> toContentRepresentation(List<? extends Entity> rows) {
        return rows.stream()
                .map(line -> buildLogRow(line.values()))
                .collect(Collectors.toList());
    }

    private String buildLogRow(List<String> values) {
        return String.join(StringUtils.SEPARATOR, values);
    }
}