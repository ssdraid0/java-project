package spring;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.xml.DefaultBeanDefinitionDocumentReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.SimpleAliasRegistry;

import spring.bean.alias.IBean;

/**
 * ⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽<br>
 * 1.别名（alias）是如何从xml解析出来的？<br>
 * ⑴解析alias标签：{@link DefaultBeanDefinitionDocumentReader#processAliasRegistration()}。<br>
 * ⑵解析bean标签中的name：{@link DefaultBeanDefinitionDocumentReader#processBeanDefinition()}，<br>
 * {@link BeanDefinitionReaderUtils#registerBeanDefinition()}。<br>
 * ⑶存储：{@link SimpleAliasRegistry#registerAlias(String, String)}。<br>
 * <br>
 * 2.存储别名（alias）的数据结构是什么？<br>
 * {@link ConcurrentHashMap}，Key是{@link String}，Value是{@link String}。<br>
 * 位于{@link SimpleAliasRegistry#aliasMap}。<br>
 * <br>
 * 2.别名（alias）是在什么时候转换为原名的？<br>
 * {@link AbstractBeanFactory#doGetBean()} <br>
 * 转换别名：{@link AbstractBeanFactory#transformedBeanName(String)}。 <br>
 * <br>
 * 3.别名（alias）是如何转换为原名的？<br>
 * 有个{@link ConcurrentHashMap}专门存储别名和原名的映射，下面举个例子说明是如何转换的。<br>
 * 假设配置文件中配置了下面这样的别名。 <br>
 * {@code <alias name="bean1" alias="bean2" />} <br>
 * {@code <alias name="bean1" alias="bean3" />} <br>
 * {@code <alias name="bean2" alias="bean4" />} <br>
 * 那么{@link ConcurrentHashMap}里面存储的内容就是bean2-bean1，bean3-bean1，bean4-bean2。 现在要获取bean4的原名，那么就去
 * {@link ConcurrentHashMap}找键为bean4的值，发现是bean2。
 * 然后去找键为bean2的值，发现是bean1，然后去找键为bean1的值，发现没有，是null，说明找到了原名，就是bean1。
 */
public class BeanAlais
{
    public static void main(String[] args)
    {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "spring/bean/alias/alias.xml");
        IBean iBean1 = applicationContext.getBean("bean3", IBean.class);
        IBean iBean2 = applicationContext.getBean("bean4", IBean.class);
        IBean iBean5 = applicationContext.getBean("bean6", IBean.class);
        iBean1.show();
        iBean2.show();
        iBean5.show();
        applicationContext.close();
    }
}
