
package com.huawei.barry.exam;

import java.util.BitSet;
import java.util.Scanner;

/**
 * 功能描述
 *
 * @author w00205937
 * @since 2019-09-20
 */
public class PrimeNumberFilter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {

            // todos.add(scanner.nextInt());
            System.out.println(findTwinPrimeNumber(scanner.nextInt()));

        }
    }

    // 找孪生素数
    private static int findTwinPrimeNumber(int scope) {
        int count = 0;
        int[] primes = getPrimeNumber4(scope);
        // primes.forEach(x -> System.out.print(x + " "));
        for (int i = 1; i < primes.length; i++) {
            if (primes[i - 1] == primes[i] - 2) {
                count++;
            }
        }
        // System.out.println();
        // twinlist.forEach(x -> System.out.print(x+" "));
        return count;
    }

    // 采用筛选法，先找到素数
    private static int[] getPrimeNumber3(int scope) {

        boolean[] flag = new boolean[scope + 1];

        // 初始化，假定都是素数
        for (int i = 0; i < flag.length; i++) {
            flag[i] = true;
        }
        // 明确的0,1 处理掉
        flag[0] = false;
        flag[1] = false;
        int times = new Double(Math.sqrt(scope)).intValue();

        for (int i = 2; i <= times; i++) {
            // 只要是前面找到数字的倍数，都不是素数
            for (int j = i * 2; j <= scope; j += i) {
                if (flag[i]) {
                    flag[j] = false;
                }
            }
        }

        int count = 0;

        for (int i = 0; i < flag.length; i++) {
            if (flag[i]) {
                count++;
            }
        }
        int[] primes = new int[count];
        int j = 0;
        for (int i = 0; i < flag.length; i++) {
            if (flag[i]) {
                primes[j++] = i;
            }
        }

        return primes;
    }

    // 采用筛选法，先找到素数，采用bitset的方式实现，避免OOM
    private static int[] getPrimeNumber4(int scope) {
        // boolean[] flag = new boolean[scope + 1];
        BitSet flag = new BitSet(10);
        // 初始化，假定都是素数
        for (int i = 0; i <= scope; i++) {
            flag.set(i, true);
        }
        // 明确的0,1 处理掉
        flag.set(0, false);
        flag.set(1, false);
        int times = new Double(Math.sqrt(scope)).intValue();
        for (int i = 2; i <= times; i++) {
            // 只要是前面找到数字的倍数，都不是素数
            for (int j = i * 2; j <= scope; j += i) {
                if (flag.get(i)) {
                    flag.set(j, false);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < flag.size(); i++) {
            if (flag.get(i)) {
                count++;
            }
        }
        int[] primes = new int[count];
        int j = 0;
        for (int i = 0; i < flag.size(); i++) {
            if (flag.get(i)) {
                primes[j++] = i;
            }
        }
        return primes;
    }

    // 采用筛选法，先找到素数，采用byte[]的方式实现，避免OOM
    private static int[] getPrimeNumber5(int scope) {

        // boolean[] flag = new boolean[scope + 1];

        BitSet flag = new BitSet(10);

        // 初始化，假定都是素数
        for (int i = 0; i <= scope; i++) {
            flag.set(i, true);
        }
        // 明确的0,1 处理掉
        flag.set(0, false);
        flag.set(1, false);

        int times = new Double(Math.sqrt(scope)).intValue();

        for (int i = 2; i <= times; i++) {
            // 只要是前面找到数字的倍数，都不是素数
            for (int j = i * 2; j <= scope; j += i) {
                if (flag.get(i)) {
                    flag.set(j, false);
                }
            }
        }

        int count = 0;

        for (int i = 0; i < flag.size(); i++) {
            if (flag.get(i)) {
                count++;
            }
        }
        int[] primes = new int[count];
        int j = 0;
        for (int i = 0; i < flag.size(); i++) {
            if (flag.get(i)) {
                primes[j++] = i;
            }
        }

        return primes;
    }
}
