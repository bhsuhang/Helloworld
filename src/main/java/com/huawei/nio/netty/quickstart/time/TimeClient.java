package com.huawei.nio.netty.quickstart.time;

import com.sun.org.apache.xml.internal.resolver.helpers.BootstrapResolver;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class TimeClient {
    public static void main(String[] args) throws InterruptedException {

        String host = args[0];
        int port = Integer.parseInt(args[1]);

        NioEventLoopGroup workergroup = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap();
            b.group(workergroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.handler(new ChannelInitializer<SocketChannel>() {

                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new TimeClientHandler());
                }
            });

            ChannelFuture f = b.connect(host, port).sync(); // (5)

            f.channel().closeFuture().sync();


        }finally {
            workergroup.shutdownGracefully();
        }

    }
}
