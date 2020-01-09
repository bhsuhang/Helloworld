/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019. All rights reserved.
 */

package com.huawei.barry.exam;

import java.util.Scanner;
import java.util.Stack;

/**
 * 功能描述
 *
 * @author w00205937
 * @since 2019-11-02
 */
public class CalculateExpression2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "utf-8");
        String expression = scanner.nextLine();
        System.out.println(calculateExpression(expression));
    }

    private static long calculateExpression(String input) {
        long result = 0L;
        Stack<String> stack = new Stack();
        while (true) {
            if (input.length() == 0) {
                result = calculateBasicOperation(stack, "+/-");
                break;
            }
            // 如果是数字开头, 将数字放入操作数栈, 并检查前一个数字操作符，如果是*或者/则计算
            if (input.matches("^\\d+\\S*")) {
                String newInput = input.replaceAll("^\\d*", "");
                String num = input.substring(0, input.length() - newInput.length());
                input = newInput;
                if (stack.size() - 1 >= 0 && "*".equals(stack.get(stack.size() - 1))) {
                    stack.pop(); // 弹出操作符 *
                    long value = Long.valueOf(stack.pop()) * Long.valueOf(num);
                    stack.push(String.valueOf(value));
                } else if (stack.size() - 1 >= 0 && "/".equals(stack.get(stack.size() - 1))) {
                    stack.pop(); // 弹出操作符 *
                    long value = Long.valueOf(stack.pop()) / Long.valueOf(num);
                    stack.push(String.valueOf(value));
                } else {
                    stack.push(num);
                }
            }
            // 如果是MIN/MAX/+-*/(Z就入栈
            if (input.matches("^(\\+|\\-|\\*|\\/|\\(|MAX\\(|MIN\\()+\\S*")) {
                String newInput = input.replaceAll("^(\\+|\\-|\\*|\\/|\\(|MAX\\(|MIN\\(){1}", "");
                String op = input.substring(0, input.length() - newInput.length());
                stack.push(op);
                input = newInput;
            }
            if (input.startsWith(",")) {
                input = input.substring(1, input.length());
            }
            // 如果是)就出栈
            if (input.startsWith(")")) {
                Stack tmp = new Stack();
                String op = "";
                while (true) {
                    Object o = stack.pop();
                    if ("(".equals(o)) {
                        op = "+/-";
                        break;
                    } else if ("MAX(".equals(o)) {
                        op = "MAX";
                        break;
                    } else if ("MIN(".equals(o)) {
                        op = "MIN";
                        break;
                    } else {
                        tmp.push(o);
                    }
                }
                long tempValue = calculateBasicOperation(tmp, op);
                if (stack.size() - 1 >= 0 && "*".equals(stack.get(stack.size() - 1))) {
                    stack.pop(); // 弹出操作符 *
                    long value = Long.valueOf(stack.pop()) * tempValue;
                    stack.push(String.valueOf(value));
                } else if (stack.size() - 1 >= 0 && "/".equals(stack.get(stack.size() - 1))) {
                    stack.pop(); // 弹出操作符 *
                    long value = Long.valueOf(stack.pop()) / tempValue;
                    stack.push(String.valueOf(value));
                } else {
                    stack.push(String.valueOf(tempValue));
                }
                input = input.substring(1, input.length());
            }
        }
        return result;
    }

    private static long calculateBasicOperation(Stack<String> tmp, String op) {
        long result = Long.valueOf(tmp.pop());
        while (!tmp.empty()) {
            String value = tmp.pop();
            switch (op) {
                case "+/-":
                    if ("+".equals(value)) {
                        result = result + Long.valueOf(tmp.pop());
                    } else {
                        result = Long.valueOf(tmp.pop()) - result;
                    }
                    break;
                case "MAX":
                    if (Float.valueOf(value) > result) {
                        result = Long.valueOf(value);
                    }
                    break;
                case "MIN":
                    if (Float.valueOf(value) < result) {
                        result = Long.valueOf(value);
                    }
            }
        }
        return result;
    }
}
