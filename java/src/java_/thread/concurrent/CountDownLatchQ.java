package java_.thread.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * ⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽<br/>
 * 1.{@link CountDownLatch}的作用是什么？<br/>
 * 让一个或多个线程等待其他线程执行完后执行。<br/>
 * 2.{@link CountDownLatch}和{@link CyclicBarrier}的区别？<br/>
 * ⑴.{@link CyclicBarrier}能重复使用，{@link CountDownLatch}不能。<br/>
 * ⑵.<br/>
 */
public class CountDownLatchQ
{
    public static void main(String[] args)
    {
        testCountDown();
    }

    /**
     * 用{@link CountDownLatch}实现：两个线程分别给两个{@link ArrayList}添加数据，<br/>
     * 统计完后交给第3个线程把两个{@link ArrayList}的数据合并。<br/>
     */
    private static void testCountDown()
    {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> sum = new ArrayList<>();
        CountDownLatch latch = new CountDownLatch(2);
        new Thread(() ->
        {
            for (int i = 0; i < 1000; i++)
                list1.add(0);
            latch.countDown();
        }).start();
        new Thread(() ->
        {
            for (int i = 0; i < 1000; i++)
                list2.add(1);
            latch.countDown();
        }).start();
        try
        {
            latch.await();
        } catch (InterruptedException e)
        {}
        new Thread(() ->
        {
            for (Integer i : list1)
                sum.add(i);
            for (Integer i : list2)
                sum.add(i);
            System.out.println("总数量：" + sum.size());
        }).start();
    }

}
