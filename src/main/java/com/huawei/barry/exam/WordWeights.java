/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019. All rights reserved.
 */

package com.huawei.barry.exam;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 功能描述
 *
 * @author w00205937
 * @since 2019-09-21
 */
class WordWeights {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (scanner.hasNextLine()) {
            input = scanner.nextLine();
            System.out.println(countWeights(input));
        }
    }

    private static String countWeights(String input) {
        String[] inArrays = input.split(" ");
        float length = 0;
        for (int i = 0; i < inArrays.length; i++) {
            length += inArrays[i].length();
        }
        float result = length / inArrays.length;
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return decimalFormat.format(result);
    }
}
