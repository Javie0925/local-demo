package pri.jv.rocketmq;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;

/**
 * @ClassName MqProducerFactory
 * @Dscription
 * @Date 3/13/21
 * @Author JV
 **/
public class MqProducerFactory {
    private static DefaultMQProducer producer = null;

    public static DefaultMQProducer getProducer() throws MQClientException {
        producer = new DefaultMQProducer("please_rename_unique_group_name");
        producer.setNamesrvAddr("localhost:9876");
        producer.start();
        return producer;
    }


    public void close(DefaultMQProducer producer){
        producer.shutdown();
    }
}
