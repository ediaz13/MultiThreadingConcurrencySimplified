package main.java.org.mogul.example2;

public class Main {
    public static void main(String[] args) {
        Thread thread = new NewThread();
        thread.start();

    }

    private static class NewThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello from " + Thread.currentThread().getName());
            this.getName();
        }
    }
}
