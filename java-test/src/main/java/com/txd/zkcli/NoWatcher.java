package com.txd.zkcli;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * 不设置监听的
 */
public class NoWatcher {

    /**
     * zk连接url
     */
    private static final String CONNECTURL = "192.168.41.129:2181";

    /**
     * 连接超时时间
     */
    private static final int SESSION_CONNECTIONTIME = 5 * 1000;

    private static ZooKeeper zooKeeper = null;

    private static final String WATCH_PATH ="/test";

    /**
     * 启动zk
     *
     * @throws IOException 异常
     */
    public void startZk() throws IOException {
        zooKeeper = new ZooKeeper(CONNECTURL, SESSION_CONNECTIONTIME, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if (WATCH_PATH.equals(watchedEvent.getPath())){
                    try {
                        System.out.println("data changed,new value:"+getNodeValue(WATCH_PATH));
                    } catch (KeeperException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }{
                    System.out.println("===========no change====");
                }
            }
        });
    }

    /**
     * 停止服务
     *
     * @throws InterruptedException 异常
     */
    public void stopZk() throws InterruptedException {
        if (zooKeeper != null) {
            zooKeeper.close();
        }
    }

    public void createNode(String path, String nodeValue) throws KeeperException, InterruptedException {
        byte[] bytes = nodeValue.getBytes(Charset.forName("UTF-8"));
        // 参数：路径，值，权限问题：默认写ZooDefs.Ids.OPEN_ACL_UNSAFE，节点类型（永久或临时）
       zooKeeper.create(path, bytes, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    public String getNodeValue(String nodePath) throws KeeperException, InterruptedException {
        // 参数：路径，监听，节点结构（默认直接创建）
        byte[] data = zooKeeper.getData(nodePath, false, new Stat());
        return data == null ? null:new String(data,Charset.forName("UTF-8"));
    }

    public static void main(String[] args) {
        NoWatcher noWatcher = new NoWatcher();
        try {
            noWatcher.startZk();
            noWatcher.createNode("/test","123");
//            try {
//                TimeUnit.DAYS.sleep(Integer.MAX_VALUE);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            String nodeValue = noWatcher.getNodeValue("/test");
            System.out.println(nodeValue);
            noWatcher.stopZk();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }
}
