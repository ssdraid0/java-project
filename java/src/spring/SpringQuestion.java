package spring;

import java.net.URL;

import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.beans.factory.xml.BeanDefinitionParserDelegate;
import org.springframework.beans.factory.xml.DefaultBeanDefinitionDocumentReader;
import org.springframework.beans.factory.xml.DefaultDocumentLoader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.w3c.dom.Element;

/**
 * 1.Spring有哪些功能？</br>
 * 控制反转（IoC），面向切面编程（AOP），事务管理。</br>
 * </br>
 * 2.Spring常用模块有哪些？</br>
 * core，beans，context，aop，jdbc，transaction，web。</br>
 * </br>
 * 3.如果让你实现Spring，你会怎么做？</br>
 * </br>
 */
public class SpringQuestion
{
    public static void main(String[] args)
    {

    }
}

/**
 * 1.{@link ClassPathXmlApplicationContext}和{@link FileSystemXmlApplicationContext}是怎么解析配置文件路径的？。 </br>
 * </br>
 * 相关代码在：{@link PathMatchingResourcePatternResolver#getResources(String)}和
 * {@link DefaultResourceLoader#getResource(String)}。 </br>
 * </br>
 * a.判断是否以"classpath*:"开头，不是转b。暂时不用考虑是的情况。</br>
 * b.判断是否包含":"，是就去掉，然后判断是否包含"*"或"?"，不是转c。暂时不用考虑是的情况。 </br>
 * c.判断是否以"/"开头，不是转d，是转f。</br>
 * d.判断是否以"classpath:"开头，不是转e，是就去掉"classpath:"然后转h。</br>
 * e.判断是否是URL，不是转f，是转i。</br>
 * f.如果是{@link FileSystemXmlApplicationContext}，转g，如果是 {@link ClassPathXmlApplicationContext}，转h。 </br>
 * g.调用{@link FileSystemXmlApplicationContext#getResourceByPath(String)}}，返回一个{@link FileSystemResource}。</br>
 * h.调用{@link DefaultResourceLoader#getResourceByPath(String)}}，返回一个
 * {@link DefaultResourceLoader.ClassPathContextResource}。</br>
 * i.调用{@link UrlResource#UrlResource(URL)}，返回一个{@link UrlResource}。</br>
 * </br>
 */
class ContextPathQuestion
{

}

/**
 * 1.IoC是什么，有什么作用？ </br>
 * 控制反转（Inversion of Control），让IoC容器通过反射来创建对象，初始化对象，配置对象。</br>
 * </br>
 * 2.IoC容器是什么，具体实现有哪些？ </br>
 * ApplicationContext 接口，具体实现有{@link FileSystemXmlApplicationContext}，{@link ClassPathXmlApplicationContext}，
 * {@link XmlWebApplicationContext}。 </br>
 * </br>
 * 3.有哪些不同类型的DI（依赖注入）方式？ </br>
 * 构造器注入和Setter注入。 </br>
 * </br>
 * 4.解析XML文件是用的什么方式？</br>
 * {@link org.xml.sax.InputSource}。</br>
 */
class ContextWhatQuestion
{

}

/**
 * 2.如何解析配置文件？。 </br>
 * {@link DefaultDocumentLoader#createDocumentBuilderFactory(int, boolean)}</br>
 * {@link DefaultBeanDefinitionDocumentReader#parseDefaultElement(Element, BeanDefinitionParserDelegate)}</br>
 * </br>
 * 3.{@link ClassPathXmlApplicationContext#getBean(String, Class)}过程。</br>
 * </br>
 * {@link AbstractBeanFactory#doGetBean(String, Class, Object[], boolean)} </br>
 * </br>
 * a.将alias转换为id，
 */
class ContextHowQuestion
{

}
