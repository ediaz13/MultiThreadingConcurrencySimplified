package org.mogul.section5.deadlock;

public class Intersection {
    private Object roadA = new Object();
    private Object roadB = new Object();

   public void takeRoadA() {
       synchronized (roadA) {
           System.out.println("Road A: Locked by thread: " + Thread.currentThread().getName());

           synchronized (roadB) {
               System.out.println("Train is passing through road A");
               try {
                   Thread.sleep(1);
               } catch (InterruptedException e) {
               }
           }
       }
   }

    public void takeRoadB() {
        synchronized (roadA) {
            System.out.println("Road A is locked by thread: " + Thread.currentThread().getName());

            synchronized (roadB) {
                System.out.println("Train is passing through road B");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {}
            }
        }
    }
}
