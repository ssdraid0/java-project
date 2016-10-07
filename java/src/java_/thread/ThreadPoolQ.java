package java_.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 1.有几种线程池？</br>
 * {@link Executors#newCachedThreadPool()}：</br>
 * 
 * http://cuisuqiang.iteye.com/blog/2019372</br>
 */
public class ThreadPoolQ
{
    public static void main(String[] args)
    {
        testCachedThreadPool();
    }

    public static void testCachedThreadPool()
    {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++)
        {
            final int index = i;
            try
            {
                Thread.sleep(index *100);
            } catch (InterruptedException e)
            {}
            cachedThreadPool.execute(() ->
            {
                System.out.println(index);
            });
        }
    }

    public static void testFixedThreadPool()
    {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++)
        {
            final int index = i;
            fixedThreadPool.execute(() ->
            {
                try
                {
                    System.out.println(index);
                    Thread.sleep(2000);
                } catch (InterruptedException e)
                {}
            });
        }
    }

    public static void testSingleThreadExecutor()
    {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++)
        {
            final int index = i;
            singleThreadExecutor.execute(() ->
            {
                try
                {
                    System.out.println(index);
                    Thread.sleep(2000);
                } catch (InterruptedException e)
                {}
            });
        }
    }

    public static void testScheduledThreadPool(String[] args)
    {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.scheduleAtFixedRate(() ->
        {
            System.out.println("delay 1 seconds, and excute every 3 seconds");
        }, 1, 3, TimeUnit.SECONDS);
    }
}
