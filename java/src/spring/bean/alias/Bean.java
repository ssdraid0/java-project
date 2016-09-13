package spring.bean.alias;

import spring.bean.alias.IBean;

public class Bean implements IBean 
{

    @Override
    public void show()
    {
        System.out.println("Bean");
    }

}
