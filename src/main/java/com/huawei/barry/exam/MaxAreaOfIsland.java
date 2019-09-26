/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019. All rights reserved.
 */

package com.huawei.barry.exam;

import java.util.Scanner;

/**
 * 功能描述
 *
 * @author w00205937
 * @since 2019-09-25
 */
public class MaxAreaOfIsland {
    public static void main(String[] args) {
        int[][] island = getInputs();
        System.out.println(findMaxAreaOfIsland(island));
    }

    private static int[][] getInputs() {
        Scanner scanner = new Scanner(System.in);
        String inputStr = "";
        while (scanner.hasNextLine()) {
            inputStr = inputStr + scanner.nextLine();
            if (inputStr.endsWith("]]")) {
                break;
            }
        }
        inputStr = inputStr.substring(2, inputStr.length() - 2);
        String[] inputs = inputStr.split("],\\[");
        int[][] island = new int[inputs.length][inputs[0].split(",").length];
        for (int i = 0; i < inputs.length; i++) {
            String[] line = inputs[i].split(",");
            for (int j = 0; j < line.length; j++) {
                island[i][j] = Integer.parseInt(line[j]);
            }
        }
        return island;
    }

    private static int findMaxAreaOfIsland(int[][] island) {
        int maxSize = 0;
        boolean[][] isCounted = new boolean[island.length][island[0].length];
        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[i].length; j++) {
                int size = 0;
                // 找单词的第一个字母
                if (island[i][j] == 1 && !isCounted[i][j]) {
                    size++;
                    isCounted[i][j] = true;
                    // 找这个点的四周
                    size = findnext(i - 1, j, island, size, isCounted);
                    size = findnext(i + 1, j, island, size, isCounted);
                    size = findnext(i, j - 1, island, size, isCounted);
                    size = findnext(i, j + 1, island, size, isCounted);
                }
                if (size > maxSize) {
                    maxSize = size;
                }
            }
        }
        return maxSize;
    }

    private static int findnext(int i, int j, int[][] island, int size, boolean[][] isCounted) {
        if (i < 0 || i >= island.length || j < 0 || j >= island[0].length || isCounted[i][j] || island[i][j] == 0) {
            return size;
        }
        size++;
        isCounted[i][j] = true;
        size = findnext(i - 1, j, island, size, isCounted);
        size = findnext(i + 1, j, island, size, isCounted);
        size = findnext(i, j - 1, island, size, isCounted);
        size = findnext(i, j + 1, island, size, isCounted);
        return size;
    }
}
