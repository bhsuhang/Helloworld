
package com.huawei.barry.exam;

import java.util.Scanner;

public class MatrixMuptiple {

    private static Scanner scanner = null;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        // 定义第一个矩阵的大小
        int lineIndexA = size;
        int columuIndexA = size;
        int[][] matrixOriginA = new int[lineIndexA][columuIndexA];
        // readmatrix(matrixOriginA);
        initmatrixA(matrixOriginA);
        // printMatix(matrixOriginA);
        // 定义第二个矩阵的大小
        int lineIndexB = size;
        int columuIndexB = size;
        int[][] matrixOriginB = new int[lineIndexB][columuIndexB];
        // read the input into the matrix
        // readmatrix(matrixOriginB);
        initmatrixB(matrixOriginB);
        // printMatix(matrixOriginB);
        int[][] outputs = multipleMatrix(matrixOriginA, matrixOriginB);
        printMatix(outputs);
    }

    private static void initmatrixA(int[][] matrixOriginA) {
        for (int i = 0; i < matrixOriginA.length; i++) {
            for (int j = 0; j < matrixOriginA[i].length; j++) {
                matrixOriginA[i][j] = j + 1;
            }
        }
    }

    private static void initmatrixB(int[][] matrixOriginB) {
        for (int i = 0; i < matrixOriginB.length; i++) {
            for (int j = 0; j < matrixOriginB[i].length; j++) {
                matrixOriginB[i][j] = 4 - (j + 1);
            }
        }
    }

    private static void readmatrix(int[][] matrixOriginA) {
        // read the input into the matrix
        for (int i = 0; i < matrixOriginA.length; i++) {
            for (int j = 0; j < matrixOriginA[i].length; j++) {
                matrixOriginA[i][j] = scanner.nextInt();
            }
        }
    }

    private static int[][] multipleMatrix(int[][] matrixOriginA, int[][] matrixOriginB) {
        int[][] output = new int[matrixOriginA.length][matrixOriginB[0].length];
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[i].length; j++) {
                // 计算每个单元格的值
                int value = 0;
                // matrixOriginA[i]*matrixOriginA[j]
                for (int k = 0; k < matrixOriginA[i].length; k++) {
                    value += matrixOriginA[i][k] * matrixOriginB[k][j];
                }
                output[i][j] = value;
            }
        }
        return output;
    }

    private static void printMatix(int[][] matrixOrigin) {
        for (int i = 0; i < matrixOrigin.length; i++) {
            for (int j = 0; j < matrixOrigin[i].length; j++) {
                // 处理最后一列的输出
                if (j == matrixOrigin[i].length - 1) {
                    // 最后一行的最后一列不换行
                    if (i == matrixOrigin.length - 1) {
                        System.out.print(matrixOrigin[i][j]);
                    } else {
                        System.out.println(matrixOrigin[i][j]);
                    }
                } else {
                    System.out.print(matrixOrigin[i][j] + " ");
                }
            }
            // System.out.println();
        }
    }
}
