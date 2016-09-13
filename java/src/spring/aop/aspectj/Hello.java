package spring.aop.aspectj;

import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Hello
{
    public void sayHello()
    {
        System.out.println("Hello");
    }
}
