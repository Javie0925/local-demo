package pri.jv.zk;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName ZkDemo
 * @Dscription
 * @Date 3/8/21
 * @Author JV
 **/
public class ZkDemo {

    public static void main(String[] args) {
        ZooKeeper zooKeeper = null;
        try {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            zooKeeper = new ZooKeeper("127.0.0.1:2181", 5000, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    if (event.getState() == Event.KeeperState.SyncConnected) {
                        System.out.println("---------Zookeper connect successfully!---------");
                        countDownLatch.countDown();
                    }
                }
            });
            countDownLatch.await();
            System.out.printf("---------sessionId:%s---------\n", zooKeeper.getSessionId());
        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }finally {
            try {
                zooKeeper.close();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
