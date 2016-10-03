package spring.bean.circle;

public class Bean2 implements IBean
{
    public Bean2()
    {
        // TODO Auto-generated constructor stub
    }
    
    public Bean2(Bean1 bean1)
    {

    }
    
    public void setBean1(Bean1 bean1)
    {

    }

    @Override
    public void show()
    {
        System.out.println("Bean1");
    }
}
