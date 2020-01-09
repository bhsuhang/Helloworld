/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019. All rights reserved.
 */

package com.huawei.barry.exam;

/**
 * 功能描述
 *
 * @author w00205937
 * @since 2019-10-30
 */
public class TestSecurityManager {
    public static void main(String[] args) {
        System.setSecurityManager(new SecurityManager());
        System.setProperty("java.version", "1.7.0_45");
        String property = System.getProperty("java.version");
        System.err.println(property);

    }
}
