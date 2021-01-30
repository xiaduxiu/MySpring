import com.xcr.spring.context.support.ClassPathXmlApplicationContext;
import com.xcr.test.Car;
import org.junit.jupiter.api.Test;

/**
 * @Author: xia
 * @Date: 2021/1/29 17:25
 * @Version: v1.0
 */
public class PrototypeBeanTest {

    @Test
    public void testPrototype() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:prototype-bean.xml");

        Car car1 = applicationContext.getBean("car", Car.class);
        Car car2 = applicationContext.getBean("car", Car.class);
        System.out.println(car1.hashCode());
        System.out.println(car2.hashCode());
        assert car1 != car2;
    }
}
