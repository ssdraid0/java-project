package spring;

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
 */
public class BeanScope
{

}
