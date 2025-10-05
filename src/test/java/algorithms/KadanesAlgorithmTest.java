package algorithms;
import metrics.PerformanceTracker;
import org.junit.Test;

import static org.junit.Assert.assertThrows;
import static org.testng.AssertJUnit.assertEquals;

public class KadanesAlgorithmTest {
    @Test
    public void testSimpleArray() {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        PerformanceTracker performanceTracker = new PerformanceTracker();
        var result = KadanesAlgorithm.findMaxSubarray(arr, performanceTracker);
        assertEquals(6, result.maxSum);
        assertEquals(3, result.start);
        assertEquals(6, result.end);
    }
    @Test
    public void testAllNegative() {
        int[] arr = {-5, -1, -8};
        PerformanceTracker performanceTracker = new PerformanceTracker();
        var result = KadanesAlgorithm.findMaxSubarray(arr, performanceTracker);
        assertEquals(-1, result.maxSum);
    }
    @Test
    public void testSingleElement() {
        int[] arr = {5};
        PerformanceTracker performanceTracker = new PerformanceTracker();
        var result = KadanesAlgorithm.findMaxSubarray(arr, performanceTracker);
        assertEquals(5, result.maxSum);
        assertEquals(0, result.start);
        assertEquals(0, result.end);
    }
    @Test
    public void testEmptyArrayThrows() {
        int[] arr = {};
        PerformanceTracker performanceTracker = new PerformanceTracker();
        assertThrows(IllegalArgumentException.class,
                () -> KadanesAlgorithm.findMaxSubarray(arr, performanceTracker));
    }
}
