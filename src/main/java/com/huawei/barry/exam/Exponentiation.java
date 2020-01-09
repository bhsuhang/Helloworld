/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019. All rights reserved.
 */

package com.huawei.barry.exam;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * 功能描述
 *
 * @author w00205937
 * @since 2019-10-31
 */
public class Exponentiation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String value = calculateExponentiation(line.substring(0, 6), line.substring(7, 9));
            System.out.println(value);
        }
    }

    private static String calculateExponentiation(String r, String n) {
        BigDecimal decimal = new BigDecimal(r);
        decimal = decimal.pow(Integer.valueOf(n.trim()));
        String result = decimal.stripTrailingZeros().toPlainString();
        return format(result);
    }

    private static String format(String result) {
        String value = result;
        if (value.indexOf(".") != -1) {
            String[] split = value.split("\\.");
            String head = split[0];
            String tail = split[1];
            if (new BigInteger(head).intValue() == 0) {
                head = "";
            }
            value = head + "." + tail;
        } else {
            return value;
        }
        return value;
    }
}
