/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019. All rights reserved.
 */

package com.huawei.barry.exam;

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 功能描述
 *
 * @author w00205937
 * @since 2019-09-21
 */
class Standing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            long totalNumber = scanner.nextLong();
            printPossibleRanking(totalNumber);
        }
    }

    private static void printPossibleRanking(long totalNumber) {
        SortedSet<Long> set = new TreeSet();
        for (int i = 1; i <= Math.sqrt(totalNumber); i++) {
            if (totalNumber % i == 0) {
                set.add((long) i);
                set.add(totalNumber / i);
            }
        }
        System.out.print(set.size() + " ");
        for (Long i : set) {
            System.out.print(i);
            if (i < totalNumber) {
                System.out.print(" ");
            }
        }
    }
}
