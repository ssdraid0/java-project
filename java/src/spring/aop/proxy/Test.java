package spring.aop.proxy;

public class Test
{

    public static void main(String[] args)
    {
        LoginService loginService = (LoginService) BeanFactoryUtils.getInstance().getBeanFactory()
                .getBean("loginServiceProxy");
    }

}
