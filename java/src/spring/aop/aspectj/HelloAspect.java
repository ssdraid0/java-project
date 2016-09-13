package spring.aop.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class HelloAspect
{
    @Pointcut("execution(* spring.aop.aspectj.Hello.sayHello(..))")
    public void foundHello()
    {
    }

    @Before(value = "foundHello()")
    public void foundBefore()
    {
        System.out.println("before");
    }

}
