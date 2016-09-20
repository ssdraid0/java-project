package spring;

import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.aspectj.AspectJAfterAdvice;
import org.springframework.aop.aspectj.AspectJAfterThrowingAdvice;
import org.springframework.aop.aspectj.AspectJAroundAdvice;
import org.springframework.aop.aspectj.AspectJMethodBeforeAdvice;
import org.springframework.aop.framework.DefaultAopProxyFactory;
import org.springframework.aop.framework.ReflectiveMethodInvocation;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.support.SimpleInstantiationStrategy;
import org.springframework.beans.factory.xml.BeanDefinitionParserDelegate;
import org.springframework.beans.factory.xml.DefaultBeanDefinitionDocumentReader;
import org.springframework.beans.factory.xml.DefaultDocumentLoader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.SimpleAliasRegistry;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.w3c.dom.Element;

/**
 * 1.Spring有哪些功能？<br>
 * 控制反转（IoC），面向切面编程（AOP），事务管理。<br>
 * <br>
 * 2.Spring常用模块有哪些？<br>
 * core，beans，context，aop，jdbc，transaction，web。<br>
 * <br>
 * 3.
 */
public class SpringQuestion
{
    public static void main(String[] args)
    {

    }
}

/**
 * 1.{@link ClassPathXmlApplicationContext}和{@link FileSystemXmlApplicationContext}是怎么解析配置文件路径的？。 <br>
 * <br>
 * 相关代码在：{@link PathMatchingResourcePatternResolver#getResources(String)}和
 * {@link DefaultResourceLoader#getResource(String)}。 <br>
 * <br>
 * a.判断是否以"classpath*:"开头，不是转b。暂时不用考虑是的情况。<br>
 * b.判断是否包含":"，是就去掉，然后判断是否包含"*"或"?"，不是转c。暂时不用考虑是的情况。 <br>
 * c.判断是否以"/"开头，不是转d，是转f <br>
 * d.判断是否以"classpath:"开头，不是转e，是就去掉"classpath:"然后转h。<br>
 * e.判断是否是URL，不是转f，是转i。<br>
 * f.如果是{@link FileSystemXmlApplicationContext}，转g，如果是 {@link ClassPathXmlApplicationContext}，转h。 <br>
 * g.调用{@link FileSystemXmlApplicationContext#getResourceByPath(String)}}，返回一个{@link FileSystemResource}。<br>
 * h.调用{@link DefaultResourceLoader#getResourceByPath(String)}}，返回一个
 * {@link DefaultResourceLoader.ClassPathContextResource}。<br>
 * i.调用{@link UrlResource#UrlResource(URL)}，返回一个{@link UrlResource}。<br>
 * <br>
 */
class ContextPathQuestion
{

}

/**
 * 1.IoC是什么，有什么作用？ <br>
 * 控制反转（Inversion of Control），让IoC容器通过反射来创建对象，初始化对象，配置对象。<br>
 * <br>
 * 2.IoC容器是什么，具体实现有哪些？ <br>
 * ApplicationContext 接口，具体实现有{@link FileSystemXmlApplicationContext}，{@link ClassPathXmlApplicationContext}，
 * {@link XmlWebApplicationContext}。 <br>
 * <br>
 * 3.有哪些不同类型的DI（依赖注入）方式？ <br>
 * 构造器注入和Setter注入。 <br>
 * <br>
 * 4.解析XML文件是用的什么方式？<br>
 * {@link org.xml.sax.InputSource}。<br>
 */
class ContextWhatQuestion
{

}

/**
 * 2.如何解析配置文件？。 <br>
 * {@link DefaultDocumentLoader#createDocumentBuilderFactory(int, boolean)}<br>
 * {@link DefaultBeanDefinitionDocumentReader#parseDefaultElement(Element, BeanDefinitionParserDelegate)}<br>
 * <br>
 * 3.{@link ClassPathXmlApplicationContext#getBean(String, Class)}过程。<br>
 * <br>
 * {@link AbstractBeanFactory#doGetBean(String, Class, Object[], boolean)} <br>
 * <br>
 * a.将alias转换为id，
 */
class ContextHowQuestion
{

}

/**
 * 1.解析xml时bean后的信息存储在哪里？<br>
 * {@link ConcurrentHashMap}，Key是{@link String}，Value是{@link RootBeanDefinition}。<br>
 * 代码在{@link AbstractBeanFactory#mergedBeanDefinitions}。<br>
 * <br>
 */
class BeansDefinitionQuestion
{

}

/**
 * 1.存储别名（alias）的数据结构是什么？<br>
 * {@link ConcurrentHashMap}，Key是{@link String}，Value是{@link String}。<br>
 * 位于{@link SimpleAliasRegistry#aliasMap}。<br>
 * <br>
 * 2.别名（alias）是如何转换为原名的？<br>
 * 代码在 {@link AbstractBeanFactory#transformedBeanName(String)} 。<br>
 * 有个{@link ConcurrentHashMap}专门存储别名和原名的映射，下面举个例子说明是如何转换的。<br>
 * 假设配置文件中配置了下面这样的别名。 <br>
 * <code>
 *<alias name="bean1" alias="bean2" />
 *<alias name="bean1" alias="bean3" />
* <alias name="bean2" alias="bean4" />
 *</code> <br>
 * 那么{@link ConcurrentHashMap}里面存储的内容就是bean2-bean1，bean3-bean1，bean4-bean2。 现在要获取bean4的原名，那么就去
 * {@link ConcurrentHashMap}找键为bean4的值，发现是bean2。
 * 然后去找键为bean2的值，发现是bean1，然后去找键为bean1的值，发现没有，是null，说明找到了原名，就是bean1。
 */
class BeansAlaisQuestion
{

}

