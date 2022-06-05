package org.dmdev.natalliavasilyeva.streams.utils;

import org.dmdev.natalliavasilyeva.streams.model.Mark;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public final class MarkUtils {

    private MarkUtils() {
    }

    public static List<Mark> generateMarks(int numberOfMarks, Random random, int upperbound) {
        return IntStream.range(0, numberOfMarks).mapToObj(i -> new Mark("one" + i, random.nextInt(upperbound))).collect(toList());
    }
}