package com.dinidu.test.collectionsandgenerics;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        while (true) {
            System.out.println("Enter numbers : 0 to quit ");
            int number = sc.nextInt();
            if (number == -0) {
                break;
            }
            arr.add(number);
        }

        for (int i = 0; i < arr.size(); i++) {
            if(arr.get(i) % 2 == 0) {
                arr.remove(i);
                i--;
            }
        }

        System.out.println("Odd Number : "+ arr);
    }
}
