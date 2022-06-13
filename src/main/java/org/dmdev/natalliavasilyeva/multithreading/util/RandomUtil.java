package org.dmdev.natalliavasilyeva.multithreading.util;

import java.util.Random;

public final class RandomUtil {
    private static final Random RANDOM = new Random();

    private RandomUtil() {
    }

    public static int getRandomNumberUsingInts(int min, int max) {
        Random random = new Random();
        return random.ints(min, max)
                .findFirst()
                .getAsInt();
    }

    public static int getNext(int bound) {
        return RANDOM.nextInt(bound);
    }
}