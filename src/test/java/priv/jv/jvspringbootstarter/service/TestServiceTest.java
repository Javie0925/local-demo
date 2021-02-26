package priv.jv.jvspringbootstarter.service;

import org.junit.jupiter.api.Test;
import priv.jv.springboot.starter.JvService;

import javax.annotation.Resource;

/**
 * @ClassName TestService
 * @Dscription
 * @Date 2/1/21
 * @Author JV
 **/
public class TestServiceTest extends BaseTest {

    @Resource
    private JvService service;

    @Test
    public void test(){
        service.printPrefix();
    }

}
