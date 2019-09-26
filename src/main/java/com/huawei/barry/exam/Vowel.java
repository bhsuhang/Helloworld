/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019. All rights reserved.
 */

package com.huawei.barry.exam;

import java.util.Scanner;

/**
 * 功能描述
 *
 * @author w00205937
 * @since 2019-09-24
 */
public class Vowel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(convertToSolo(input));
    }

    private static String convertToSolo(String input) {
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case 'a':
                case 'A':
                    chars[i] = 'A';
                    break;
                case 'e':
                case 'E':
                    chars[i] = 'E';
                    break;
                case 'i':
                case 'I':
                    chars[i] = 'I';
                    break;
                case 'o':
                case 'O':
                    chars[i] = 'O';
                    break;
                case 'u':
                case 'U':
                    chars[i] = 'U';
                    break;
                default:
                    chars[i] = String.valueOf(chars[i]).toLowerCase().toCharArray()[0];
            }
        }
        return new String(chars);
    }
}
