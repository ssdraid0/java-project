package spring.ioc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.AbstractRefreshableApplicationContext;
import org.springframework.context.support.AbstractRefreshableConfigApplicationContext;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * 4.IoC源码分析。 <br>
 * a.{@link ClassPathXmlApplicationContext}}的继承层次：{@link AbstractXmlApplicationContext}->
 * {@link AbstractRefreshableConfigApplicationContext}->{@link AbstractRefreshableApplicationContext}->
 * {@link AbstractApplicationContext}，然后{@link AbstractApplicationContext}实现了
 * {@link ConfigurableApplicationContext}接口，{@link ConfigurableApplicationContext}接口继承了
 * {@link ApplicationContext}接口， {@link ApplicationContext}接口继承了{@link ListableBeanFactory}和
 * {@link HierarchicalBeanFactory}接口，{@link ListableBeanFactory}和{@link HierarchicalBeanFactory}接口都继承了
 * {@link BeanFactory}接口。<br>
 * <br>
 * b.{@link ClassPathXmlApplicationContext#ClassPathXmlApplicationContext(String)}构造器，实际上是调用
 * {@link ClassPathXmlApplicationContext#ClassPathXmlApplicationContext(String[], boolean, ApplicationContext)}
 * 构造器，第一个参数是xml文件位置，第二个是true，第三个是null。下面分析源码。
 * 
 * <pre>
 * public ClassPathXmlApplicationContext(String[] configLocations, boolean refresh, ApplicationContext parent)
 *         throws BeansException
 * {
 *     super(parent); // 设置资源加载器
 *     setConfigLocations(configLocations); // configLocations是一个{@link String}数组，用于存储多个配置文件位置。
 *     if (refresh)
 *     {
 *         refresh(); // 载入Bean资源
 *     }
 * }
 * </pre>
 * 
 * {@code  setConfigLocations(configLocations);}实际调用的是
 * {@link AbstractRefreshableConfigApplicationContext#setConfigLocations(String...)}方法。 <br>
 * 
 * <pre>
 * public void setConfigLocations(String... locations)
 * {
 *     if (locations != null)
 *     {
 *         Assert.noNullElements(locations, "Config locations must not be null");
 *         this.configLocations = new String[locations.length];
 *         for (int i = 0; i < locations.length; i++)
 *         {
 *             this.configLocations[i] = resolvePath(locations[i]).trim();
 *         }
 *     } else
 *     {
 *         this.configLocations = null;
 *     }
 * }
 * </pre>
 * 
 * 因为fresh为true，{@code  refresh();}会被调用。{@code  refresh();}实际调用的是 {@link AbstractApplicationContext#refresh()}
 * 方法。 <br>
 * 
 * <pre>
 * public void refresh() throws BeansException, IllegalStateException
 * {
 *     synchronized (this.startupShutdownMonitor)
 *     {
 *         // Prepare this context for refreshing.
 *         prepareRefresh();
 * 
 *         // Tell the subclass to refresh the internal bean factory.
 *         ConfigurableListableBeanFactory beanFactory = obtainFreshBeanFactory();
 * 
 *         // Prepare the bean factory for use in this context.
 *         prepareBeanFactory(beanFactory);
 * 
 *         try
 *         {
 *             // Allows post-processing of the bean factory in context subclasses.
 *             postProcessBeanFactory(beanFactory);
 * 
 *             // Invoke factory processors registered as beans in the context.
 *             invokeBeanFactoryPostProcessors(beanFactory);
 * 
 *             // Register bean processors that intercept bean creation.
 *             registerBeanPostProcessors(beanFactory);
 * 
 *             // Initialize message source for this context.
 *             initMessageSource();
 * 
 *             // Initialize event multicaster for this context.
 *             initApplicationEventMulticaster();
 * 
 *             // Initialize other special beans in specific context subclasses.
 *             onRefresh();
 * 
 *             // Check for listener beans and register them.
 *             registerListeners();
 * 
 *             // Instantiate all remaining (non-lazy-init) singletons.
 *             finishBeanFactoryInitialization(beanFactory);
 * 
 *             // Last step: publish corresponding event.
 *             finishRefresh();
 *         }
 * 
 *         catch (BeansException ex)
 *         {
 *             if (logger.isWarnEnabled())
 *             {
 *                 logger.warn("Exception encountered during context initialization - " + "cancelling refresh attempt: "
 *                         + ex);
 *             }
 * 
 *             // Destroy already created singletons to avoid dangling resources.
 *             destroyBeans();
 * 
 *             // Reset 'active' flag.
 *             cancelRefresh(ex);
 * 
 *             // Propagate exception to caller.
 *             throw ex;
 *         }
 * 
 *         finally
 *         {
 *             // Reset common introspection caches in Spring's core, since we
 *             // might not ever need metadata for singleton beans anymore...
 *             resetCommonCaches();
 *         }
 *     }
 * }
 * </pre>
 * 
 * {@link AbstractApplicationContext#obtainFreshBeanFactory()}。
 * 
 * <pre>
 * protected ConfigurableListableBeanFactory obtainFreshBeanFactory()
 * {
 *     refreshBeanFactory(); // 实际调用的是{@link AbstractRefreshableApplicationContext#refreshBeanFactory()}。
 *     ConfigurableListableBeanFactory beanFactory = getBeanFactory();
 *     if (logger.isDebugEnabled())
 *     {
 *         logger.debug("Bean factory for " + getDisplayName() + ": " + beanFactory);
 *     }
 *     return beanFactory;
 * }
 * </pre>
 * 
 * {@link AbstractRefreshableApplicationContext#refreshBeanFactory()}
 * 
 * <pre>
 * protected final void refreshBeanFactory() throws BeansException
 * {
 *     if (hasBeanFactory()) // 如果已经有BeanFactory
 *     {
 *         destroyBeans(); // 销毁容器中的bean
 *         closeBeanFactory(); // 关闭BeanFactory
 *     }
 *     try
 *     {
 *         DefaultListableBeanFactory beanFactory = createBeanFactory();
 *         beanFactory.setSerializationId(getId());
 *         customizeBeanFactory(beanFactory);
 *         loadBeanDefinitions(beanFactory);
 *         synchronized (this.beanFactoryMonitor)
 *         {
 *             this.beanFactory = beanFactory;
 *         }
 *     } catch (IOException ex)
 *     {
 *         throw new ApplicationContextException("I/O error parsing bean definition source for " + getDisplayName(),
 *                 ex);
 *     }
 * }
 * 
 * </pre>
 * 
 * {@link AbstractXmlApplicationContext#loadBeanDefinitions(DefaultListableBeanFactory)}
 * 
 * <pre>
 * protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws BeansException, IOException
 * {
 *     // Create a new XmlBeanDefinitionReader for the given BeanFactory.
 *     XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
 * 
 *     // Configure the bean definition reader with this context's
 *     // resource loading environment.
 *     beanDefinitionReader.setEnvironment(this.getEnvironment());
 *     beanDefinitionReader.setResourceLoader(this);
 *     beanDefinitionReader.setEntityResolver(new ResourceEntityResolver(this));
 * 
 *     // Allow a subclass to provide custom initialization of the reader,
 *     // then proceed with actually loading the bean definitions.
 *     initBeanDefinitionReader(beanDefinitionReader);
 *     loadBeanDefinitions(beanDefinitionReader);
 * }
 * </pre>
 * 
 * {@link AbstractXmlApplicationContext#loadBeanDefinitions(XmlBeanDefinitionReader)}
 * 
 * <pre>
 * protected void loadBeanDefinitions(XmlBeanDefinitionReader reader) throws BeansException, IOException
 * {
 *     Resource[] configResources = getConfigResources();
 *     if (configResources != null)
 *     {
 *         reader.loadBeanDefinitions(configResources);
 *     }
 *     String[] configLocations = getConfigLocations();
 *     if (configLocations != null)
 *     {
 *         reader.loadBeanDefinitions(configLocations);
 *     }
 * }
 * </pre>
 * 
 * {@link AbstractRefreshableConfigApplicationContext#getConfigLocations()}
 * 
 * <pre>
 * protected String[] getConfigLocations()
 * {
 *     return (this.configLocations != null ? this.configLocations : getDefaultConfigLocations());
 * }
 * </pre>
 * 
 * {@link AbstractRefreshableConfigApplicationContext#getDefaultConfigLocations}
 * 
 * <pre>
 * protected String[] getDefaultConfigLocations()
 * {
 *     return null;
 * }
 * </pre>
 * 
 * {@link AbstractBeanDefinitionReader#loadBeanDefinitions(String...)}
 * 
 * <pre>
 * public int loadBeanDefinitions(String... locations) throws BeanDefinitionStoreException
 * {
 *     Assert.notNull(locations, "Location array must not be null");
 *     int counter = 0;
 *     for (String location : locations)
 *     {
 *         counter += loadBeanDefinitions(location);
 *     }
 *     return counter;
 * }
 * </pre>
 * 
 * {@link AbstractXmlApplicationContext} <br>
 * .因为{@link AbstractApplicationContext}实现了{@link BeanFactory}接口，所以
 * {@link ClassPathXmlApplicationContext#getBean(String)}方法实际上是
 * {@link AbstractApplicationContext#getBean(String)}。<br>
 */
public class IocTest
{
    public static void main(String[] args)
    {
        // ClassPath.test5();
        // ClassPath.test1();
        Bean.test3();
        // WebPath.test1();
    }

    public static class ClassPath
    {
        public static void test1()
        {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/ioc/ioc.xml");
            HelloApi helloApi = context.getBean("hello", HelloApi.class);
            helloApi.sayHello();
            context.close();
        }

        public static void test2()
        {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring\\ioc\\ioc.xml");
            HelloApi helloApi = context.getBean("hello", HelloApi.class);
            helloApi.sayHello();
            context.close();
        }

        public static void test3()
        {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                    "classpath:spring\\ioc\\ioc.xml");
            HelloApi helloApi = context.getBean("hello", HelloApi.class);
            helloApi.sayHello();
            context.close();
        }

        public static void test4()
        {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                    "file:D:/Documents/Software Development/Eclipse JavaEE Mars2/java/src/spring/ioc/ioc.xml");
            HelloApi helloApi = context.getBean("hello", HelloApi.class);
            helloApi.sayHello();
            context.close();
        }

        public static void test5()
        {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                    "classpath*:spring/ioc/ioc.xml");
            HelloApi helloApi = context.getBean("hello", HelloApi.class);
            helloApi.sayHello();
            context.close();
        }
    }

    public static class FilePath
    {
        public static void test1()
        {
            FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext(
                    "D:/Documents/Software Development/Eclipse JavaEE Mars2/java/src/spring/ioc/ioc.xml");
            HelloApi helloApi = context.getBean("hello", HelloApi.class);
            helloApi.sayHello();
            context.close();
        }
    }

    public static class WebPath
    {
        public static void test1()
        {
            XmlWebApplicationContext context = new XmlWebApplicationContext();
            HelloApi helloApi = context.getBean("hello", HelloApi.class);
            helloApi.sayHello();
            context.close();
        }
    }

    public static class Alais
    {
        public static void test1()
        {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/ioc/ioc2.xml");
            HelloApi helloApi = context.getBean("hello3", HelloApi.class);
            helloApi.sayHello();
            // helloApi = context.getBean("hello", HelloApi.class);
            // helloApi.sayHello();
            context.close();
        }
    }

    public static class Import
    {

    }

    public static class Bean
    {
        public static void test1()
        {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/ioc/ioc2.xml");
            HelloApi helloApi = context.getBean("hello2", HelloApi.class);
            System.out.println(helloApi.hashCode());
            HelloApi helloApi2 = context.getBean("hello2", HelloApi.class);
            System.out.println(helloApi2.hashCode());
            context.close();
        }
        
        public static void test2()
        {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/ioc/ioc2.xml");
            HelloApi helloApi = context.getBean("hello4", HelloApi.class);
            System.out.println(helloApi.hashCode());
            context.close();
        }
        
        public static void test3()
        {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/ioc/ioc3.xml");
            A a = context.getBean("a", A.class);
            System.out.println(a.hashCode());
            context.close();
        }
    }

    public static void test1()
    {
        // 1、读取配置文件实例化一个IoC容器
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/ioc/ioc.xml");
        // 2、从容器中获取Bean，注意此处完全“面向接口编程，而不是面向实现”
        HelloApi helloApi = context.getBean("hello", HelloApi.class);
        // 3、执行业务逻辑
        helloApi.sayHello();
        context.close();
    }

    public static void test2()
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("null");
        HelloApi helloApi = context.getBean("hello", HelloApi.class);
        helloApi.sayHello();
        context.close();
    }
}
