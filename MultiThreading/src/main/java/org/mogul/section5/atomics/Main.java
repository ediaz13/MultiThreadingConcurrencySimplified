package org.mogul.section5.atomics;

public class Main {
    public static void main(String[] args) {
        Metrics metrics = new Metrics();
        BusinessLogic businessLogicThread1 = new BusinessLogic(metrics);
        BusinessLogic businessLogicThread2 = new BusinessLogic(metrics);
        MetricPrinter metricPrinter = new MetricPrinter(metrics);

        businessLogicThread1.start();
        businessLogicThread2.start();
        metricPrinter.start();
    }

}
