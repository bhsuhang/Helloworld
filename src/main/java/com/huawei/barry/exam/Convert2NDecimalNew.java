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
 * @since 2019-09-21
 */
class Convert2NDecimalNew {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigDecimal input = new BigDecimal("0");
        int n = -1;
        while (scanner.hasNextLine()) {
            if (input.floatValue() == 0.0) {
                input = new BigDecimal(scanner.next());
            }
            if (n == -1) {
                n = scanner.nextInt();
            }
            if (input.floatValue() == 0.0 && n == 0) {
                System.exit(0);
            }
            System.out.println(convert(input.toString(), n));
            // 恢复到默认值，进行下一轮
            input = new BigDecimal("0");
            n = -1;
        }
    }

    private static String convert(String input, int n) {
        String tmpStr = input;
        String output = "";
        // 讲输入转换为整数
        final int degitalLenth = tmpStr.length() - tmpStr.indexOf(".") - 1;
        String left = tmpStr.substring(tmpStr.indexOf(".") + 1, tmpStr.length());  // 975
        while (output.length() < 10) {
            // 保留10位小数
            String tmpResult = "";
            tmpResult += Long.parseLong(left) * n;
            // 避免00XXX，这类的数字在乘法之后丢掉了前面的00
            while (tmpResult.length() < degitalLenth) {
                tmpResult = "0" + tmpResult;
            }
            // 如果计算结果超过原来的长度，则取高位，否则补0
            if (tmpResult.length() > degitalLenth) {
                output += tmpResult.substring(0, tmpResult.length() - degitalLenth);
            } else {
                output += "0";
            }
            left = tmpResult.substring(tmpResult.length() - degitalLenth, tmpResult.length());
        }
        return "0." + output;
    }
}