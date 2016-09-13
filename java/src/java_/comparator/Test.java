package java_.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test
{

    public static void main(String[] args)
    {
        Comparator<MyClass> comparator = new MyClassComparator();
        MyClass myClass1 = new MyClass(1);
        MyClass myClass2 = new MyClass(2);
        //结果为-1表示左边小于右边
        System.out.println(comparator.compare(myClass1, myClass2));
        List<MyClass> list = new ArrayList<>();
        list.add(myClass1);
        list.add(myClass2);
        Collections.sort(list, comparator);
        list.size();
    }

}
