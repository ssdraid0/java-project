package spring.aop.proxy;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class BeforeAdvice2 implements MethodBeforeAdvice
{
    public void before(Method method, Object[] args, Object target) throws Throwable
    {
        System.out.println("BeforeAdvice2.before() execute ");
    }
}
