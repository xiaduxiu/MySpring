import com.xcr.spring.context.support.ClassPathXmlApplicationContext;
import com.xcr.test.event.CustomEvent;
import org.junit.jupiter.api.Test;

/**
 * @Author: xia
 * @Date: 2021/1/30 16:12
 * @Version: v1.0
 */
public class EventAndEventListenerTest {

    @Test
    public void testEventListener() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:event-and-event-listener.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext));

        applicationContext.registerShutdownHook();//或者applicationContext.close()主动关闭容器;
    }
}
