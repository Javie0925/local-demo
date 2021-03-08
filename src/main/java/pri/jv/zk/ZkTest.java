package pri.jv.zk;


import org.apache.zookeeper.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName ZkTest
 * @Dscription
 * @Date 3/8/21
 * @Author JV
 **/
public class ZkTest {

    private ZooKeeper zk;

    @Test
    public void test() throws KeeperException, InterruptedException {
        String s = zk.create("/create/dlskfj", "create".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(s);
        zk.exists("/exist", new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

            }
        });
    }


    @Before
    public void before(){
        try {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            zk = new ZooKeeper("127.0.0.1:2181", 5000, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    if (event.getState() == Event.KeeperState.SyncConnected) {
                        System.out.println("---------Zookeper connect successfully!---------");
                        countDownLatch.countDown();
                    }
                }
            });
            countDownLatch.await();
            System.out.printf("---------sessionId:%s---------\n", zk.getSessionId());
        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }

    @After
    public void after(){
        try {
            if (Objects.nonNull(zk)) {
                zk.close();
                System.out.println("---------Zookeper close successfully!---------");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
