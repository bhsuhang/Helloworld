/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019. All rights reserved.
 */

package com.huawei.barry.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 功能描述
 *
 * @author w00205937
 * @since 2019-09-28
 */
class RegexTest {
    public static void main(String[] args) {
        String input = "MIN(1,2,MIN(5,10,MAX(5,10)))*(3-2)/5+2*7+MAX(2,MIN(5,10))";
        String regex = "MIN\\([^\\(\\)]*\\)|MAX\\([^\\(\\)]*\\)|\\([^\\(\\)]*\\)";
        // input = input.replaceFirst(regex, "hhhhhh");
        Pattern pattern = Pattern.compile(regex);
        while (true) {
            Matcher m = pattern.matcher(input);
            boolean isfind = false;
            while (m.find()) {
                isfind = true;
                String expression = m.group();
                String value = calculateBasicOperation(expression);
                input = input.replace(expression, value);
            }
            if (!isfind) {
                break;
            }
        }
        System.out.println(calculateBasicOperation(input));

    }

    private static String calculateBasicOperation(String expression) {
        Float result = null;
        if (expression.startsWith("MIN")) {
            expression = expression.substring(4, expression.length() - 1);
            String[] values = expression.split(",");

            for (String value : values) {
                if (result == null || Float.valueOf(value) < result) {
                    result = Float.valueOf(value);
                }
            }
        } else if (expression.startsWith("MAX")) {
            expression = expression.substring(4, expression.length() - 1);
            String[] values = expression.split(",");
            for (String value : values) {
                if (result == null || Float.valueOf(value) > result) {
                    result = Float.valueOf(value);
                }
            }
        } else {
            // （)中基本的加减乘除
            if (expression.startsWith("(")) {
                expression = expression.substring(1, expression.length() - 1);
            }
            while (true) {
                String regex = "\\d+\\.*\\d*\\*\\d*\\.*\\d*|\\d+\\.*\\d*\\/\\d*\\.*\\d*";
                Pattern pattern = Pattern.compile(regex);
                Matcher m = pattern.matcher(expression);
                if (m.find()) {
                    String sub = m.group();
                    float tmp = 0.0f;
                    if (sub.indexOf("*") != -1) {
                        tmp = Float.valueOf(sub.substring(0, sub.indexOf("*")))
                            * Float.valueOf(sub.substring(sub.indexOf("*") + 1, sub.length()));
                    }
                    if (sub.indexOf("/") != -1) {
                        tmp = Float.valueOf(sub.substring(0, sub.indexOf("/")))
                            / Float.valueOf(sub.substring(sub.indexOf("/") + 1, sub.length()));
                    }
                    expression = m.replaceFirst(String.valueOf(tmp));
                } else { // 没有乘除符合
                    regex = "\\d+\\.*\\d*\\+\\d*\\.*\\d*|\\d+\\.*\\d*\\-\\d*\\.*\\d*";
                    pattern = Pattern.compile(regex);
                    m = pattern.matcher(expression);
                    if (m.find()) {
                        String sub = m.group();
                        float tmp = 0.0f;
                        if (sub.indexOf("+") != -1) {
                            tmp = Float.valueOf(sub.substring(0, sub.indexOf("+")))
                                + Float.valueOf(sub.substring(sub.indexOf("+") + 1, sub.length()));
                        }
                        if (sub.indexOf("-") != -1) {
                            tmp = Float.valueOf(sub.substring(0, sub.indexOf("-")))
                                - Float.valueOf(sub.substring(sub.indexOf("-") + 1, sub.length()));
                        }
                        expression = m.replaceFirst(String.valueOf(tmp));
                    } else {
                        // 没有+/-
                        return expression;
                    }

                }
            }

        }
        return String.valueOf(result);
    }

    public void test() {
        List<int[][]> list = new ArrayList<>();
        int[][] value = new int[10][15];
        list.add(value);
    }
}
