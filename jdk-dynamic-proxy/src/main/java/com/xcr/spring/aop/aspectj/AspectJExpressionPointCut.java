package com.xcr.spring.aop.aspectj;

import com.xcr.spring.aop.ClassFilter;
import com.xcr.spring.aop.MethodMatcher;
import com.xcr.spring.aop.PointCut;
import org.aspectj.weaver.tools.PointcutExpression;
import org.aspectj.weaver.tools.PointcutParser;
import org.aspectj.weaver.tools.PointcutPrimitive;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: xia
 * @Date: 2021/2/3 17:02
 * @Version: v1.0
 */
public class AspectJExpressionPointCut implements PointCut, ClassFilter, MethodMatcher {
    private static final Set<PointcutPrimitive> SUPPORTD_PRIMITIVES = new HashSet<>();

    static {
        SUPPORTD_PRIMITIVES.add(PointcutPrimitive.EXECUTION);
    }

    private final PointcutExpression pointcutExpression;

    public AspectJExpressionPointCut(String expression) {
        PointcutParser pointcutParser = PointcutParser.getPointcutParserSupportingSpecifiedPrimitivesAndUsingSpecifiedClassLoaderForResolution(SUPPORTD_PRIMITIVES, this.getClass().getClassLoader());
        this.pointcutExpression = pointcutParser.parsePointcutExpression(expression);
    }


    @Override
    public boolean matches(Class<?> clazz) {
        return pointcutExpression.couldMatchJoinPointsInType(clazz);
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return pointcutExpression.matchesMethodExecution(method).alwaysMatches();
    }

    @Override
    public ClassFilter getClassFilter() {
        return this;
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return this;
    }
}
