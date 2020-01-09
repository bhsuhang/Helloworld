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
class ASubstractB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int qty = Integer.valueOf(scanner.nextLine());
        int i = 1;
        while (scanner.hasNextLine()) {
            if (i > qty) {
                break;
            }
            String line = scanner.nextLine();
            String[] numbers = line.split(" ");
            System.out.println("Case " + (i) + ":");
            System.out.print(numbers[0] + " + " + numbers[1] + " = ");
            System.out.println(processASubtractB(numbers[0], numbers[1]));
            if (i < qty) {
                System.out.println();
            }
            i++;
        }
    }

    private static BigDecimal processASubtractB(String a, String b) {
        return new BigDecimal(a).subtract(new BigDecimal(b));
    }
}
