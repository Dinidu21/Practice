package com.dinidu.test.threadSLIIT.q1;

public class Pattern01 extends Thread {
    private final Object lock;
    private final String pattern;
    private final int count;

    public Pattern01(Object lock, int count, String pattern) {
        super();
        this.lock = lock;
        this.count = count;
        this.pattern = pattern;
    }

    @Override
    public void run() {
        synchronized (lock) {
            for (int i = 0; i < count; i++) {
                System.out.print("Pattern 01 Thread :");
                for (int j = 0; j <= count - i; j++) {
                    System.out.print(" ");
                }
                for (int k = 0; k < i + 1; k++) {
                    System.out.print(pattern+" ");
                }
                System.out.println();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                lock.notify();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
