package org.dmdev.natalliavasilyeva.regexp.utils;

import java.util.Random;

public class RandomUtil {
    private static final Random RANDOM = new Random();

    private RandomUtil() {
    }

    public static int getRandomNumberUsingInts(int min, int max) {
        Random random = new Random();
        return random.ints(min, max)
                .findFirst()
                .getAsInt();
    }
}