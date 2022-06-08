package org.dmdev.natalliavasilyeva.outputstreams.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Record {
    private Map<String, String> lineKeeper;

    public Record() {
        this.lineKeeper = new LinkedHashMap<>();
    }

    public Map<String, String> getLineKeeper() {
        return lineKeeper;
    }

    public void setLineKeeper(Map<String, String> lineKeeper) {
        this.lineKeeper = lineKeeper;
    }

    public void put(String key, String val) {
        lineKeeper.put(key, val);
    }

    public String get(String key) {
        return lineKeeper.get(key);
    }

    @Override
    public String toString() {
        return "Record{" +
                " lineKeeper=" + lineKeeper +
                '}';
    }
}