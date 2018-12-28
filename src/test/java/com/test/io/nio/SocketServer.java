package com.test.io.nio;

import java.io.IOException;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 *
 */
public class SocketServer {

    private ServerSocketChannel serverSocketChannel;
    private Selector selector;

    public SocketServer() throws IOException {
        this("localhost", 8080);
    }

    public SocketServer(String host, int port) throws IOException {
        serverSocketChannel = ServerSocketChannel.open();
        selector = Selector.open();
    }

}