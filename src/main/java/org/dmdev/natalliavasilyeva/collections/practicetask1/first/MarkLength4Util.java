package org.dmdev.natalliavasilyeva.collections.practicetask1.first;

import java.util.List;
import java.util.ListIterator;

public final class MarkLength4Util {

    private final static int ELEMENT_LENGTH = 4;

    private MarkLength4Util() {
    }

    public static List<String> markLength4(List<String> wordList, String additionalElement) {
        ListIterator<String> iterator = wordList.listIterator();
        while (iterator.hasNext()) {
            String nextValue = iterator.next();
            if (nextValue.length() == ELEMENT_LENGTH) {
                iterator.set(additionalElement);
                iterator.add(nextValue);
            }
        }
        return wordList;
    }
}