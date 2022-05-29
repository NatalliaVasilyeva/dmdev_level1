package unit.org.dmdev.natalliavasilyeva.collections.practicetask1.firts;

import org.dmdev.natalliavasilyeva.collections.practicetask1.first.MarkLength4Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MarkLength4UtilTest {
    @Test
    public void swapSameTypeOfKeyAndValueTest() {
        //given
        List<String> words = new ArrayList<>(List.of("this", "is", "lots", "of", "fun", "for", "every", "Java", "programmer"));
        List<String> expectedResult =  new ArrayList<>(List.of("****", "this", "is", "****", "lots", "of", "fun", "for", "every", "****", "Java", "programmer"));

        //when
        List<String> actualResult = MarkLength4Util.markLength4(words, "****");

        //then
        Assertions.assertEquals(expectedResult, actualResult);
    }

}