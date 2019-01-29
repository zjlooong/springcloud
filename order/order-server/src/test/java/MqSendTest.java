import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MqSendTest extends BaseTest {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void send(){
        amqpTemplate.convertAndSend("myQueue","now:"+new Date());
    }
    @Test
    public void sendComputer(){
        amqpTemplate.convertAndSend("myOrder","computer","now:"+new Date());
    }
}
