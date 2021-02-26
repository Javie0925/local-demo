package pri.jv.jvspringbootstarter.service;

import org.springframework.stereotype.Service;
import priv.jv.springboot.starter.JvService;

import javax.annotation.Resource;

/**
 * @ClassName TestService
 * @Dscription
 * @Date 2/1/21
 * @Author JV
 **/
@Service
public class TestService {

    @Resource
    private JvService jvService;

    public void invoke(){
        jvService.printPrefix();
    }

}
