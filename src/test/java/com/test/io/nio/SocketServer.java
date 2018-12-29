package com.test.io.nio;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 *
 */
public class SocketServer {

    private ServerSocketChannel serverSocketChannel;
    private Selector selector;

    private long timeout;

    public SocketServer() throws IOException {
        this("localhost", 8080);
    }

    public SocketServer(String host, int port) throws IOException {
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(host, port));
        selector = Selector.open();
        serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
        this.timeout = 1000;
        start();
    }

    public void start(){
        while(true){
            try {
                execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void execute() throws IOException {
        selector.select();
        //Set<SelectionKey> keys = selector.selectedKeys();
        Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
        while(iterator.hasNext()){
            SelectionKey key = iterator.next();
            iterator.remove();
            if(key.isValid())
                if(key.isAcceptable())
                    accept(key);
                else if(key.isWritable())
                    write(key);
                else if(key.isReadable())
                    read(key);
                else if(key.isConnectable())
                    connect(key);
        }
    }

    public void connect(SelectionKey key) {

    }

    public void accept(SelectionKey key) throws IOException {
        ServerSocketChannel ssc = (ServerSocketChannel)key.channel();
        SocketChannel sc = ssc.accept();
        sc.configureBlocking(false);
        sc.register(selector, SelectionKey.OP_READ);
    }

    public void read(SelectionKey key) throws IOException {
        SocketChannel sc = (SocketChannel) key.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(64);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while(true){
            int len = sc.read(byteBuffer);
            if(len == -1) {
                sc.close();
                System.out.println("关闭的通道");
                return;
            }
            if(len == 0) {
                break;
            }
            byteBuffer.flip();
            bos.write(byteBuffer.array(), 0, byteBuffer.limit());
            byteBuffer.clear();
        }
        byte[] bytes = bos.toByteArray();
        if(bytes.length > 0){
            sc.configureBlocking(false);
            sc.register(selector, SelectionKey.OP_WRITE, new String(bos.toByteArray()));
        }
    }

    public void write(SelectionKey key) throws IOException {
        SocketChannel sc = (SocketChannel) key.channel();
        Object o = key.attachment();
        System.out.println(o);
        sc.write(ByteBuffer.wrap(o.toString().getBytes()));
        sc.register(selector, SelectionKey.OP_READ);
    }

    public static void main(String[] args) throws IOException {
        new SocketServer("localhost", 8888);
    }

}