package org.dmdev.natalliavasilyeva.generics.util;

import org.dmdev.natalliavasilyeva.generics.model.Pair;

public final class PairUtil {

    private PairUtil() {

    }
    public static Pair swap(Pair pair) {

        return new Pair(pair.getValue(), pair.getKey());
    }
}