package spring.bean.alias;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AliasTest
{

    public static void main(String[] args)
    {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "spring/bean/alias/alias.xml");
        IBean iBean1 = applicationContext.getBean("bean3", IBean.class);
        IBean iBean2 = applicationContext.getBean("bean4", IBean.class);
        iBean1.show();
        iBean2.show();
        applicationContext.close();
    }

}
