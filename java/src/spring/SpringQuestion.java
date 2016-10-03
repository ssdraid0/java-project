package spring;

import java.lang.reflect.Method;
import java.net.URL;

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
import org.springframework.beans.factory.xml.BeanDefinitionParserDelegate;
import org.springframework.beans.factory.xml.DefaultBeanDefinitionDocumentReader;
import org.springframework.beans.factory.xml.DefaultDocumentLoader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
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
 * c.判断是否以"/"开头，不是转d，是转f。<br>
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
 * {@link AspectJMethodBeforeAdvice#before()}：。<br>
 * {@link AspectJAfterAdvice#invoke(MethodInvocation)}：。<br>
 * {@link AspectJAfterThrowingAdvice#invoke(MethodInvocation)}：。<br>
 * {@link AspectJAroundAdvice#invoke(MethodInvocation)}：。<br>
 * <br>
 */
class JdkAopQuestion
{}

class CglibAopQuestion
{}
