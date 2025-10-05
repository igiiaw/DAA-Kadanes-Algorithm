package cli;

import algorithms.KadanesAlgorithm;
import metrics.PerformanceTracker;
import java.util.Random;

public class BenchmarkRunner {
    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000, 100000};
        Random random = new Random();
        for (int n : sizes) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = random.nextInt(2001) - 1000; // values from -1000 to 1000
            PerformanceTracker performanceTracker = new PerformanceTracker();
            performanceTracker.startTimer();
            KadanesAlgorithm.Result result = KadanesAlgorithm.findMaxSubarray(arr, performanceTracker);
            performanceTracker.stopTimer();
            System.out.printf("n=%d | MaxSum=%d | Time=%dms | Comparisons=%d | Accesses=%d%n",
                    n, result.maxSum, performanceTracker.getElapsedTime(),
                    performanceTracker.getComparisons(), performanceTracker.getArrayAccesses());
        }
    }
}
