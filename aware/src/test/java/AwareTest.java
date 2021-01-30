import com.xcr.spring.context.support.ClassPathXmlApplicationContext;
import com.xcr.test.service.HelloService;
import org.junit.jupiter.api.Test;

/**
 * @Author: xia
 * @Date: 2021/1/29 17:02
 * @Version: v1.0
 */
public class AwareTest {

    @Test
    public void test() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        HelloService helloService = applicationContext.getBean("helloService", HelloService.class);
        System.out.println(helloService);
        HelloService helloService1 = applicationContext.getBean("helloService", HelloService.class);
        System.out.println(helloService1);
    }
}
