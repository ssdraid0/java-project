package spring.aop.advice;

public class Service
{
    public void sayHello()
    {
        System.out.println("Hello World!");
    }

    public String say(String s)
    {
        System.out.println(s);
        return s;
    }
}
