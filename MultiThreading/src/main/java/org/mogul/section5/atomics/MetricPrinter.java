package org.mogul.section5.atomics;

public class MetricPrinter  extends Thread {
    private Metrics metrics;
    public MetricPrinter(Metrics metrics) {
        this.metrics = metrics;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            double currentAverage = metrics.getAverage();
            System.out.println("Current Average is: " + currentAverage);
        }
    }
}
