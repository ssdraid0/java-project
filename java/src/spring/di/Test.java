package spring.di;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 1.什么是DI（Dependency Injection）<br>
 * 将一个对象传递给另一个对象。<br>
 * 2.依赖注入有几种方式？<br>
 * 构造器注入和setter注入。<br>
 * 3.构造器注入有几种方式？<br>
 * index，name，type<br>
 * 4.假如有一个Bean，类为spring.di.Bean，有一个String类型属性i，id为bean，使用setter注入，参数为"setter"，
 * 如何在xml中配置？<br>
 * <bean id="bean" class="spring.di.Bean"> <br>
 * <property name="i" value="setter"/><br>
 * </bean><br>
 * 5.如果改为构造器注入，参数为"index"，如何在xml中配置？<br>
 * <bean id="bean" class="spring.di.Bean"> <br>
 * <constructor-arg index="0" value= "index" /> <br>
 * </bean><br>
 * 6.如果要给属性i注入null，如何配置？<br>
 * <property name="i" ><null/></property><br>
 */
public class Test
{
    public static void main(String[] args)
    {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/di/di.xml");
        IBean iBean = applicationContext.getBean("bean", IBean.class);
        iBean.show();
        iBean = applicationContext.getBean("bean2", IBean.class);
        iBean.show();
        iBean = applicationContext.getBean("bean3", IBean.class);
        iBean.show();
        iBean = applicationContext.getBean("bean4", IBean.class);
        iBean.show();
        applicationContext.close();
    }
}
