package spring;

import java.util.Map;

import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽<br>
 * 1.根据name获取bean的过程。<br>
 * {@link ClassPathXmlApplicationContext#getBean(String)}。<br>
 * {@link AbstractBeanFactory#doGetBean()}。 <br>
 * ⑴.去别名{@link Map}获取对应的name。<br>
 * {@link AbstractBeanFactory#transformedBeanName(String)} 。<br>
 * ⑵.根据name去单例{@link Map}获取对象，如果找到了，那就说明这个Bean就是单例，直接返回，否则转c。<br>
 * ⑶.没找到，根据name获取bean定义，然后判断bean的作用域，如果是单例，转⑷，否则转⑸。<br>
 * ⑷.。<br>
 * ⑸.。<br>
 * <br>
 */
public class BeanGet
{

}
