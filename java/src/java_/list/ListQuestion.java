package java_.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.{@code List <? extends Fruit>}和{@code List <? super Fruit>}的区别？<br>
 * {@code List <? extends Fruit>}：{@link List}中所有元素都是Fruit的子类(包含本身)。 <br>
 * {@code List <? super Fruit>}：{@link List}中所有元素都是Fruit的父类(包含本身)。<br>
 * 2.下面的代码{@link ListQuestion#test1()}能否运行？为什么？如何修改才能运行？<br>
 * 不能。因为{@link List}在声明时没有指定到底要添加Fruit的哪种子类。要改成{@link ListQuestion#test2()}。<br>
 * 3.下面的代码{@link ListQuestion#test3()}的运行结果是什么？为什么？<br>
 * 如果把{@code list.remove(1)}修改为{@code list.remove((Integer)1)}运行结果又是什么？<br>
 * 运行结果是1。因为{@code list.remove(1)}调用的是{@link List#remove(int)}而不是{@link List#remove(Object)}。<br>
 * 运行结果变为0。
 */
public class ListQuestion
{
    public static void main(String[] args)
    {

        // List<Object> list = new ArrayList<Integer>();
        // list.add("string");
    }

    public static void test1()
    {
        // List<? extends Fruit> list1 = new ArrayList<>();
        // list1.add(new Fruit());
        // list1.add(new Apple());
        // List<? extends Fruit> list2 = new ArrayList<Apple>();
        // list2.add(new Fruit());
        // list2.add(new Apple());
    }

    public static void test2()
    {
        List<? super Fruit> list3 = new ArrayList<>();
        list3.add(new Fruit());
    }

    public static void test3()
    {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(0);
        list.remove(1);
        // list.remove((Integer)1);
        for (Integer integer : list)
        {
            System.out.println(integer);
        }
    }

}

class Fruit
{

}

class Apple extends Fruit
{

}

class Orange extends Fruit
{

}