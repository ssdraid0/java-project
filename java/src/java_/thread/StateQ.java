package java_.thread;

/**
 * ⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽<br>
 * 1.{@link Thread}有几种状态？<br>
 * 创建：{@link Thread.State#NEW}：。<br>
 * 就绪：{@link Thread.State#RUNNABLE}。<br>
 * 等待：({@link Thread.State#WAITING})。<br>
 * 定时等待：({@link Thread.State#TIMED_WAITING})。<br>
 * 阻塞：({@link Thread.State#BLOCKED})。<br>
 * 死亡：({@link Thread.State#TERMINATED})：run方法运行结束后。<br>
 * <br>
 * 2.{@link Thread}的几种状态是如何切换的？<br>
 * 创建了一个线程后，是创建状态，<br>
 * 调用{@link Thread#start()}后，先是就绪状态，后是运行状态。<br>
 * {@link Runnable#run()}运行完成后进入死亡状态。<br>
 * 等待状态：调用{@link Thread#sleep(long)}，{@link Object#wait(long)}后。<br>
 * 阻塞状态：一个线程等待锁时是阻塞状态。<br>
 */
@SuppressWarnings("unused")
public class StateQ
{
    public static void main(String[] args)
    {
        // newState();
        // runnableState();
        blockedState();
    }

    
    private static void newState()
    {
        Thread thread = new Thread(() ->
        {});
        System.out.println(thread.getState());
    }

    private static void runnableState()
    {
        Thread thread = new Thread(() ->
        {
            for (int i = 0; i < 10; i++)
                System.out.print("RUNNING,");
        });
        for (int i = 0; i < 10; i++)
            System.out.print(thread.getState() + ",");
        thread.start();
    }

    private static void blockedState()
    {
        Object object = new Object();
        Thread thread1 = new Thread(() ->
        {
            synchronized (object)
            {
                for (int i = 0; i < 50; i++)
                    System.out.print("thread1,");
            }
        });
        Thread thread2 = new Thread(() ->
        {
            synchronized (object)
            {
                for (int i = 0; i < 50; i++)
                    System.out.print("thread2,");
            }
        });
        thread1.start();
        thread2.start();
        for (int i = 0; i < 50; i++)
            System.out.print(thread1.getState() + ",");
        for (int i = 0; i < 50; i++)
            System.out.print(thread2.getState() + ",");
    }
}
