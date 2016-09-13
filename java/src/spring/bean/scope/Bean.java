package spring.bean.scope;

public class Bean implements IBean 
{

    @Override
    public void show()
    {
        System.out.println("Bean");
    }

}
