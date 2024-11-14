package org.mogul.section5.deadlock;

public class Main {
    public static void main(String[] args) {
        Intersection intersection = new Intersection();
        TrainA trainA = new TrainA(intersection);
        TrainB trainB = new TrainB(intersection);

        Thread thread1 = new Thread(trainA);
        Thread thread2 = new Thread(trainB);

        thread1.start();
        thread2.start();
    }
}
