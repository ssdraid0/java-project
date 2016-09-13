package spring.bean.lifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test
{
    public static void main(String[] args)
    {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "spring/bean/lifecycle/lifecycle.xml");
        IBean iBean = applicationContext.getBean("bean1", IBean.class);
        iBean.show();
        applicationContext.close();
    }
}
