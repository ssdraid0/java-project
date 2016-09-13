package spring.bean.scope;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest
{

    public static void main(String[] args)
    {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "spring/bean/scope/scope.xml");
        IBean iBean1 = applicationContext.getBean("beanSingleton", IBean.class);
        IBean iBean2 = applicationContext.getBean("beanSingleton", IBean.class);
        if (iBean1 == iBean2)
        {
            System.out.println(true);
        } else
        {
            System.out.println(false);
        }
        IBean iBean3 = applicationContext.getBean("beanPrototype", IBean.class);
        IBean iBean4 = applicationContext.getBean("beanPrototype", IBean.class);
        if (iBean3 == iBean4)
        {
            System.out.println(true);
        } else
        {
            System.out.println(false);

        }
        applicationContext.close();
    }

}
