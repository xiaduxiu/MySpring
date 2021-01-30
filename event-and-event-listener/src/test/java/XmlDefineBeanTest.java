import com.xcr.spring.beans.factory.support.DefaultListableBeanFactory;
import com.xcr.spring.beans.factory.xml.XmlBeanDefinitionReader;
import com.xcr.test.Car;
import com.xcr.test.Person;
import org.junit.jupiter.api.Test;

/**
 * @Author: xia
 * @Date: 2021/1/26 14:19
 * @Version: v1.0
 */
public class XmlDefineBeanTest {

    @Test
    public void testXmlFile() throws Exception {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");

        Person person = (Person) beanFactory.getBean("person");
        System.out.println(person);
        assert person.getName().equals("derek");
        assert person.getCar().getBrand().equals("porsche");

        Car car = (Car) beanFactory.getBean("car");
        System.out.println(car);
        assert car.getBrand().equals("porsche");
    }
}
