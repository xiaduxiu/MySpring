import com.xcr.spring.beans.factory.config.BeanDefinition;
import com.xcr.spring.beans.factory.support.DefaultListableBeanFactory;
import org.junit.jupiter.api.Test;
import test.TestService;

/**
 * @ClassName: BeanDefinitionTest
 * @Create by: 12037
 * @Date: 2021/1/7 22:28
 */
public class BeanDefinitionTest {

    @Test
    public void testSimpleBeanContainer() throws Exception {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerBeanDefinition("service", new BeanDefinition(TestService.class));
        TestService service = (TestService) beanFactory.getBean("service");
        service.test();
    }

}
