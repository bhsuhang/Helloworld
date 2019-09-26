
package com.huawei.barry.exam;

import java.util.Scanner;

public class PrimeNumberDevidedBy6Pass {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            // todos.add(scanner.nextInt());
            System.out.println(getTwins(100000));
        }

    }

    private static int getTwins(int a) {
        if (a < 4) {
            return 0;
        }
        int count = 1;
        for (int i = 5; i <= a && i + 2 <= a;) {
            if (isPrime(i) && isPrime(i + 2)) {
                count++;
            }
            i += 2;
        }
        return count;
    }

    public static boolean isPrime(int num) {
        if (num < 5) {
            return false;
        }
        // 不在6的倍数两侧的一定不是质数
        if (num % 6 != 1 && num % 6 != 5) {
            return false;
        }
        int sqrt = (int) Math.sqrt(num);
        for (int i = 5; i <= sqrt; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
