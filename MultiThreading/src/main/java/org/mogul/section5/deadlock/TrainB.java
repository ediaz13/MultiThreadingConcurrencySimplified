package org.mogul.section5.deadlock;

public class TrainB implements Runnable {
    public Intersection intersection;

    public TrainB(Intersection intersection) {
        this.intersection = intersection;
    }

    public void run() {
        while (true) {
            long sleepingTime = (long) (Math.random() * 5);
            try {
                Thread.sleep(sleepingTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            intersection.takeRoadB();
        }
    }
}
