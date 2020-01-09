
package com.huawei.nio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

public class BioServer {

    public void serve(int port) throws IOException {
        final ServerSocket socket = new ServerSocket(port);     // 1
        try {
            for (;;) {
                final Socket clientSocket = socket.accept();    // 2
                System.out.println("Accepted connection from " + clientSocket);

                new Thread(new Runnable() {                        // 3
                    @Override
                    public void run() {
                        OutputStream out;
                        try {
                            // TimeUnit.MILLISECONDS.sleep(100000);
                            out = clientSocket.getOutputStream();
                            out.write("Hi!\r\n".getBytes(Charset.forName("UTF-8")));                            // 4
                            out.flush();
                            clientSocket.close();                // 5

                        } catch (Exception e) {
                            e.printStackTrace();
                            try {
                                clientSocket.close();
                            } catch (IOException ex) {
                                // ignore on close
                            }
                        }
                    }
                }).start();                                        // 6
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}