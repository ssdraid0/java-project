package spring.aop.proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class BeanFactoryUtils implements BeanFactoryAware
{

    private static BeanFactory beanFactory;

    public static BeanFactoryUtils getInstance()
    {
        return (BeanFactoryUtils) beanFactory.getBean("factoryUtil");
    }

    public void setBeanFactory(BeanFactory bf) throws BeansException
    {
        beanFactory = bf;
    }

    public BeanFactory getBeanFactory()
    {
        return beanFactory;
    }

}
