package java_.thread;

import java.util.concurrent.CyclicBarrier;

public class ConcurrentQ
{

    public static void main(String[] args)
    {
        testCyclicBarrier();
    }

    private static void testCyclicBarrier()
    {
        CyclicBarrier barrier = new CyclicBarrier(3);
        new Thread(() ->
        {
            try
            {
                barrier.await();
            } catch (Exception e)
            {}
            for (int i = 0; i < 100; i++)
                System.out.print(1);
        }).start();
        new Thread(() ->
        {
            try
            {
                barrier.await();
            } catch (Exception e)
            {}
            for (int i = 0; i < 100; i++)
                System.out.print(2);
        }).start();
        try
        {
            barrier.await();
        } catch (Exception e)
        {}
        System.out.println(3);
    }
}
