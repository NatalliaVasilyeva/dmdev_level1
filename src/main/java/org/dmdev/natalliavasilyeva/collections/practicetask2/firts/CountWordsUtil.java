package org.dmdev.natalliavasilyeva.collections.practicetask2.firts;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class CountWordsUtil {

    public static Map<String, Integer> countNumberOfEachWord(String text) {

        Map<String, Integer> map = new HashMap<>();

        String[] words = text.split(", |\\.|:|-|\\s+");
        List<String> listOfWords = Arrays.asList(words);

        for(String word: listOfWords) {
            if (!map.containsKey(word.trim())) {
                map.put(word, 1);
            } else {
                map.put(word, map.get(word) + 1);
            }
        }
        return map;
    }
}