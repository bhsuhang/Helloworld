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
public class WordMaze {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String size = scanner.nextLine();
        int n = Integer.parseInt(size.split(" ")[0]);
        int m = Integer.parseInt(size.split(" ")[1]);
        String words = scanner.nextLine();
        char[][] maze = new char[n][m];
        int i = 0;
        while (true) {
            if (i == n) {
                break;
            }
            String input = scanner.nextLine();
            char[] inputChars = input.toCharArray();
            maze[i] = inputChars;
            i++;
        }
        System.out.println(findWords(words, maze));
    }

    private static String findWords(String words, char[][] maze) {
        char[] wordsChars = words.toCharArray();
        int n = 0;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                boolean[][] isEated = new boolean[maze.length][maze[0].length];
                // 找单词的第一个字母
                if (wordsChars[n] == maze[i][j]) {
                    isEated[i][j] = true;
                    // 找单词的其余字母
                    if (findnext(wordsChars, n + 1, maze, i, j, isEated)) {
                        // System.out.print("(" + i + "," + j + ")");
                        return "YES";
                    }
                }
            }
        }
        return "NO";
    }

    private static boolean findnext(char[] wordsChars, int n, char[][] maze, int i, int j, boolean[][] isEeated) {
        // 如果匹配完了，则返回匹配成功
        if (n == wordsChars.length) {
            return true;
        }
        boolean isfind = false;
        boolean[][] newIsEeated = isEeated;
        // copyMatrix(isEeated, newIsEeated);
        // 找这个Maze上下左右的字符,并且这个字符没有被使用过
        if (i > 0 && !newIsEeated[i - 1][j] && wordsChars[n] == maze[i - 1][j]) {
            newIsEeated[i - 1][j] = true;
            isfind = findnext(wordsChars, n + 1, maze, i - 1, j, newIsEeated);
            if (isfind) {
                // System.out.print("(" + (i - 1) + "," + j + ")");
                return isfind;
            } else {
                newIsEeated[i - 1][j] = false;
            }
        }
        if (i < maze.length - 1 && !newIsEeated[i + 1][j] && wordsChars[n] == maze[i + 1][j]) {
            newIsEeated[i + 1][j] = true;
            isfind = findnext(wordsChars, n + 1, maze, i + 1, j, newIsEeated);
            if (isfind) {
                // System.out.print("(" + (i + 1) + "," + j + ")");
                return isfind;
            } else {
                newIsEeated[i + 1][j] = false;
            }
        }
        if (j > 0 && !newIsEeated[i][j - 1] && wordsChars[n] == maze[i][j - 1]) {
            newIsEeated[i][j - 1] = true;
            isfind = findnext(wordsChars, n + 1, maze, i, j - 1, newIsEeated);
            if (isfind) {
                // System.out.print("(" + (i) + "," + (j - 1) + ")");
                return isfind;
            } else {
                newIsEeated[i][j - 1] = false;
            }
        }
        if (j < maze[0].length - 1 && !newIsEeated[i][j + 1] && wordsChars[n] == maze[i][j + 1]) {
            newIsEeated[i][j + 1] = true;
            isfind = findnext(wordsChars, n + 1, maze, i, j + 1, newIsEeated);
            if (isfind) {
                // System.out.print("(" + (i) + "," + (j + 1) + ")");
                return isfind;
            } else {
                newIsEeated[i][j + 1] = false;
            }
        }
        return false;
    }

    // private static void copyMatrix(boolean[][] src, boolean[][] target) {
    // for (int i = 0; i < src.length; i++) {
    // for (int j = 0; j < src[i].length; j++) {
    // target[i][j] = src[i][j];
    // }
    // }
    // }
}
