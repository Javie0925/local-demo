package pri.jv.rocketmq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * @ClassName ProducerTest
 * @Dscription
 * @Date 3/13/21
 * @Author JV
 **/
public class ProducerTest {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer producer = MqProducerFactory.getProducer();
        for (int i=0;i<100;i++){
            System.out.printf("----------------%s----------------\n",i);
            Message message = new Message("TopicTest", "TagA", "key1", 1, ("hello rocketMQ_"+i).getBytes(), true);
            SendResult result = producer.send(message);
            System.out.printf("result:%s\n",result);
        }
        producer.shutdown();
    }
}
