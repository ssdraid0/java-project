package spring.bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Bean2 implements IBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware, BeanPostProcessor, InitializingBean, DisposableBean
{
    private int i = 0;
    private Bean bean;

    public int getI()
    {
        return i;
    }

    public void setI(int i)
    {
        this.i = i;
    }

    public Bean getBean()
    {
        return bean;
    }

    public void setBean(Bean bean)
    {
        this.bean = bean;
    }

    @Override
    public void setBeanName(String name)
    {
        System.out.println(Thread.currentThread().getStackTrace()[1].getClassName()+":"+Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException
    {
        System.out.println(Thread.currentThread().getStackTrace()[1].getClassName()+":"+Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
    {
        System.out.println(Thread.currentThread().getStackTrace()[1].getClassName()+":"+Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException
    {
        System.out.println(Thread.currentThread().getStackTrace()[1].getClassName()+":"+Thread.currentThread().getStackTrace()[1].getMethodName());
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception
    {
        System.out.println(Thread.currentThread().getStackTrace()[1].getClassName()+":"+Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Override
    public void show()
    {
        System.out.println("Bean");
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException
    {
        System.out.println(Thread.currentThread().getStackTrace()[1].getClassName()+":"+Thread.currentThread().getStackTrace()[1].getMethodName());
        return null;
    }

    @Override
    public void destroy() throws Exception
    {
        System.out.println(Thread.currentThread().getStackTrace()[1].getClassName()+":"+Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
