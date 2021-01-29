import com.xcr.spring.context.support.ClassPathXmlApplicationContext;
import com.xcr.test.Car;
import com.xcr.test.Person;
import org.junit.jupiter.api.Test;

/**
 * @Author: xia
 * @Date: 2021/1/29 14:25
 * @Version: v1.0
 */
public class ApplicationContextTest {

    @Test
    public void testApplicationContext() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");

        Person person = applicationContext.getBean("person", Person.class);
        System.out.println(person);
        //name属性在CustomBeanFactoryPostProcessor中被修改为ivy
        assert person.getName().equals("ivy");

        Car car = applicationContext.getBean("car", Car.class);
        System.out.println(car);
        //brand属性在CustomerBeanPostProcessor中被修改为lamborghini
        assert car.getBrand().equals("tttt");
    }

}
