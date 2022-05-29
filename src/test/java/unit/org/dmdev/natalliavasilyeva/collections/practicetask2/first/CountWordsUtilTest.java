package unit.org.dmdev.natalliavasilyeva.collections.practicetask2.first;

import org.dmdev.natalliavasilyeva.collections.practicetask2.firts.CountWordsUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class CountWordsUtilTest {

    @Test
    public void countNumberOfEachWordTest() {
        //given
        String text = "aaa bbb ABS aaa KKK, LLL, LLL";
        Map<String, Integer> expectedResult = Map.of("aaa", 2, "bbb", 1, "ABS", 1, "KKK", 1, "LLL", 2);

        //when
       Map<String, Integer> actualResult = CountWordsUtil.countNumberOfEachWord(text);

        //then
        Assertions.assertEquals(expectedResult, actualResult);
    }
}