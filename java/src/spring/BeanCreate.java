package spring;

import java.lang.reflect.Constructor;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.beans.factory.support.CglibSubclassingInstantiationStrategy;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.support.SimpleInstantiationStrategy;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java_.reflective.ConstructorQ;
import spring.bean.init.Bean1;

/**
 * ⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽<br>
 * 1.Spring内部的几个单例bean，是在什么时候创建的？<br>
 * 在用户bean创建之前。<br>
 * {@link AbstractApplicationContext#prepareBeanFactory()}：<br>
 * <br>
 * 2.bean是如何创建的？ <br>
 * 原理：{@link ConstructorQ}。<br>
 * ⑴获取构造器，找出需要的：{@link AbstractAutowireCapableBeanFactory#createBeanInstance()}。<br>
 * ⑵如果构造器有参数要组装参数：{@link AbstractAutowireCapableBeanFactory#autowireConstructor()}。<br>
 * {@link SimpleInstantiationStrategy#instantiate(RootBeanDefinition, String, BeanFactory)}。<br>
 * ⑶反射创建对象：{@link BeanUtils#instantiateClass(Constructor, Object...)}。<br>
 * 或cglib创建对象：{@link CglibSubclassingInstantiationStrategy#instantiateWithMethodInjection()}。<br>
 * <br>
 * 3.创建bean是使用反射还是cglib是根据什么决定的？<br>
 * 根据是否有方法被重写：{@link SimpleInstantiationStrategy#instantiate()}。<br>
 * <br>
 */
public class BeanCreate
{
    public static void main(String[] args)
    {
        testConstructor();
    }

    private static void testConstructor()
    {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "spring/bean/init/conf1.xml");
        Bean1 iBean1 = applicationContext.getBean("bean1", Bean1.class);
        iBean1.show();
        Bean1 iBean2 = applicationContext.getBean("bean2", Bean1.class);
        iBean2.show();
        Bean1 iBean3 = applicationContext.getBean("bean3", Bean1.class);
        iBean3.show();
        applicationContext.close();
    }
}
