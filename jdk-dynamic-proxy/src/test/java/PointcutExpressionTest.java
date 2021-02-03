import com.xcr.spring.aop.aspectj.AspectJExpressionPointCut;
import com.xcr.test.service.HelloService;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

/**
 * @Author: xia
 * @Date: 2021/2/3 17:10
 * @Version: v1.0
 */
public class PointcutExpressionTest {

    @Test
    public void test() throws NoSuchMethodException {
        AspectJExpressionPointCut point = new AspectJExpressionPointCut("execution(* com.xcr.test.service.HelloService.*(..))");
        Class<HelloService> helloServiceClass = HelloService.class;
        Method sayHello = helloServiceClass.getDeclaredMethod("sayHello");

        boolean matches = point.matches(helloServiceClass);
        boolean matches1 = point.matches(sayHello, helloServiceClass);
        System.out.println(matches);
        System.out.println(matches1);

    }

}
