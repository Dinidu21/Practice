package com.dinidu.test.threadSLIIT.q1;

import java.util.Scanner;

public class Application {
    static Scanner sc =  new Scanner(System.in);
    public static void main(String[] args) {
        Object lock = new Object(); //Sync Object

        System.out.print("Enter Count : ");
        int count  = sc.nextInt();
        System.out.print("Enter Pattern 01 :");
        String ptn1 = sc.next();
        System.out.print("Enter Pattern 02 : ");
        String ptn2 = sc.next();

        Thread t1 = new Pattern01(lock, count, ptn1);
        Thread t2 = new Pattern02(lock, count, ptn2);
        System.out.println("|...............Thread Start Printing Pattern.................|");
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
