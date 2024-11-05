package com.dinidu.test.threadSLIIT.q2;

public class EvenOddPrinter {
    private static final int MAX_COUNT = 20;
    private static volatile int nextNum = 1;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread evenThread = new Thread(new EvenRunnable());
        Thread oddThread = new Thread(new OddRunnable());

        evenThread.start();
        oddThread.start();

        try {
            evenThread.join();
            oddThread.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public static class EvenRunnable implements Runnable {

        @Override
        public void run() {
            while (EvenOddPrinter.nextNum <= EvenOddPrinter.MAX_COUNT) {
                synchronized (EvenOddPrinter.lock) {
                    if (EvenOddPrinter.nextNum % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + "  : " + EvenOddPrinter.nextNum);
                        EvenOddPrinter.nextNum++;
                        EvenOddPrinter.lock.notify();
                    }
                    try {
                        // Break the loop if nextNum exceeds MAX_COUNT to avoid unnecessary waiting.
                        if (EvenOddPrinter.nextNum > EvenOddPrinter.MAX_COUNT) {
                            EvenOddPrinter.lock.notifyAll(); // Notify any waiting threads to avoid deadlock.
                            break;
                        }
                        EvenOddPrinter.lock.wait();
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public static class OddRunnable implements Runnable {

        @Override
        public void run() {
            while (EvenOddPrinter.nextNum <= EvenOddPrinter.MAX_COUNT) {
                synchronized (EvenOddPrinter.lock) {
                    if (EvenOddPrinter.nextNum % 2 == 1) {
                        System.out.println(Thread.currentThread().getName() + "  : " + EvenOddPrinter.nextNum);
                        EvenOddPrinter.nextNum++;
                        EvenOddPrinter.lock.notify();
                    }
                    try {
                        // Break the loop if nextNum exceeds MAX_COUNT to avoid unnecessary waiting.
                        if (EvenOddPrinter.nextNum > EvenOddPrinter.MAX_COUNT) {
                            EvenOddPrinter.lock.notifyAll(); // Notify any waiting threads to avoid deadlock.
                            break;
                        }
                        EvenOddPrinter.lock.wait();
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
