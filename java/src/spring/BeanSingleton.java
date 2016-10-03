package spring;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * ⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽<br>
 * 1.单例bean是在什么时候创建的？<br>
 * 创建Context的时候创建的。<br
 * 创建Context：{@link AbstractApplicationContext#refresh()}<br>
 * {@link AbstractApplicationContext#finishBeanFactoryInitialization()}<br>
 * 创建单例bean：{@link DefaultListableBeanFactory#preInstantiateSingletons()}<br>
 * <br>
 * 2.单例bean创建后缓存在哪里？<br>
 * {@link ConcurrentHashMap}，Key是{@link String}，Value是{@link Object}。<br>
 * 位于{@link DefaultSingletonBeanRegistry#singletonObjects}。<br>
 * <br>
 * 3.单例bean创建后是在什么时候添加进缓存的？ <br>
 * 创建bean：{@link DefaultSingletonBeanRegistry#getSingleton(String, ObjectFactory)}<br>
 * 添加到缓存：{@link DefaultSingletonBeanRegistry#addSingleton()}<br>
 * <br>
 * 4.如果想让单例bean在第一次使用时才初始化，如何配置？ <br>
 * 添加lazy-init="true"：{@code <bean id="xxx" class="xxx" lazy-init="true"/>} <br>
 * <br>
 * 5.Spring是在什么时候判断单例bean是否需要提前初始化？ <br>
 * {@link AbstractApplicationContext#finishBeanFactoryInitialization()}<br>
 * <br>
 */
public class BeanSingleton
{

}
