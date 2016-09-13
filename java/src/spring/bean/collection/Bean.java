package spring.bean.collection;

import java.util.List;

public class Bean implements IBean
{
    private List<Integer> list;

    public List<Integer> getList()
    {
        return list;
    }

    public void setList(List<Integer> list)
    {
        this.list = list;
    }

    @Override
    public void show()
    {
        System.out.println("Bean:"+list.size());
    }
}
