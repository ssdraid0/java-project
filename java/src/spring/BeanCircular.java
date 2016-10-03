package spring;

import java.util.HashSet;

import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.bean.circle.IBean;

/**
 * ⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽<br>
 * 1.IoC容器发现循环依赖会出现什么异常？<br>
 * {@link BeanCurrentlyInCreationException}异常。<br>
 * 2.IoC容器如何检测循环依赖？<br>
 * 用一个{@link HashSet}存储正在创建的bean的名字，创建一个bean之前检测{@link HashSet}。<br>
 * 代码：<br>
 * {@link AbstractBeanFactory#doGetBean()}：。<br>
 * {@link AbstractBeanFactory#isPrototypeCurrentlyInCreation(String)}：判断指定name的原型bean是否正在创建中。<br>
 * {@link AbstractBeanFactory#prototypesCurrentlyInCreation}：用一个{@link ThreadLocal}存储正在创建的bean的。<br>
 * {@link AbstractBeanFactory#beforePrototypeCreation(String)}：将bean的名字添加到{@link HashSet}。<br>
 * <br>
 * 3.IoC容器能解决那种循环依赖？是如何解决的？<br>
 * 使用setter注入，bean不能全部是prototype。<br>
 * <br>
 * 4.IoC容器如何装配bean？<br>
 * <br>
 * http://jinnianshilongnian.iteye.com/blog/1415278 <br>
 */
public class BeanCircular
{
    public static void main(String[] args)
    {
        testSetter();
    }

    public static void testConstructor()
    {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "spring/bean/circle/conf1.xml");
        IBean iBean1 = applicationContext.getBean("bean1", IBean.class);
        IBean iBean2 = applicationContext.getBean("bean2", IBean.class);
        if (iBean1 == iBean2)
            System.out.println(true);
        else
            System.out.println(false);
        applicationContext.close();
    }

    public static void testSetter()
    {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "spring/bean/circle/conf2.xml");
        IBean iBean1 = applicationContext.getBean("bean1", IBean.class);
        IBean iBean2 = applicationContext.getBean("bean2", IBean.class);
        if (iBean1 == iBean2)
            System.out.println(true);
        else
            System.out.println(false);
        applicationContext.close();
    }
}