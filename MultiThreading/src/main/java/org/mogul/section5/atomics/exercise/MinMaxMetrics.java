package org.mogul.section5.atomics.exercise;

public class MinMaxMetrics {
    private volatile long min = Long.MAX_VALUE;
    private volatile long max = Long.MIN_VALUE;

    public void addSample(long sample) {
        synchronized (this) {
            min = Math.min(min, sample);
            max = Math.max(max, sample);
        }
    }

    public long getMin() {
        return min;
    }

    public long getMax() {
        return max;
    }

    public MinMaxMetrics() {
    }

}
