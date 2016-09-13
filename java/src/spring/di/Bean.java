package spring.di;

public class Bean implements IBean
{
    private String i;

   public Bean()
    {
        
    }

    public Bean(String i)
    {
        super();
        this.i = i;
    }

    public String getI()
    {
        return i;
    }

    public void setI(String i)
    {
        this.i = i;
    }

    @Override
    public void show()
    {
        System.out.println("Bean:"+i);
    }
}
