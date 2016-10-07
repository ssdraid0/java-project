package java_.thread.concurrent;

import java.util.concurrent.Semaphore;

/**
 * ⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽<br/>
 * 1.{@link Semaphore}的作用是什么？<br/>
 * 控制多线程并发度。<br/>
 */
public class SemaphoreQ
{
    public static void main(String[] args)
    {
        test1();
    }

    /**
     * 先输出5个"信号量"，过一会儿后输出最后一个"信号量"。
     */
    public static void test1()
    {
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 6; i++)
        {
            new Thread(() ->
            {
                try
                {
                    semaphore.acquire();
                    System.out.println("信号量");
                    Thread.sleep(10000);
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
                semaphore.release();
            }).start();
        }
    }
}
