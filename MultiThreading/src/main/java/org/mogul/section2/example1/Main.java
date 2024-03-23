package org.mogul.section2.example1;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("We are now in thread: " +  Thread.currentThread().getName());
                System.out.println("Priority: " +  Thread.currentThread().getPriority());
            }
        });

        thread.setName("Mogul Thread");
        thread.setPriority(Thread.MAX_PRIORITY);

        System.out.println("We are now in thread: " +  Thread.currentThread().getName() + " before starting a new thread");
        thread.start();
        System.out.println("We are now in thread: " +  Thread.currentThread().getName() + " before starting a new thread");

        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("A critical error happened in thread " + t.getName()
                    + " the error is: " + e.getMessage());
            }
        });

        Thread.sleep(10000);

    }
}