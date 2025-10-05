package AlgorithmTest;
import Algorithm.Kadanes;
import Metric.Tracker;
import org.junit.Test;

import static org.junit.Assert.assertThrows;
import static org.testng.AssertJUnit.assertEquals;

public class KadanesTest {
    @Test
    public void testSimpleArray() {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Tracker tracker = new Tracker();
        var result = Kadanes.findMaxSubarray(arr, tracker);
        assertEquals(6, result.maxSum);
        assertEquals(3, result.start);
        assertEquals(6, result.end);
    }
    @Test
    public void testAllNegative() {
        int[] arr = {-5, -1, -8};
        Tracker tracker = new Tracker();
        var result = Kadanes.findMaxSubarray(arr, tracker);
        assertEquals(-1, result.maxSum);
    }
    @Test
    public void testSingleElement() {
        int[] arr = {5};
        Tracker tracker = new Tracker();
        var result = Kadanes.findMaxSubarray(arr, tracker);
        assertEquals(5, result.maxSum);
        assertEquals(0, result.start);
        assertEquals(0, result.end);
    }
    @Test
    public void testEmptyArrayThrows() {
        int[] arr = {};
        Tracker tracker = new Tracker();
        assertThrows(IllegalArgumentException.class,
                () -> Kadanes.findMaxSubarray(arr, tracker));
    }
}
