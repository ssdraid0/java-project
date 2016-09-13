package design_pattern.iterator;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 设计模式：迭代器（Iterator）模式。</br>
 * 1.什么时候使用？ </br>
 * 用于遍历对象。</br>
 * 2.JDK中哪些地方使用了？ </br>
 *Iterator接口。</br>
 */
public class IteratorTest
{
    public static void main(String[] args)
    {
        LinkedList<Integer> list = new LinkedList<>();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext())
        {
            Integer integer = (Integer) iterator.next();
            System.out.println(integer);
        }
    }

}
