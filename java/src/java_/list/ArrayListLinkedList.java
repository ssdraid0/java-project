package java_.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListLinkedList
{
    static void insert(List<Integer> list, int index)
    {
        list.add(index, 1);
    }

    public static void main(String[] args)
    {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();
        int i = 9;
        for (int j = 0; j < i; j++)
        {
            list1.add(0);
            list2.add(0);
        }
        long startTime = System.nanoTime();
        insert(list1, 9);
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
        startTime = System.nanoTime();
        insert(list2, 9);
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }
}
