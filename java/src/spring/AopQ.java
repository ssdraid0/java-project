package spring;

import java.lang.reflect.Method;

import org.springframework.aop.aspectj.AspectJAfterAdvice;
import org.springframework.aop.aspectj.AspectJAfterThrowingAdvice;
import org.springframework.aop.aspectj.AspectJAroundAdvice;
import org.springframework.aop.aspectj.AspectJMethodBeforeAdvice;
import org.springframework.aop.framework.DefaultAopProxyFactory;
import org.springframework.aop.framework.ReflectiveMethodInvocation;

/**
 * 1.为什么要使用AOP？用在哪些地方？</br>
 * 给类动态添加功能。</br>
 * 日志，事务。</br>
 * </br>
 * 2.AOP的动态代理两种方式是什么？使用哪种的依据是什么？</br>
 * Jdk代理和Cglib代理。</br>
 * 如果目标类实现了接口，使用Jdk代理，否则使用Cglib代理。</br>
 * 代码：{@link DefaultAopProxyFactory#createAopProxy()}：根据不同情况创建Jdk代理或Cglib代理。</br>
 * {@link JdkDynamicAopProxy}：Jdk代理类。</br>
 * {@link ObjenesisCglibAopProxy}：Cglib代理类。</br>
 */
public class AopQ
{

}

/**
 * 1.Jdk代理的原理？</br>
 * {@link Method#invoke(Object, Object...)}：。</br>
 * 代码： </br>
 * {@link ReflectiveMethodInvocation#proceed()}：。</br>
 * {@link AspectJMethodBeforeAdvice#before()}：。</br>
 * {@link AspectJAfterAdvice#invoke()}：。</br>
 * {@link AspectJAfterThrowingAdvice#invoke()}：。</br>
 * {@link AspectJAroundAdvice#invoke()}：。</br>
 * </br>
 */
class JdkAopQ
{}