package org.dmdev.natalliavasilyeva.outputstreams.utils;

import org.dmdev.natalliavasilyeva.outputstreams.model.Record;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class ReadUtils {

    public static Map<String, Record> readDataFromFile(Path filePath, List<String> keys) throws IOException {
        Map<String, Record> records = new LinkedHashMap<>();
        try (Stream<String> lines = Files.lines(filePath, StandardCharsets.UTF_8)) {
            lines
                    .skip(1)
                    .map(line -> line.split(Constants.SEPARATOR))
                    .forEach(words -> {
                        Record record = new Record();
                        IntStream.range(0, words.length).forEach(i ->
                                record.put(keys.get(i), words[i]));
                        records.put(record.get(Constants.KEY), record);
                    });
        }
        return records;
    }

    public static List<String> readColumnNamesFromFile(Path filePath) throws IOException {
        try (Stream<String> lines = Files.lines(filePath, StandardCharsets.UTF_8)) {
            return lines
                    .limit(1)
                    .map(line -> line.split(Constants.SEPARATOR))
                    .flatMap(Arrays::stream)
                    .collect(Collectors.toList());
        }
    }
}