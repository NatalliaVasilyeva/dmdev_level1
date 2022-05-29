package unit.org.dmdev.natalliavasilyeva.generics;

import org.dmdev.natalliavasilyeva.generics.model.Pair;
import org.dmdev.natalliavasilyeva.generics.util.PairUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PairUtilTest {

    @Test
    public void swapSameTypeOfKeyAndValueTest() {
        //given
        Pair<String, String> pair = new Pair<>("hello", "world");

        //when
        Pair swapPair = PairUtil.swap(pair);

        //then
        Assertions.assertEquals(swapPair.getKey(), pair.getValue());
        Assertions.assertEquals(swapPair.getValue(), pair.getKey());
    }

    @Test
    public void swapSameDifferentTypeOfKeyAndValueTest() {
        //given
        Pair<Integer, String> pair = new Pair<>(15, "world");

        //when
        Pair swapPair = PairUtil.swap(pair);

        //then
        Assertions.assertEquals(swapPair.getKey(), pair.getValue());
        Assertions.assertEquals(swapPair.getValue(), pair.getKey());
    }
}