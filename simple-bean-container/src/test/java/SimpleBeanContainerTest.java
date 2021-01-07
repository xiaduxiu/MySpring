import com.xcr.spring.beans.BeanFactory;
import org.junit.jupiter.api.Test;
import test.TestService;

/**
 * @ClassName: SimpleBeanContainerTest
 * @Create by: 12037
 * @Date: 2021/1/7 22:28
 */
public class SimpleBeanContainerTest {

    @Test
    public void testSimpleBeanContainer() {
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.register("test", new TestService());
        TestService test = (TestService) beanFactory.getBean("test");
        System.out.println(test.test());
    }

}
