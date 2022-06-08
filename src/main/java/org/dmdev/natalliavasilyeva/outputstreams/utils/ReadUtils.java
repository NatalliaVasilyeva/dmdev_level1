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

import static java.nio.file.StandardOpenOption.*;
import static java.util.stream.Collectors.*;

public class ReadUtils {
    private static final String SEPARATOR = ",";

//    public static Map<Integer, Price> readPriceFromFile(Path filePath) throws IOException {
//        try (Stream<String> lines = Files.lines(filePath, StandardCharsets.UTF_8)) {
//            return lines
//                    .skip(1)
//                    .map(line -> line.split(SEPARATOR, 2))
//                    .collect(Collectors
//                            .toMap(array -> Integer.parseInt(array[0]),
//                                    array -> new Price(Integer.parseInt(array[0]), Double.parseDouble(array[1]))));
//        }
//    }

    public static List<Record> readDataFromFile(Path filePath, List<String> keys) throws IOException {
        List<Record> records = new ArrayList<>();
        try (Stream<String> lines = Files.lines(filePath, StandardCharsets.UTF_8)) {
            lines
                    .skip(1)
                    .map(line -> line.split(SEPARATOR))
                    .forEach(words -> {
                        Record record = new Record();
                        IntStream.range(0, words.length).forEach(i ->
                                record.put(keys.get(i), words[i]));
                        records.add(record);
                    });
        }
        return records;
    }

    public static List<String> readColumnNamesFromFile(Path filePath) throws IOException {
        try (Stream<String> lines = Files.lines(filePath, StandardCharsets.UTF_8)) {
            return lines
                    .limit(1)
                    .map(line -> line.split(SEPARATOR))
                    .flatMap(Arrays::stream)
                    .collect(Collectors.toList());
        }
    }

    public static Set<String> combineTwoLists(List<String> one, List<String> two) {
        return Stream.of(one, two)
                .flatMap(Collection::stream)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public static Set<Record> mergeListsOfRecordsToOneBySameKey(String key, List<Record> priceRecords, List<Record> descriptionRecords) {
        Set<Record> records = new LinkedHashSet<>();
        Set<String> ids = new TreeSet<>();
        for (Record priceRecord : priceRecords) {
            for (Record descriptionRecord : descriptionRecords) {
                if (!priceRecord.get(key).isEmpty() &&
                        Objects.equals(priceRecord.get(key), descriptionRecord.get(key))) {
                    Record record = new Record();
                    priceRecord.getLineKeeper().putAll(descriptionRecord.getLineKeeper());
                    record.setLineKeeper(priceRecord.getLineKeeper());
                    descriptionRecords.remove(descriptionRecord);
                    records.add(record);
                    break;
                }
            }
        }
        return records;
    }


    public static Set<Record> mergeListsOfRecordsToOneStream(String key, List<Record> priceRecords, List<Record> descriptionRecords, Set<String> ids) {
        Set<Record> records = new LinkedHashSet<>();
        priceRecords.stream()
                .filter(priceRecord -> !priceRecord.getLineKeeper().isEmpty())
                .forEach(priceRecord -> descriptionRecords.stream()
                        .map(Record::getLineKeeper)
                        .forEach(descriptionRecord -> {
                            if (Objects.equals(priceRecord.get(key), descriptionRecord.get(key))) {
                                Record newRecord = new Record();
                                Map<String, String> lines = new LinkedHashMap<>(priceRecord.getLineKeeper());
                                lines.putAll(descriptionRecord);
                                newRecord.setLineKeeper(lines);
                                records.add(newRecord);
                            } else {
                                ids.add(priceRecord.get(key));
                            }
                        }));
        return records;
    }


    public static List<String> toContentRepresentation(Set<Record> records, Set<String> columnsToExclude) {
        return records.stream()
                .map(Record::getLineKeeper)
                .filter(line -> line.keySet().removeAll(columnsToExclude))
                .map(line -> String.join(",", line.values()))
                .collect(Collectors.toList());
    }

    public static String toHeaderRepresentation(Set<String> headers, Set<String> columnsToExclude) {
        return headers.stream()
                .filter(header -> !columnsToExclude.contains(header))
                .collect(Collectors.joining(","));
    }

    public static void writeResult(Path path, Set<String> headers, Set<Record> records, Set<String> columnsToExclude) throws IOException {
        Files.write(path, toHeaderRepresentation(headers, columnsToExclude).getBytes(), CREATE, TRUNCATE_EXISTING);
        Files.write(path, "\n".getBytes(), APPEND);
        Files.write(path, toContentRepresentation(records, columnsToExclude), APPEND);
    }

    public static void writeIds(Path path, Set<String> records) throws IOException {
        Files.write(path, records, CREATE, TRUNCATE_EXISTING);
    }
}