package org.dmdev.natalliavasilyeva.outputstreams.utils;

import org.dmdev.natalliavasilyeva.outputstreams.model.Record;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.nio.file.StandardOpenOption.*;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;

public class WriteUtils {

    public static void writeResult(Path path, Set<String> headers, Set<Record> records, Set<String> columnsToExclude) throws IOException {
        Files.write(path, toHeaderRepresentation(headers, columnsToExclude).getBytes(), CREATE, TRUNCATE_EXISTING);
        Files.write(path, Constants.NEXT_LINE.getBytes(), APPEND);
        Files.write(path, toContentRepresentation(records, columnsToExclude), APPEND);
    }

    public static void writeIds(Path path, Set<String> records) throws IOException {
        Files.write(path, records, CREATE, TRUNCATE_EXISTING);
    }

    private static List<String> toContentRepresentation(Set<Record> records, Set<String> columnsToExclude) {
        return records.stream()
                .map(Record::getLineKeeper)
                .filter(line -> line.keySet().removeAll(columnsToExclude))
                .map(line -> String.join(Constants.SEPARATOR, line.values()))
                .collect(Collectors.toList());
    }

    private static String toHeaderRepresentation(Set<String> headers, Set<String> columnsToExclude) {
        return headers.stream()
                .filter(header -> !columnsToExclude.contains(header))
                .collect(Collectors.joining(Constants.SEPARATOR));
    }
}