package org.dmdev.natalliavasilyeva.outputstreams;

import org.dmdev.natalliavasilyeva.outputstreams.model.Record;
import org.dmdev.natalliavasilyeva.outputstreams.utils.CommonUtils;
import org.dmdev.natalliavasilyeva.outputstreams.utils.ReadUtils;
import org.dmdev.natalliavasilyeva.outputstreams.utils.WriteUtils;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class CsvRunner {
    public static void main(String[] args) throws IOException {

        Path pricePath = Path.of("src", "main", "resources", "items-price.csv");
        Path descriptionPath = Path.of("src", "main", "resources", "items-description.csv");

        List<String> priceColumns = ReadUtils.readColumnNamesFromFile(pricePath);
        Map<String, Record> priceRecords = ReadUtils.readDataFromFile(pricePath, priceColumns);

        List<String> nameColumns = ReadUtils.readColumnNamesFromFile(descriptionPath);
        Map<String, Record> nameRecords = ReadUtils.readDataFromFile(descriptionPath, nameColumns);

        Set<String> combineColumns = CommonUtils.combineTwoLists(priceColumns, nameColumns);

        Set<String> ids = new TreeSet<>();
        Set<Record> records = CommonUtils.mergeTwoMapsToOneRecordsSet(priceRecords, nameRecords, ids);

        Path resultPath = Path.of("src", "main", "resources", "task1-result.txt");
        Set<String> setOfExcludingFields = Set.of("DESCRIPTION");
        WriteUtils.writeResult(resultPath, combineColumns, records, setOfExcludingFields);

        Path idsPath = Path.of("src", "main", "resources", "wrong-result.txt");
        WriteUtils.writeIds(idsPath, ids);

    }
}