package java_.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;

/**
 * ⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽<br/>
 * 1.线程安全是什么意思？<br/>
 * 线程安全：在多线程下和在单线程下永远都能获得一样的结果。<br/>
 * ⑴.例如：有两个线程分别给{@link ArrayList}添加1个元素，可能出现一个线程准备给数组下标0处添加元素时，<br/>
 * 另一个线程也给数组下标0处添加元素，结果{@link ArrayList}中只存储了一个元素。<br/>
 * <br/>
 * 2.有哪些类是线程安全的？是如何实现的？<br/>
 * {@link String}：本身不能改变。<br/>
 * {@link StringBuffer}，{@link Vector}，{@link Hashtable}：sychronized修饰方法。<br/>
 * {@link Collections#synchronizedList(List)}等：sychronized修饰代码块。<br/>
 * {@link CopyOnWriteArrayList}：。<br/>
 * <br/>
 */
@SuppressWarnings("unused")
public class ThreadSafeQ
{

    public static void main(String[] args) throws InterruptedException
    {
        for (int i = 0; i < 15000; i++)
        {    // System.out.print(testArrayList());
             // System.out.print(testSynchronizedList());
            System.out.print(testSynchronizedList2());
            // System.out.print(testCopyOnWriteArrayList());
        }
    }

    /**
     * 运行结果可能是1或2<br/>
     */
    private static int testArrayList() throws InterruptedException
    {
        List<Integer> list = new ArrayList<>();
        Thread t1 = new Thread(() ->
        {
            list.add(1);
        });
        Thread t2 = new Thread(() ->
        {
            list.add(1);
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        return list.size();
    }

    /**
     * 运行结果一定是2<br/>
     */
    private static int testSynchronizedList() throws InterruptedException
    {
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
        Thread t1 = new Thread(() ->
        {
            list.add(1);
        });
        Thread t2 = new Thread(() ->
        {
            list.add(1);
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        return list.size();
    }

    private static int testSynchronizedList2() throws InterruptedException
    {
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
        Thread t1 = new Thread(() ->
        {
            list.add(0);
            list.remove(0);
        });
        Thread t2 = new Thread(() ->
        {
            list.add(0);
            list.remove(0);
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        return list.size();
    }

    private static int testCopyOnWriteArrayList() throws InterruptedException
    {
        List<Integer> list = new CopyOnWriteArrayList<Integer>();
        Thread t1 = new Thread(() ->
        {
            if (list.isEmpty()) list.add(1);
        });
        Thread t2 = new Thread(() ->
        {
            if (list.isEmpty()) list.add(1);
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        return list.size();
    }
}
