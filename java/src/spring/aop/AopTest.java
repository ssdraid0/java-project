package spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest
{
    public static void main(String[] args)
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring/aop/aop.xml");
        IHelloWorldService helloworldService = ctx.getBean("helloWorldService", IHelloWorldService.class);
         //HelloWorldService2 helloworldService = (HelloWorldService2) ctx.getBean("helloWorldService2");

        System.out.println("//////////////////////////////");
        helloworldService.sayHello();
        System.out.println("//////////////////////////////");
        // helloworldService.sayHelloReturning();
        ctx.close();
    }
}
