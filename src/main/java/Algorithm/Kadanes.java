package Algorithm;

import Metric.Tracker;

public class Kadanes {
    public static class Result {
        public int maxSum;
        public int start;
        public int end;
        public Result(int maxSum, int start, int end) {
            this.maxSum = maxSum;
            this.start = start;
            this.end = end;
        }
    }
    public static Result findMaxSubarray(int[] arr, Tracker tracker) {
        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException("Array cannot be null or empty");
        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];
        int start = 0, end = 0, tempStart = 0;
        for (int i = 1; i < arr.length; i++) {
            tracker.incrementArrayAccess(1);
            if (maxEndingHere + arr[i] < arr[i]) {
                maxEndingHere = arr[i];
                tempStart = i;
            } else {
                maxEndingHere += arr[i];
            }
            tracker.incrementComparison(1);
            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
                start = tempStart;
                end = i;
            }
        }
        return new Result(maxSoFar, start, end);
    }
}