package pri.jv.apollo;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;

import java.util.Set;

/**
 * @ClassName TestApollo
 * @Dscription
 * @Date 2021/1/20
 * @Author JV
 **/
public class TestApollo {

    public static void main(String[] args) throws InterruptedException {
        Config config = ConfigService.getConfig("TEST1.spring-boot-http");
        Set<String> propertyNames = config.getPropertyNames();
        for (String s:propertyNames) {
            String property = config.getProperty(s, "null");
            System.out.println(s+"="+property);
        }
    }
}
