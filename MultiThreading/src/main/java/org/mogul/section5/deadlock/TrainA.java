package org.mogul.section5.deadlock;

public class TrainA implements Runnable {
    private Intersection intersection;

    public TrainA(Intersection intersection) {
        this.intersection = intersection;
    }

    @Override
    public void run() {
        while (true) {
            long sleepingTime = (long) (Math.random() * 5);
            try {
                Thread.sleep(sleepingTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            intersection.takeRoadA();
        }
    }

}
