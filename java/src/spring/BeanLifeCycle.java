package spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * ⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽</br>
 * 1. Bean的生命周期是怎么样的？</br>
 * setBeanName->setBeanFactory->setApplicationContext->postProcessBeforeInitialization->afterPropertiesSet->
 * postProcessAfterInitialization-> destroy。 </br>
 * </br>
 * {@link BeanNameAware#setBeanName(String)}->{@link BeanFactoryAware#setBeanFactory(BeanFactory)}->
 * {@link ApplicationContextAware#setApplicationContext(ApplicationContext)}->
 * {@link BeanPostProcessor#postProcessBeforeInitialization(Object, String)}->
 * {@link BeanPostProcessor#postProcessAfterInitialization(Object, String)}->
 * {@link InitializingBean#afterPropertiesSet()}->{@link DisposableBean#destroy()}。</br>
 * <br>
 * 2.bean的生命周期是如何实现的？</br>
 * ⑴.setBeanName和setBeanFactory：</br>
 * {@link AbstractAutowireCapableBeanFactory#initializeBean()}，</br>
 * {@link AbstractAutowireCapableBeanFactory#invokeAwareMethods()}。</br>
 * ⑵.setApplicationContext：</br>
 * {@link AbstractAutowireCapableBeanFactory#initializeBean()}，</br>
 * {@link ApplicationContextAwareProcessor#invokeAwareInterfaces()}。</br>
 * ⑶.postProcessBeforeInitialization：</br>
 * {@link AbstractAutowireCapableBeanFactory#initializeBean()}，</br>
 * {@link AbstractAutowireCapableBeanFactory#applyBeanPostProcessorsBeforeInitialization()} </br>
 * ⑷.afterPropertiesSet ：</br>
 * {@link AbstractAutowireCapableBeanFactory#initializeBean()}，</br>
 * {@link AbstractAutowireCapableBeanFactory#invokeInitMethods()} 。</br>
 * ⑸.postProcessAfterInitialization：</br>
 * {@link AbstractAutowireCapableBeanFactory#initializeBean()}，</br>
 * {@link AbstractAutowireCapableBeanFactory#applyBeanPostProcessorsAfterInitialization()}。</br>
 * ⑹.destroy：</br>
 * {@link AbstractApplicationContext#destroyBeans()}。</br>
 * {@link DisposableBeanAdapter#destroy()}。</br>
 * </br>
 */
public class BeanLifeCycle
{

}
