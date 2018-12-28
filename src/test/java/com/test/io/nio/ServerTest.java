package com.test.io.nio;

import com.sys.util.TimeUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 */
public class ServerTest {

    public static void main(String[] args) {
        try {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.configureBlocking(false);
            ssc.bind(new InetSocketAddress("localhost",9001));
            Selector sel = Selector.open();
            ssc.register(sel, SelectionKey.OP_ACCEPT);
            ExecutorService es = Executors.newFixedThreadPool(10);
            while(true){
                sel.select();
                Iterator<SelectionKey> it = sel.selectedKeys().iterator();
                while(it.hasNext()){
                    SelectionKey key = it.next();
                    it.remove();
                    if(key.isAcceptable()){
                        SocketChannel sc = ssc.accept();
                        sc.configureBlocking(false);
                        sc.register(sel, SelectionKey.OP_READ);
                    }else if(key.isReadable()){
                        es.execute(new Runnable() {
                            public void run() {
                                SocketChannel sc = (SocketChannel) key.channel();
                                ByteBuffer buf = ByteBuffer.allocate(1024);
                                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                                try {
                                    for(int len = sc.read(buf); ; len = sc.read(buf)){
                                        System.out.println(len);
                                        if(len<=0)
                                            break;
                                        bos.write(buf.array(),0, buf.limit());
                                        buf.clear();
                                    }
                                    TimeUtils.sleep(1000);
                                    System.out.println(Arrays.toString(bos.toByteArray()));
                                    sc.register(sel, SelectionKey.OP_ACCEPT);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }else if(key.isWritable()){
                        System.out.println("写");
                    }else if(key.isConnectable()){

                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}