/**
 * 1.Bean的的作用域有哪几种，默认的是哪种？<br>
 * 单例（singleton），原型（prototype），request，session，global-session，默认的是单例。<br>
 * <br>
 * 2.一个bean的定义如下，如何设置作用域为singleton？<br>
 * <bean id="beanSingleton" class="spring.Bean"><br>
 * <bean id="beanSingleton" class="spring.Bean" scope="singleton"><br>
 * <br>
 * 3.作用域为singleton的bean是否线程安全？<br>
 * 不。<br>
 * <br>
 * 4.如何让一个作用域为单例的bean在第一次获取bean时初始化？<br>
 * 在xml文件设置属性lazy-init="true" 。<br>
 * <br>
 * 5.缓存单例Bean的数据结构是什么？<br>
 * {@link ConcurrentHashMap}，Key是{@link String}，Value是{@link Object}。<br>
 * 位于{@link DefaultSingletonBeanRegistry#singletonObjects}。<br>
 * <br>
 */
class BeansScopeQuestion
{

}

/**
 * 1. Bean的生命周期？<br>
 * setBeanName->setBeanFactory->setApplicationContext->postProcessBeforeInitialization->afterPropertiesSet->
 * postProcessAfterInitialization-> destroy。 <br>
 * <br>
 * 代码：{@link BeanNameAware#setBeanName(String)}->{@link BeanFactoryAware#setBeanFactory(BeanFactory)}->
 * {@link ApplicationContextAware#setApplicationContext(ApplicationContext)}->
 * {@link BeanPostProcessor#postProcessBeforeInitialization(Object, String)}->
 * {@link BeanPostProcessor#postProcessAfterInitialization(Object, String)}->
 * {@link InitializingBean#afterPropertiesSet()}->{@link DisposableBean#destroy()}。<br>
 * <br>
 * 2.bean的生命周期是如何实现的？<br>
 * 代码：<br>
 * a. {@link AbstractAutowireCapableBeanFactory#invokeAwareMethods()}：setBeanName和setBeanFactory。<br>
 * b. {@link ApplicationContextAwareProcessor}：setApplicationContext。<br>
 * c. {@link AbstractAutowireCapableBeanFactory#applyBeanPostProcessorsBeforeInitialization(Object, String)}
 * }：postProcessBeforeInitialization。<br>
 * d. {@link AbstractAutowireCapableBeanFactory#invokeInitMethods} ：afterPropertiesSet 。<br>
 * e.{@link AbstractAutowireCapableBeanFactory#applyBeanPostProcessorsAfterInitialization(Object, String)}
 * ：postProcessAfterInitialization <br>
 */
class BeansLifeCycleQuestion
{

}

/**
 * 1.IoC容器如何检测循环依赖？<br>
 * 用一个{@link HashSet}存储正在创建的bean的名字，创建一个bean之前检测{@link HashSet}。<br>
 * 代码：<br>
 * {@link AbstractBeanFactory#prototypesCurrentlyInCreation}：存储正在创建的bean。<br>
 * {@link AbstractBeanFactory#isPrototypeCurrentlyInCreation(String)}：判断指定name的原型bean是否正在创建中。<br>
 * {@link AbstractBeanFactory#beforePrototypeCreation(String)}：将bean的名字添加到{@link HashSet}。<br>
 * <br>
 * 2.IoC容器如何装配bean？<br>
 * <br>
 */
class BeansCirculeQuestion
{

}

/**
 * 1.IoC容器如何根据name获取Bean？<br>
 * 代码在：{@link AbstractBeanFactory#doGetBean()}。 <br>
 * a.如果name是别名（alias），去别名{@link Map}获取对应的name。<br>
 * 代码在 {@link AbstractBeanFactory#transformedBeanName(String)} 。<br>
 * b.根据name去单例{@link Map}获取对象，如果找到了，那就说明这个Bean就是单例，直接返回，否则转c。<br>
 * c.没找到，根据name去bean定义{@link Map}获取bean定义，然后判断bean的作用域，如果是单例，转d，否则转f。<br>
 * d.通过反射new一个bean，把bean缓存。<br>
 * 代码在 {@link SimpleInstantiationStrategy#instantiate(RootBeanDefinition, String, BeanFactory)} 。<br>
 * f.通过反射new一个bean。<br>
 * <br>
 */
class BeansGetQuestion
{

}

/**
 * 1.为什么要使用AOP？<br>
 * 给类动态添加功能。<br>
 * <br>
 * 2.AOP的动态代理两种方式是什么？使用哪种的依据是什么？<br>
 * Jdk代理和Cglib代理。<br>
 * 如果目标类实现了接口，使用Jdk代理，否则使用Cglib代理。<br>
 * 代码：{@link DefaultAopProxyFactory#createAopProxy()}：根据不同情况创建Jdk代理或Cglib代理。<br>
 * {@link JdkDynamicAopProxy}：Jdk代理类。<br>
 * {@link ObjenesisCglibAopProxy}：Cglib代理类。<br>
 */
class AopQuestion
{
    static class ProxyAop
    {
        public static void test()
        {

        }
    }
}

/**
 * 1.Jdk代理的原理？<br>
 * {@link Method#invoke(Object, Object...)}：。<br>
 * 代码： <br>
 * {@link ReflectiveMethodInvocation#proceed()}：。<br>
 * <br>
 * {@link AspectJMethodBeforeAdvice#before()}：。<br>
 * {@link AspectJAfterAdvice#invoke(MethodInvocation)}：。<br>
 * {@link AspectJAfterThrowingAdvice#invoke(MethodInvocation)}：。<br>
 * {@link AspectJAroundAdvice#invoke(MethodInvocation)}：。<br>
 * <br>
 */
class JdkAopQuestion
{
}

class CglibAopQuestion
{
}
