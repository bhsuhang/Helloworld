/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019. All rights reserved.
 */

package com.huawei.nio;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * 功能描述
 *
 * @author w00205937
 * @since 2019-10-30
 */
public class BioClient {
    public static void main(String[] args) {
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress("localhost", 8090));
            InputStream inputStream = socket.getInputStream();
            byte[] buffer = new byte[1024];
            while (inputStream.read(buffer) != -1) {
                System.out.println(new String(buffer));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
