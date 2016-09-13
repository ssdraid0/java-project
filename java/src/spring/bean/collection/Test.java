package spring.bean.collection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 1.Spring能注入哪些集合？<br>
 *  <list>,<set>,<map>,<props>(键和值都为String)<br>
 */
public class Test
{
    public static void main(String[] args)
    {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/bean/collection/collection.xml");
        IBean iBean = applicationContext.getBean("bean", IBean.class);
        iBean.show();
        applicationContext.close();
    }
}
