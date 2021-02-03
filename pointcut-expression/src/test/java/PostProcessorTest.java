import com.xcr.spring.beans.factory.support.DefaultListableBeanFactory;
import com.xcr.spring.beans.factory.xml.XmlBeanDefinitionReader;
import com.xcr.test.Car;
import com.xcr.test.CustomBeanFactoryPostProcessor;
import com.xcr.test.CustomBeanPostProcessor;
import com.xcr.test.Person;
import org.junit.jupiter.api.Test;

/**
 * @Author: xia
 * @Date: 2021/1/26 15:02
 * @Version: v1.0
 */
public class PostProcessorTest {

    @Test
    public void testBeanFactoryPostProcessor() throws Exception {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");

        CustomBeanFactoryPostProcessor beanFactoryPostProcessor = new CustomBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessorBeanFactory(beanFactory);

        Person person = (Person) beanFactory.getBean("person");
        System.out.println(person);

        Car car = (Car) beanFactory.getBean("car");
        System.out.println(car);
    }

    @Test
    public void testBeanPostProcessor() throws Exception {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");

        CustomBeanPostProcessor beanPostProcessor = new CustomBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);

        Person person = (Person) beanFactory.getBean("person");
        System.out.println(person);

        Car car = (Car) beanFactory.getBean("car");
        System.out.println(car);
    }
}
