package spring.bean.instantiating;

public class Bean1
{
    private static Bean1 bean1 = new Bean1();

    public static Bean1 newInstance()
    {
        return bean1;
    }

    private int i = 0;

    public Bean1()
    {}

    public Bean1(int i)
    {
        this.i = 1;
    }

    public void show()
    {
        System.out.println("Bean1：" + i);
    }

}
