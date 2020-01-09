/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019. All rights reserved.
 */

package com.huawei.barry.exam;

import java.util.Collections;
import java.util.List;

/**
 * 功能描述
 *
 * @author w00205937
 * @since 2019-10-30
 */
public class PrintCollection {

    public void print(List<String> collection) {
        Collections.sort(collection, (o1, o2) -> o1.compareTo(o2));
        collection.stream().forEach(System.out::println);
    }

    public static void main(String[] args) {

    }
}
