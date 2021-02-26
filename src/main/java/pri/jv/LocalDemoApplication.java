package pri.jv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @ClassName Application
 * @Dscription
 * @Date 2021/1/7
 * @Author JV
 **/
@SpringBootApplication
public class LocalDemoApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(LocalDemoApplication.class, args);
        System.out.println();
    }
}
