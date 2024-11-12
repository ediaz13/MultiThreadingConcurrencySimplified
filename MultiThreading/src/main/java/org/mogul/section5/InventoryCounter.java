package org.mogul.section5;

public class InventoryCounter {
    private int items = 0;

    Object lock = new Object();
    public void increment() {
        synchronized (this.lock) {
            items++;
        }
    }

    public void decrement() {
        synchronized (this.lock) {
            items--;
        }
    }

    public synchronized int getItems() {
        return items;
    }
}
