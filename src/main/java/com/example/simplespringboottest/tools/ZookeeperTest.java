package com.example.simplespringboottest.tools;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.omg.CORBA.TIMEOUT;

import java.io.IOException;

@Slf4j
public class ZookeeperTest {

    private static final String ZK_ADDRESS = "192.168.230.131:2181";
    private static final int SESSION_TIMEOUT = 500000;
    private static ZooKeeper zooKeeper;
    private static final String ZK_NODE = "/zk‐node";


    public static void main(String[] args) throws Exception {
/*
        zooKeeper = new ZooKeeper(ZK_ADDRESS, SESSION_TIMEOUT, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                log.info("watchedEvent:{}", watchedEvent);
                if (watchedEvent.getType() != null && watchedEvent.getState() == Event.KeeperState.SyncConnected) {
                    log.info("连接成功");
                }
            }
        });*/

        // 使用curator
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(SESSION_TIMEOUT, 20);
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder()
                .connectString("192.168.230.101:2181")
                .sessionTimeoutMs(5000) // 会话超时时间
                .connectionTimeoutMs(5000) // 连接超时时间
                .retryPolicy(retryPolicy)
                .namespace("base") // 包含隔离名称
                .build();
        curatorFramework.start();

        String path = curatorFramework.create().forPath("/curator‐node");
        log.info("path:{}", path);
    }


}

