package spring.aop.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class Aspect
{
    // 前置通知
    public void before()
    {
        System.out.println("before");
    }

    // 环绕通知
    public void around(ProceedingJoinPoint pjp)
    {
        System.out.println("around");
        try
        {
            pjp.proceed();
        } catch (Throwable e)
        {}
        System.out.println("around");
    }

    // 环绕通知
    public void around2(ProceedingJoinPoint pjp)
    {
        System.out.println("around");
        Object[] objects = { "ReplaceHello" };
        try
        {
            pjp.proceed(objects);
        } catch (Throwable e)
        {}
        System.out.println("around");
    }

    // 后置最终通知
    public void after()
    {
        System.out.println("after");
    }

    // 后置返回通知
    public void afterReturning(Object str)
    {
        System.out.println("after returning:" + str);
    }

    // 后置异常通知
    public void afterThrowing(Exception exception)
    {
        System.out.println("after throwing:" + exception.getMessage());
    }

}
