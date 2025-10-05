package Metric;

public class Tracker {
    private long comparisons = 0;
    private long arrayAccesses = 0;
    private long startTime;
    private long endTime;
    public void incrementComparison(long count) { comparisons += count; }
    public void incrementArrayAccess(long count) { arrayAccesses += count; }
    public void startTimer() { startTime = System.nanoTime(); }
    public void stopTimer() { endTime = System.nanoTime(); }
    public long getElapsedTime() { return (endTime - startTime) / 1000000; } // ms
    public long getComparisons() { return comparisons; }
    public long getArrayAccesses() { return arrayAccesses; }
    public void reset() {
        comparisons = 0;
        arrayAccesses = 0;
        startTime = 0;
        endTime = 0;
    }
}