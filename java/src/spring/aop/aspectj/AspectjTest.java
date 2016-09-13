package spring.aop.aspectj;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectjTest
{
    public static void main(String[] args)
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring/aop/aspectj/aspectj.xml");
        Hello hello = (Hello) ctx.getBean("hello");
        hello.sayHello();
        ctx.close();
    }
}
