package org.mogul.section5.non.atomics;

public class Main {
    //Race Condition
    public static void main(String[] args) {
        InventoryCounter inventoryCounter = new InventoryCounter();
        IncrementingThread incrementingThread = new IncrementingThread(inventoryCounter);
        DecrementingThread decrementingThread = new DecrementingThread(inventoryCounter);

        try {
            incrementingThread.start();
            decrementingThread.start();

            incrementingThread.join();
            decrementingThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("We currently have " + inventoryCounter.getItems() + " items");
    }

}
