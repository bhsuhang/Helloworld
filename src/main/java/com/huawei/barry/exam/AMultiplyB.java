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
class AMultiplyB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] numbers = line.split(" ");
            System.out.print(numbers[0] + " * " + numbers[1] + " = ");
            System.out.println(processAMultiplyB(numbers[0], numbers[1]));
        }
    }

    private static BigDecimal processAMultiplyB(String a, String b) {
        return new BigDecimal(a).multiply(new BigDecimal(b));
    }
}
