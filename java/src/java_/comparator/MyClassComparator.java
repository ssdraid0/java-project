package java_.comparator;

import java.util.Comparator;

public class MyClassComparator implements Comparator<MyClass>
{

    @Override
    public int compare(MyClass myClass1, MyClass myClass2)
    {
        if (myClass1.getId() < myClass2.getId())
        {
            return -1;

        } else if (myClass1.getId() > myClass2.getId())
        {
            return 1;
        }
        return 0;
    }

}
