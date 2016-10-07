package spring;

import java.util.HashSet;

import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.bean.circle.IBean;

/**
 * ⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽</br>
 * 1.循环依赖（Circular dependencies）有哪几种情况？什么情况会出现异常？</br>
 * ⑴.构造器注入循环依赖。</br>
 * ⑵.setter注入循环依赖，必须是singleton。</br>
 * </br>
 * 2.IoC容器发现循环依赖会出现什么异常？</br>
 * {@link BeanCurrentlyInCreationException}异常。</br>
 * </br>
 * 3.IoC容器如何检测循环依赖？</br>
 * 用一个{@link HashSet}存储正在创建的bean的名字，创建一个bean之前检测{@link HashSet}。</br>
 * 代码：</br>
 * {@link AbstractBeanFactory#doGetBean()}：。</br>
 * ⑴.判断指定name的原型bean是否正在创建中：{@link AbstractBeanFactory#isPrototypeCurrentlyInCreation(String)}。</br>
 * ⑵.用一个{@link ThreadLocal}存储正在创建的bean： {@link AbstractBeanFactory#prototypesCurrentlyInCreation}。</br>
 * ⑶.将bean的名字添加到{@link HashSet}：{@link AbstractBeanFactory#beforePrototypeCreation(String)}。</br>
 * </br>
 * 4.IoC容器是如何解决setter注入循环依赖？</br>
 * </br>
 * 5.IoC容器如何装配bean？</br>
 * </br>
 * http://jinnianshilongnian.iteye.com/blog/1415278 </br>
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
        if (iBean1 == iBean2) System.out.println(true);
        else System.out.println(false);
        applicationContext.close();
    }

    public static void testSetter()
    {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "spring/bean/circle/conf2.xml");
        IBean iBean1 = applicationContext.getBean("bean1", IBean.class);
        IBean iBean2 = applicationContext.getBean("bean2", IBean.class);
        if (iBean1 == iBean2) System.out.println(true);
        else System.out.println(false);
        applicationContext.close();
    }
}