package org.mogul.section5.atomics.race.condition;

public class Main {
    public static void main(String[] args) {
        SharedClass sharedClass = new SharedClass();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                sharedClass.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                sharedClass.checkForDataRace();
            }
        });

        thread1.start();
        thread2.start();
    }



}
