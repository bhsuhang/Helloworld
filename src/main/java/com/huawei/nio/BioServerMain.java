/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019. All rights reserved.
 */

package com.huawei.nio;

import java.io.IOException;

/**
 * 功能描述
 *
 * @author w00205937
 * @since 2019-10-30
 */
public class BioServerMain {
    public static void main(String[] args) {
        BioServer bioServer = new BioServer();
        try {
            bioServer.serve(8090);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
