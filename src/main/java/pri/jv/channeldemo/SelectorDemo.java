package pri.jv.channeldemo;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;


/**
 * @ClassName SelectorDemo
 * @Dscription
 * @Date 2020/8/9
 * @Author JV
 **/
public class SelectorDemo {

    @Test
    public void main() throws Exception {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9898);
        SelectableChannel channel = socket.getChannel();
        Selector selector = Selector.open();
        channel.configureBlocking(false);
        /**
         * 读: SelectionKey.OP_READ （1）
         * 写: SelectionKey.OP_WRITE （4）
         * 连接: SelectionKey.OP_CONNECT（8）
         * 接收: SelectionKey.OP_ACCEPT （16）
         */
        channel.register(selector, SelectionKey.OP_READ);
    }

    @Test
    public void testResource() throws Exception {
        Class<?> aClass = Class.forName("DemoBean");
        Object instance = aClass.newInstance();
        Field declaredField = aClass.getDeclaredField("name");
        declaredField.setAccessible(true);
        declaredField.set(instance,"javie");
        System.out.println(instance);
    }
}
