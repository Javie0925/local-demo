package pri.jv.redis;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @ClassName TestJedis
 * @Dscription
 * @Date 2/10/21
 * @Author JV
 **/
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestQudianDevRedis {

    Jedis jedis;

    @BeforeAll
    public void before(){
        jedis = new Jedis("new-project-dev.redis.zhangbei.rds.aliyuncs.com",6379);
    }
    @AfterAll
    public void after(){
        jedis.close();
    }

    @Test
    public void test(){
        Set<String> keys = jedis.keys("*");
        keys.stream().forEach(e->{
            System.out.println(e+":"+jedis.type(e));
        });
    }
}
