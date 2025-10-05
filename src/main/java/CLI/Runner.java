package CLI;

import Algorithm.Kadanes;
import Metric.Tracker;
import java.util.Random;

public class Runner {
    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000, 100000};
        Random random = new Random();
        for (int n : sizes) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = random.nextInt(2001) - 1000; // values from -1000 to 1000
            Tracker tracker = new Tracker();
            tracker.startTimer();
            Kadanes.Result result = Kadanes.findMaxSubarray(arr, tracker);
            tracker.stopTimer();
            System.out.printf("n=%d | MaxSum=%d | Time=%dms | Comparisons=%d | Accesses=%d%n",
                    n, result.maxSum, tracker.getElapsedTime(),
                    tracker.getComparisons(), tracker.getArrayAccesses());
        }
    }
}
