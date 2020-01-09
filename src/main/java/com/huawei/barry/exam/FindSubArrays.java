/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019. All rights reserved.
 */

package com.huawei.barry.exam;

import java.util.HashSet;
import java.util.Set;

/**
 * 功能描述
 *
 * @author w00205937
 * @since 2019-09-30
 */
class FindSubArrays {
    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 1, 2, 3};
        System.out.println(subarraysWithKDistinct2(array, 2));
    }

    public static int subarraysWithKDistinct(int[] a, int size) {
        int count = 0;
        for (int len = size; len <= a.length; len++) {
            for (int i = 0; i <= a.length - len; i++) {
                count += findNext(i, a, len, size);
            }
        }
        return count;
    }

    private static int findNext(int i, int[] array, int lengh, int size) {
        Set set = new HashSet();
        for (int j = 0; j < lengh; j++) {
            set.add(array[i + j]);
        }
        return set.size() == size ? 1 : 0;
    }

    /*
     * 更换思路，一次查到底
     */
    public static int subarraysWithKDistinct2(int[] a, int size) {
        int count = 0;
        for (int i = 0; i <= a.length - size; i++) {
            count += findNext2(i, a, size);
        }
        return count;
    }

    private static int findNext2(int i, int[] array, int size) {
        int count = 0;
        Set set = new HashSet();
        for (int j = 0; j < array.length - i; j++) {
            set.add(array[i + j]);
            count += set.size() == size ? 1 : 0;
            if (set.size() > size) {
                break;
            }
        }
        return count;
    }
}
