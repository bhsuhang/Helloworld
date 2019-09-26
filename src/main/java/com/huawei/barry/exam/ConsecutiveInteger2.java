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
class ConsecutiveInteger2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        while (s % 2 == 0) {
            s >>= 1;
            if (s == 1) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
