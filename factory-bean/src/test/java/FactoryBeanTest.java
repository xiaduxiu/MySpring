import com.xcr.spring.context.support.ClassPathXmlApplicationContext;
import com.xcr.test.Car;
import org.junit.jupiter.api.Test;

/**
 * @Author: xia
 * @Date: 2021/1/29 17:53
 * @Version: v1.0
 */
public class FactoryBeanTest {

    @Test
    public void testFactoryBean() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:factory-bean.xml");

        Car car = applicationContext.getBean("car", Car.class);
        assert car.getBrand().equals("porsche");
    }

}
