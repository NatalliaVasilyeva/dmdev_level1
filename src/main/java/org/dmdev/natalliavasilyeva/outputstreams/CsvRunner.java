package org.dmdev.natalliavasilyeva.outputstreams;

import org.dmdev.natalliavasilyeva.outputstreams.model.Record;
import org.dmdev.natalliavasilyeva.outputstreams.utils.ReadUtils;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class CsvRunner {
    public static void main(String[] args) throws IOException {

        Path pricePath = Path.of("src", "main", "resources", "items-price.csv");
        Path namePath = Path.of("src", "main", "resources", "items-name.csv");

        List<String> priceColumns = ReadUtils.readColumnNamesFromFile(pricePath);
        List<Record> priceRecords = ReadUtils.readDataFromFile(pricePath, priceColumns);

        List<String> nameColumns = ReadUtils.readColumnNamesFromFile(namePath);
        List<Record> nameRecords = ReadUtils.readDataFromFile(namePath, nameColumns);

        Set<String> combineColumns = ReadUtils.combineTwoLists(priceColumns, nameColumns);


        Set<String> ids = new TreeSet<>();
        Set<Record> records = ReadUtils.mergeListsOfRecordsToOneStream("ID", priceRecords, nameRecords, ids);

        Path resultPath = Path.of("src", "main", "resources", "task1-result.txt");
        ReadUtils.writeResult(resultPath, combineColumns, records, Set.of("DESCRIPTION"));

        Path idsPath = Path.of("src", "main", "resources", "wrong-result.txt");
        ReadUtils.writeIds(idsPath, ids);

    }
}