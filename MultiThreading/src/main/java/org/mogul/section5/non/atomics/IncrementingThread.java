package org.mogul.section5.non.atomics;

public class IncrementingThread extends Thread {
    private final InventoryCounter inventoryCounter;

    public IncrementingThread(InventoryCounter inventoryCounter) {
        this.inventoryCounter = inventoryCounter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            inventoryCounter.increment();
        }
    }
}
