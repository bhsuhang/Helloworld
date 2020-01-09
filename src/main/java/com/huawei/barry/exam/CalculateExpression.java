/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019. All rights reserved.
 */

package com.huawei.barry.exam;

import java.util.Stack;

/**
 * 功能描述
 *
 * @author w00205937
 * @since 2019-09-26
 */
public class CalculateExpression {
    public static void main(String[] args) {
        // 1+(3-2)/5+2*7+MAX(2,MIN(5,10))
        String input = "MAX(2,MIN(5,10))+MIN(2,3)+1000+(3-2)/5+2*7+MAX(2,MIN(5,10))";
        Stack<String> stack = new Stack();
        float result = 0;
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
                    int value = Integer.parseInt(stack.pop()) * Integer.parseInt(num);
                    stack.push(String.valueOf(value));
                } else if (stack.size() - 1 >= 0 && "/".equals(stack.get(stack.size() - 1))) {
                    stack.pop(); // 弹出操作符 *
                    float value = Float.valueOf(stack.pop()).floatValue() / Float.valueOf(num).floatValue();
                    stack.push(String.valueOf(value));
                } else {
                    stack.push(String.valueOf(num));
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
                float value = calculateBasicOperation(tmp, op);
                stack.push(String.valueOf(value));
                input = input.substring(1, input.length());
            }
        }
        System.out.println(result);
    }

    private static float calculateBasicOperation(Stack<String> tmp, String op) {
        float result = Float.valueOf(tmp.pop());
        while (!tmp.empty()) {
            String value = tmp.pop();
            switch (op) {
                case "+/-":
                    if ("+".equals(value)) {
                        result = result + Float.valueOf(tmp.pop());
                    } else {
                        result = result - Float.valueOf(tmp.pop());
                    }
                    break;
                case "MAX":
                    if (Float.valueOf(value) > result) {
                        result = Float.valueOf(value);
                    }
                    break;
                case "MIN":
                    if (Float.valueOf(value) < result) {
                        result = Float.valueOf(value);
                    }
            }
        }
        return result;
    }
}
