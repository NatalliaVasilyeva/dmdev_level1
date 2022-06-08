package org.dmdev.natalliavasilyeva.outputstreams.utils;

import org.dmdev.natalliavasilyeva.outputstreams.model.Record;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommonUtils {

    public static Set<String> combineTwoLists(List<String> one, List<String> two) {
        return Stream.of(one, two)
                .flatMap(Collection::stream)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public static Set<Record> mergeTwoMapsToOneRecordsSet(Map<String, Record> priceRecords, Map<String, Record> descriptionRecords, Set<String> ids) {
        Set<Record> records = new LinkedHashSet<>();
        priceRecords.keySet().forEach(priceKey -> {
            if (descriptionRecords.containsKey(priceKey)) {
                Record record = new Record();
                Map<String, String> mergedMap = new LinkedHashMap<>(priceRecords.get(priceKey).getLineKeeper());
                mergedMap.putAll(descriptionRecords.get(priceKey).getLineKeeper());
                record.setLineKeeper(mergedMap);
                records.add(record);
                descriptionRecords.remove(priceKey);
            } else {
                ids.add(priceKey);
            }
        });
        ids.addAll(descriptionRecords.keySet());
        return records;
    }
}