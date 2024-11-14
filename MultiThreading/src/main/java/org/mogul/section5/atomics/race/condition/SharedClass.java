package org.mogul.section5.atomics.race.condition;

public class SharedClass {
    private volatile int x = 0;
    private volatile int y = 0;

    public void increment() {
        x++;
        y++;
    }

    public void checkForDataRace() {
        if (y > x) {
            System.out.println("y > x - Data race is detected");
        }
    }
}
