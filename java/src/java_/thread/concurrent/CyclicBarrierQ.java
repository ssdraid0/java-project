package java_.thread.concurrent;

import java.util.concurrent.CyclicBarrier;

/**
 * ⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽<br/>
 * 1.{@link CyclicBarrier}的作用是什么？<br/>
 * 让一个或多个线程互相等待。<br/>
 */
public class CyclicBarrierQ
{
    public static void main(String[] args)
    {
        test1();
    }

    private static void test1()
    {
        CyclicBarrier barrier = new CyclicBarrier(2);
        new Thread(() ->
        {
            System.out.println("1");
            try
            {
                barrier.await();
            } catch (Exception e)
            {}
            System.out.println("2");
        }).start();
        new Thread(() ->
        {
            System.out.println("1");
            try
            {
                barrier.await();
            } catch (Exception e)
            {}
            System.out.println("2");
        }).start();
    }
}
