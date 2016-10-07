package spring.bean.set;

public class Bean
{
    private int i = 0;

    public Bean()
    {}

    public void setI(int i)
    {
        this.i = i;
    }

    public void say()
    {
        System.out.println("Bean1：" + i);
    }

}
