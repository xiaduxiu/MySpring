import com.xcr.spring.context.support.ClassPathXmlApplicationContext;
import org.junit.jupiter.api.Test;

/**
 * @Author: xia
 * @Date: 2021/1/29 16:38
 * @Version: v1.0
 */
public class InitAndDestoryBeanTest {

    @Test
    public void testInitAndDestroyMethod() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();  //或者手动关闭 applicationContext.close();
    }
}
