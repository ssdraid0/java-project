package spring.bean.init;

public class Bean1
{
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
