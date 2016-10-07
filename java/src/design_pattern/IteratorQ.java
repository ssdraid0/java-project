package design_pattern;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * ⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽</br>
 * 1.什么时候使用迭代器（Iterator）模式？ </br>
 * 用于遍历对象。</br>
 * </br>
 * 2.Java中哪些地方使用了？ </br>
 * {@link Iterator}</br>
 */
public class IteratorQ
{
    public static void main(String[] args)
    {
        testIterator();
    }

    public static void testIterator()
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
