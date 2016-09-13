package spring.aop.proxy;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class AfterAdvice2 implements AfterReturningAdvice
{

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable
    {
        System.out.println("AfterAdvice2.afterReturning() execute ");  
    }

}
