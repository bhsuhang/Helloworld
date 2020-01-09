/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019. All rights reserved.
 */

package com.huawei.barry.exam;

import java.security.SecureRandom;
import java.util.Collection;
import java.util.Vector;

/**
 * 功能描述
 *
 * @author w00205937
 * @since 2019-10-30
 */
public class CompareSetPerformance {
    public static void main(String[] args) {
        Vector<String> list = new Vector<>();
        init(list);
        long start = System.currentTimeMillis();
        if (list.contains("Barry")) {
            System.out.println("time consumed :" + (System.currentTimeMillis() - start));
        }

    }

    private static void init(Collection collection) {
        for (int i = 0; i < 1000000; i++) {
            if (i == (1000000 - 100)) {
                collection.add("Barry");
                continue;
            }
            collection.add(String.valueOf(new SecureRandom().nextInt(1000)));
        }
    }
}
