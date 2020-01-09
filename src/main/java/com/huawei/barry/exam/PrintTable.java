/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019. All rights reserved.
 */

package com.huawei.barry.exam;

import java.util.Scanner;

/**
 * 功能描述
 *
 * @author w00205937
 * @since 2019-11-13
 */
class PrintTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        printMatrix(n, m);
    }

    private static void printMatrix(int n, int m) {
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                for (int j = 0; j < m; j++) {
                    if (j == 0) {
                        System.out.print("+---+");
                    } else {
                        System.out.print("---+");
                    }
                }
                System.out.println();
                for (int j = 0; j < m; j++) {
                    if (j == 0) {
                        System.out.print("|   |");
                    } else {
                        System.out.print("   |");
                    }
                }
                System.out.println();
                for (int j = 0; j < m; j++) {
                    if (j == 0) {
                        System.out.print("+---+");
                    } else {
                        System.out.print("---+");
                    }
                }
                System.out.println();
            } else {
                for (int j = 0; j < m; j++) {
                    if (j == 0) {
                        System.out.print("|   |");
                    } else {
                        System.out.print("   |");
                    }
                }
                System.out.println();
                for (int j = 0; j < m; j++) {
                    if (j == 0) {
                        System.out.print("+---+");
                    } else {
                        System.out.print("---+");
                    }
                }
                System.out.println();
            }
        }
    }
}
