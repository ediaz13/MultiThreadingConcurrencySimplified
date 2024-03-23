package org.mogul.section3.interrupt;

import java.math.BigInteger;

public class MainLongComputation {
    public static void main(String[] args) {
        Thread thread = new Thread(new LongComputationalTask(new BigInteger("20000000"), new BigInteger("4555555555")));
        thread.start();
        thread.interrupt();
    }

    

    private static class LongComputationalTask implements Runnable {
        private final BigInteger base;
        private final BigInteger power;

        public LongComputationalTask(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            System.out.println(base + "^" + power + " = " + pow(base, power));
        }

        private BigInteger pow(BigInteger base, BigInteger power) {
            BigInteger result = BigInteger.ONE;

            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Prematurely Interrupted Computation");
                }
                result = result.multiply(base);
            }

            return result;
        }
    }
}
