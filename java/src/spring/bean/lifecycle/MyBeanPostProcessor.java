package spring.bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor
{

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException
    {
        if (bean instanceof Bean)
        {
            ((Bean) bean).setI(100);
        }
        System.out.println(Thread.currentThread().getStackTrace()[1].getClassName() + ":"
                + Thread.currentThread().getStackTrace()[1].getMethodName() + ":" + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException
    {
        if (bean instanceof Bean)
        {
            ((Bean) bean).setI(200);
        }
        System.out.println(Thread.currentThread().getStackTrace()[1].getClassName() + ":"
                + Thread.currentThread().getStackTrace()[1].getMethodName() + ":" + beanName);
        return bean;
    }

}
