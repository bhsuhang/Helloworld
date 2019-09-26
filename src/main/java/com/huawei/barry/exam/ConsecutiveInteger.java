/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019. All rights reserved.
 */

package com.huawei.barry.exam;

import java.util.Scanner;

/**
 * 功能描述
 *
 * @author w00205937
 * @since 2019-09-21
 */
class ConsecutiveInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            Long num = scanner.nextLong();
            System.out.println(calculateConsecutiveIntegerBySquareRoot(num));
        }
    }

    /*
     * 如果一个数字total可以被以x （x=1,2,3...) 开始连续的 n 个数字相加, 则满足 ((x+x+n-1)/2) *n=total 即 (2x+n-1)*n/2=total
     * @param num
     * @return
     */
    private static String calculateConsecutiveInteger(Long num) {
        for (int x = 1; x <= num / 2; x++) {
            for (int n = 2; n <= num + 1; n++) { // 要求是连续的数字，因此直接从 2 开始
                long value = (2 * x + n - 1) * n / 2;
                if (value == num) {
                    return "YES";
                } else if (value > num) {
                    break;
                }
            }
        }
        return "NO";
    }

    // 用平方根求解 (2x+n-1)*n/2=total ,即 (2 * x + n - 1) * n / 2 = tatal
    // 已知X的情况，求n即为 n^2 -n+(2x-2t)=0 求平方根，其解为： (-1 +/- sqrt(（-1）^2-4(2x-2t)) )/2*1
    private static String calculateConsecutiveIntegerBySquareRoot(Long num) {
        for (long x = 1; x <= num / 2; x++) {

            double tmp =
                (double) (-(2 * x - 1) + (double) Math.sqrt(Math.pow((2 * x - 1), 2) - 4 * (-2 * (double) num))) / 2;

            // if ((int) tmp == tmp) {
            // System.out.println(x + "," + tmp);
            // return "YES";
            // }

            for (long n = (long) tmp; n <= num + 1; n++) { // 要求是连续的数字，因此直接从 2 开始
                long value = (2 * x + n - 1) * n / 2;
                if (value == num) {
                    return "YES";
                } else if (value > num) {
                    break;
                }
            }
        }
        return "NO";
    }
}
