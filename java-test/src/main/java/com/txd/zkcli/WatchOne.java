package com.txd.zkcli;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * 获得首次初始值后打印，设置watch一次监听，变化后得到最新值。
 */
public class WatchOne {

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
        byte[] data = zooKeeper.getData(nodePath, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                try {
                    trigger(watchedEvent.getPath());
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, new Stat());
        return data == null ? null:new String(data,Charset.forName("UTF-8"));
    }

    public void trigger(String path) throws KeeperException, InterruptedException {
        if(WATCH_PATH.equals(path)){
            byte[] data = zooKeeper.getData(path, false, new Stat());
            String result = new String(data, Charset.forName("UTF-8"));
            System.out.println("watch one time ============"+result);
        }else{
            System.out.println("==========no change ========");
        }
    }

    public static void main(String[] args) {
        WatchOne noWatcher = new WatchOne();
        try {
            noWatcher.startZk();
            noWatcher.createNode("/test","123");
            String nodeValue = noWatcher.getNodeValue("/test");
            System.out.println("first return value======="+nodeValue);

            Thread.sleep(Long.MAX_VALUE);
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
