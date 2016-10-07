package spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.aop.advice.Service;

/**
 * ⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽</br>
 * 1.Aop有几种通知？</br>
 * ⑴.前置通知（Before Advice）：在方法调用之前执行。</br>
 * ⑵.后置通知（After Advice）：在方法调用之后执行，具体细分为：</br>
 * 后置返回通知（After returning Advice）：在方法运行过程中没抛出异常执行。</br>
 * 后置异常通知（After throwing Advice）：在方法运行过程中抛出异常执行。</br>
 * 后置最终通知（After finally Advice）: 不管是否抛出异常都执行。</br>
 * ⑶.环绕通知（Around Advice）：可以在方法调用之前和之后自定义行为，</br>
 * 而且可以替换参数、管理抛出的异常，决定是否执行方法。</br>
 * http://jinnianshilongnian.iteye.com/blog/1418596</br>
 * http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#aop-introduction-defn</br>
 * </br>
 */
@SuppressWarnings("unused")
public class AopAdvice
{
    public static void main(String[] args)
    {
        testAroundAdvice();
    }

    private static void testAdvice()
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring/aop/advice/aop.xml");
        Service helloworldService = ctx.getBean("helloWorldService", Service.class);
        // HelloWorldService2 helloworldService = (HelloWorldService2) ctx.getBean("helloWorldService2");

        System.out.println("//////////////////////////////");
        helloworldService.sayHello();
        System.out.println("//////////////////////////////");
        // helloworldService.sayHelloReturning();
        ctx.close();
    }

    private static void testAroundAdvice()
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring/aop/advice/aop2.xml");
        Service helloworldService = ctx.getBean("helloWorldService", Service.class);
        helloworldService.say("Hello");
        ctx.close();
    }
}
