package spring.bean.circle;

public class Bean1 implements IBean
{
    public Bean1()
    {
        // TODO Auto-generated constructor stub
    }

    public Bean1(Bean2 bean2)
    {

    }

    public void setBean2(Bean2 bean2)
    {

    }

    @Override
    public void show()
    {
        System.out.println("Bean1");
    }

}
