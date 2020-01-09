/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019. All rights reserved.
 */

package com.huawei.barry.exam;

/**
 * 功能描述
 *
 * @author w00205937
 * @since 2019-11-14
 */
class MaxmalSquare {
    public static void main(String[] args) {
        char[][] matrix = new char[][] {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'},
            {'1', '0', '1', '1', '1'}};
        System.out.println(maximalSquare(matrix));
    }

    public static int maximalSquare(char[][] matrix) {
        int maximalSize = 0;
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                // 找到最新的矩阵
                if (matrix[i][j] == '1' && matrix[i][j + 1] == '1' && matrix[i + 1][j] == '1'
                    && matrix[i + 1][j + 1] == '1') {
                    maximalSize = 2;
                    int size = findNext(matrix, i, j, maximalSize);
                    if (size > maximalSize) {
                        maximalSize = size;
                    }
                }
            }
        }
        return maximalSize * maximalSize;
    }

    private static int findNext(char[][] matrix, int i, int j, int size) {
        // 已经到边了，直接返回
        if ((i + size) > matrix.length || (j + size) > matrix[0].length) {
            return size;
        }
        boolean isSqare = true;
        // 检查i+size行
        for (int k = 0; k < size; k++) {
            if (matrix[i + size][j + k] == '0') {
                isSqare = false;
                break;
            }
        }
        if (!isSqare) {
            return size;
        }
        // 检查j+size列
        for (int k = 0; k < size; k++) {
            if (matrix[i + k][j + size] == '0') {
                isSqare = false;
                break;
            }
        }
        // 如果没有等于0等则 size +1；
        if (isSqare) {
            size++;
            return findNext(matrix, i, j, size);
        }
        return size;
    }
}
