
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NumberRangeSummarizerJunitTest {

    private NumberRangeSummarizer numberRangeSummarizer;

    @BeforeEach
    public void setUp() {
        numberRangeSummarizer = new NumberRangeSummarizerImpleme();
    }

    @Test
    public void testCollect() {
        Collection<Integer> result = numberRangeSummarizer.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
        List<Integer> expected = Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
        assertEquals(expected, result);
    }

    @Test
    public void testCollectWithEmptyInput() {
        Collection<Integer> result = numberRangeSummarizer.collect("");
        List<Integer> expected = Arrays.asList();
        assertEquals(expected, result);
    }

    @Test
    public void testCollectWithNullInput() {
        Collection<Integer> result = numberRangeSummarizer.collect(null);
        List<Integer> expected = Arrays.asList();
        assertEquals(expected, result);
    }

    @Test
    public void testSummarizeCollection() {
        Collection<Integer> input = Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
        String result = numberRangeSummarizer.summarizeCollection(input);
        String expected = "1, 3, 6-8, 12-15, 21-24, 31";
        assertEquals(expected, result);
    }

    @Test
    public void testSummarizeCollectionWithEmptyInput() {
        Collection<Integer> input = Arrays.asList();
        String result = numberRangeSummarizer.summarizeCollection(input);
        String expected = "";
        assertEquals(expected, result);
    }

}
