package java_.comparable;


public class MyClass implements Comparable<MyClass>
{
    private int id;

    @Override
    public int compareTo(MyClass o)
    {
        //按id从小到大排序
        if (id > o.id)
        {
            return 1;
        } else if (id < o.id)
        {
            return -1;
        }
        return 0;
    }

}
