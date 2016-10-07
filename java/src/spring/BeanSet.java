package spring;

import java.lang.reflect.Method;

import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.bean.set.Bean;

/**
 * ⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽<br>
 * 1.setter注入的过程？ <br>
 * ⑴.创建完成bean后：{@link AbstractAutowireCapableBeanFactory#populateBean()}。<br>
 * ⑵.{@link AbstractAutowireCapableBeanFactory#applyPropertyValues()}。<br>
 * ⑶.{@link BeanWrapperImpl#setPropertyValue(PropertyValue)}。<br>
 * ⑷.{@link BeanWrapperImpl.BeanPropertyHandler#setValue()}。<br>
 * ⑸.通过反射调用方法：{@link Method#invoke(Object, Object...)}。<br>
 */
public class BeanSet
{
    public static void main(String[] args)
    {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "spring/bean/set/conf.xml");
        Bean bean = applicationContext.getBean("bean1", Bean.class);
        bean.say();
        applicationContext.close();
    }
}
