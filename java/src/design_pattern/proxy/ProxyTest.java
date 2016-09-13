package design_pattern.proxy;

public class ProxyTest
{
    public static void main(String[] args)
    {
        Sourceable source = new Proxy();
        source.method();
    }
}
