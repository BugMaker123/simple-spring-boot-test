package com.example.simplespringboottest.prac.net.nio;

import java.io.IOException;
import java.net.SocketAddress;
import java.nio.channels.DatagramChannel;
import java.nio.channels.Selector;
import java.nio.channels.spi.SelectorProvider;

public class SimpleSelectorTest {
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        System.out.println(selector.isOpen());
        SelectorProvider provider = selector.provider();
        DatagramChannel datagramChannel = provider.openDatagramChannel();
        SocketAddress localAddress = datagramChannel.getLocalAddress();
        System.out.println(localAddress);

    }
}
