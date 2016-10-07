package java_.thread.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽<br/>
 */
public class AtomicIntegerQ
{
    public static void main(String[] args)
    {
        for (int i = 0; i < 100000; i++)
        {
            test1();
        }
        System.out.println("==================================");
        for (int i = 0; i < 10; i++)
        {
            test2();
        }
    }

    private static int i = 0;

    /**
     */
    public static void test1()
    {
        i = 0;
        CountDownLatch latch = new CountDownLatch(5);
        for (int j = 0; j < 5; j++)
        {
            new Thread(() ->
            {
                i++;
                latch.countDown();
            }).start();
        }
        try
        {
            latch.await();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.print(i + ",");
    }

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void test2()
    {
        CountDownLatch latch = new CountDownLatch(5);
        atomicInteger = new AtomicInteger(0);
        for (int j = 0; j < 5; j++)
        {
            new Thread(() ->
            {
                atomicInteger.incrementAndGet();
                latch.countDown();
            }).start();
        }
        try
        {
            latch.await();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.print(atomicInteger + ",");
    }
}
