package spring.bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Bean
        implements IBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean
{
    private int i = 0;

    public Bean()
    {
        System.out.println(Thread.currentThread().getStackTrace()[1].getClassName() + ":"
                + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public int getI()
    {
        return i;
    }

    public void setI(int i)
    {
        this.i = i;
    }

    @Override
    public void setBeanName(String name)
    {
        System.out.println(Thread.currentThread().getStackTrace()[1].getClassName() + ":"
                + Thread.currentThread().getStackTrace()[1].getMethodName() + ":" + name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException
    {
        System.out.println(Thread.currentThread().getStackTrace()[1].getClassName() + ":"
                + Thread.currentThread().getStackTrace()[1].getMethodName() + ":" + beanFactory.toString());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
    {
        System.out.println(Thread.currentThread().getStackTrace()[1].getClassName() + ":"
                + Thread.currentThread().getStackTrace()[1].getMethodName() + ":"
                + applicationContext.getDisplayName());
    }

    @Override
    public void afterPropertiesSet() throws Exception
    {
        System.out.println(Thread.currentThread().getStackTrace()[1].getClassName() + ":"
                + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Override
    public void show()
    {
        System.out.println("Bean:" + i);
    }

    @Override
    public void destroy() throws Exception
    {
        System.out.println(Thread.currentThread().getStackTrace()[1].getClassName() + ":"
                + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
