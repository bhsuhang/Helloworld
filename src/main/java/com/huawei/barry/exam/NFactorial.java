/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019. All rights reserved.
 */

package com.huawei.barry.exam;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 功能描述
 *
 * @author w00205937
 * @since 2019-11-13
 */
class NFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(nFactorial(n));
    }

    private static BigDecimal nFactorial(int n) {
        BigDecimal result = BigDecimal.ONE;
        for (int i = 1; i <= n; i++) {
            result = new BigDecimal(i).multiply(result);
        }
        return result;
    }
}
