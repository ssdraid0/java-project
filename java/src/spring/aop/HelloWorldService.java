package spring.aop;

public class HelloWorldService implements IHelloWorldService
{

    @Override
    public void sayHello()
    {
        System.out.println("Hello World!");
    }

    public boolean sayHelloReturning()
    {
        System.out.println("Hello World!");
        return true;
    }
}
