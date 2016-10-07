package spring;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.beans.factory.support.CglibSubclassingInstantiationStrategy;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.support.SimpleInstantiationStrategy;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.ConstructorResolver;

import java_.reflective.ConstructorQ;
import java_.reflective.MethodQ;
import spring.bean.instantiating.Bean1;

/**
 * ⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽</br>
 * 1.bean创建有几种方式？ </br>
 * ⑴.构造方法。</br>
 * ⑵.静态工厂方法。</br>
 * ⑶.实例工厂方法。</br>
 * 2.Spring内部的几个单例bean，是在什么时候创建的？</br>
 * 在用户bean创建之前。</br>
 * {@link AbstractApplicationContext#prepareBeanFactory()}：</br>
 * </br>
 * 3.bean是如何创建的？ </br>
 * ⑴.{@link AbstractBeanFactory#doGetBean()}。</br>
 * ⑵.{@link AbstractAutowireCapableBeanFactory#createBean(Class, int, boolean)}。</br>
 * ⑶.{@link AbstractAutowireCapableBeanFactory#doCreateBean()}。</br>
 * ⑷.判断使用哪种方式创建bean实例：{@link AbstractAutowireCapableBeanFactory#createBeanInstance()}。</br>
 * 如果是工厂方法方式：</br>
 * ⑸.先获取工厂方法名：{@link AbstractAutowireCapableBeanFactory#instantiateUsingFactoryMethod()}。</br>
 * ⑹.调用{@link Method#invoke(Object, Object...)}获取一个实例。</br>
 * {@link SimpleInstantiationStrategy#instantiate(RootBeanDefinition,String, BeanFactory,Object,Method,Object...)}
 * 。</br>
 * 如果是构造方法方式：</br>
 * ⑸.先找出需要的构造器：{@link AbstractAutowireCapableBeanFactory#createBeanInstance()}。</br>
 * ⑹.如果构造器有参数要先组装参数：{@link AbstractAutowireCapableBeanFactory#autowireConstructor()}。</br>
 * 然后：{@link SimpleInstantiationStrategy#instantiate(RootBeanDefinition, String, BeanFactory)}。</br>
 * ⑺.反射（没有方法被重写）：{@link BeanUtils#instantiateClass(Constructor, Object...)}。</br>
 * 或cglib（有方法被重写）：{@link CglibSubclassingInstantiationStrategy#instantiateWithMethodInjection()}。</br>
 * ⑻.调用{@link Constructor#newInstance(Object...)}获取一个实例。</br>
 * </br>
 */
@SuppressWarnings("unused")
public class BeanInstantiating
{
    public static void main(String[] args)
    {
        // testConstructor();
        testStaticFactoryMethod();
    }

    private static void testConstructor()
    {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "spring/bean/instantiating/conf1.xml");
        Bean1 iBean = applicationContext.getBean("bean1", Bean1.class);
        iBean.show();
        applicationContext.close();
    }

    private static void testStaticFactoryMethod()
    {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "spring/bean/instantiating/conf1.xml");
        Bean1 iBean = applicationContext.getBean("bean2", Bean1.class);
        iBean.show();
        applicationContext.close();
    }
}
