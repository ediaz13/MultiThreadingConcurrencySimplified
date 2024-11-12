package org.mogul.section5;

public class DecrementingThread extends Thread {
    private final InventoryCounter inventoryCounter;

    public DecrementingThread(InventoryCounter inventoryCounter) {
        this.inventoryCounter = inventoryCounter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            inventoryCounter.decrement();
        }
    }
}
