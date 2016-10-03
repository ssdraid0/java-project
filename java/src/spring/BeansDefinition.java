package spring;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.BeanInstantiationException;
import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * 1.解析xml后bean的信息存储在哪里？<br>
 * {@link ConcurrentHashMap}，Key是{@link String}，Value是{@link RootBeanDefinition}。<br>
 * 代码在{@link AbstractBeanFactory#mergedBeanDefinitions}。<br>
 * <br>
 * 2.bean的id存储在哪里？<br>
 * {@link DefaultListableBeanFactory#beanDefinitionNames}。<br>
 * <br>
 * 3.如果bean是一个接口会发生什么？<br>
 * 会抛出{@link BeanInstantiationException}异常。<br>
 */
public class BeansDefinition
{

}
