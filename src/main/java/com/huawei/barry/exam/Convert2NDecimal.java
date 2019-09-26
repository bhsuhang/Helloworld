/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019. All rights reserved.
 */

package com.huawei.barry.exam;

import java.util.Scanner;

/**
 * 功能描述
 *
 * @author w00205937
 * @since 2019-09-20
 */
class Convert2NDecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float input = 0f;
        int n = -1;
        while (scanner.hasNextLine()) {
            if (input == 0) {
                input = new Float(scanner.next());
            }
            if (n == -1) {
                n = scanner.nextInt();
            }
            if (input == 0.0 && n == 0) {
                System.exit(0);
            }
            System.out.println(convert(input, n));
            // 恢复到默认值，进行下一轮
            input = 0;
            n = -1;
        }
    }

    private static double convert(double input, int n) {
        String output = "";
        String tempStr = "";
        double tmp = input;
        while (tmp > 0) {
            // 保留10位小数
            if (output.length() >= 10) {
                break;
            }
            // 计算10进制和N进制的乘法，为避免浮点数运算溢出问题，转换为整数计算
            tmp = multiply(tmp, n);
            tempStr = tmp + "";
            output += tempStr.substring(0, tempStr.indexOf("."));
            String left = "0." + tempStr.substring(tempStr.indexOf(".") + 1, tempStr.length());
            tmp = new Double(left).doubleValue();
        }
        return new Double("0." + output).doubleValue();
    }

    // 为避免float类型计算的问题。
    private static float multiply(double tmp, int n) {
        String tmpStr = "" + tmp;
        int position = tmpStr.length() - tmpStr.indexOf(".") - 1;
        long value = new Float((Math.pow(10, position)) * tmp).longValue();
        String result = value * n + "";
        result = result.substring(0, result.length() - position) + "."
            + result.substring(result.length() - position, result.length());
        return new Float(result).floatValue();
    }
}
