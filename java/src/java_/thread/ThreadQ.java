package java_.thread;

import java.util.concurrent.Callable;

/**
 * ⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽</br>
 * 1.实现多线程几种方式？</br>
 * ⑴.写一个类继承{@link Thread}类重写{@link Thread#run()}方法。</br>
 * ⑵.写一个类实现{@link Runnable}接口，重写{@link Runnable#run()}方法。</br>
 * ⑶.写一个类实现{@link Callable}接口，重写{@link Callable#call()}方法。</br>
 * </br>
 * 3.多次调用同一个{@link Thread}的{@link Thread#start()}方法会怎样？</br>
 * 会抛出{@link IllegalThreadStateException}异常。</br>
 * </br>
 * 4.{@link Thread}有哪些静态方法？</br>
 * 静态方法：{@link Thread#sleep(long)}，{@link Thread#yield()}，{@link Thread#interrupted()}</br>
 * </br>
 * 5.{@link Thread#join()}，{@link Thread#join(long)}，{@link Thread#join(long, int)}的作用是什么？。</br>
 * {@link Thread#join(long)}：等待调用这个方法的线程最多xx毫秒。等待0毫秒意味着一直等到线程死亡。</br>
 * {@link Thread#join()}：等同于参数为0的{@link Thread#join(long)}。</br>
 * </br>
 * 6.守护线程和用户线程的区别？如何把一个线程设置为守护线程？</br>
 * 主线程执行结束后，用户线程会继续执行，所有的用户线程执行完毕后，不管守护线程是否执行完成都强行结束守护线程。</br>
 * {@link Thread#setDaemon(boolean)}。</br>
 * </br>
 * 6.{@link Thread}怎么设置优先级？优先级的范围？默认优先级是多少？</br>
 * {@link Thread#setPriority(int)}。</br>
 * 范围是1-10（包括边界）。默认是5。</br>
 * </br>
 * 7.{@link Thread#sleep(long)}的作用是什么？调用后线程进入什么状态？</br>
 * 让调用这个方法的{@link Thread}睡眠xx毫秒。</br>
 * 调用后线程进入{@link Thread.State#TIMED_WAITING}状态。 </br>
 * 等待完成后线程进入{@link Thread.State#RUNNABLE}状态。 </br>
 * </br>
 * 8.{@link Thread#yield()}的作用是什么？</br>
 * 让{@link Thread}放弃当前获得的时间片。</br>
 * </br>
 * 9.下面代码中的{@link Thread#join()}的作用是什么？运行结果是什么？</br>
 * 如果去掉thread.join()运行结果是什么？</br>
 * 
 * <pre>
 * public static void testJoin()
 * {
 *     Thread t = new Thread(() ->
 *     {
 *         for (int i = 0; i < 100; i++)
 *             System.out.print(1);
 *     });
 *     try
 *     {
 *         t.start();
 *         t.join();
 *     } catch (InterruptedException e)
 *     {}
 *     new Thread(() ->
 *     {
 *         System.out.print(2);
 *     }).start();
 * }
 * </pre>
 * 
 * 让主线程等待thread线程执行完成后再运行。</br>
 * 运行结果：100个1，最后1个2 。</br>
 * 如果去掉thread.join()运行结果：100个1，其中有1个2 。</br>
 * 10.{@link Thread#interrupt()}的作用是什么？</br>
 * {@link Thread#interrupted()}和{@link Thread#isInterrupted()}的区别？</br>
 * 通知一个线程应该结束了。通常和静态方法{@link Thread#interrupted()}配合使用。</br>
 * 代码在{@link ThreadQ.Interrupt#dateType()}。</br>
 * {@link Thread#interrupted()}是静态方法，{@link Thread#isInterrupted()}是实例方法。</br>
 * </br>
 */
public class ThreadQ
{
    public static void main(String[] args)
    {
        // Join.test1();
        // SetDaemon.test1();
        // testInterrupt();
        testJoin();
        // testSleep();
    }

    public static void testInterrupt()
    {
        Thread thread = new Thread(() ->
        {
            for (int i = 0; i < 1000; i++)
            {
                System.out.print(i + ",");
            }
        });
        thread.start();
        thread.interrupt();
    }

    public static void testInterrupt2()
    {
        Thread t = new Thread(() ->
        {
            while (!Thread.interrupted())
            {
                System.out.print("1");
            }
            // 在这里进行线程被中断后需要的操作
            System.out.println("finish");
        });
        t.start();
        try
        {
            Thread.sleep(1);
        } catch (InterruptedException e)
        {}
        t.interrupt();
    }

    public static void testJoin()
    {
        Thread t = new Thread(() ->
        {
            for (int i = 0; i < 100; i++)
                System.out.print(1);
        });
        try
        {
            t.start();
            t.join();
        } catch (InterruptedException e)
        {}
        new Thread(() ->
        {
            System.out.print(2);
        }).start();
    }

    public static void testDaemon()
    {
        Thread thread = new Thread(() ->
        {
            for (int i = 0; i < 500; i++)
            {
                System.out.println(i);
            }
        });
        thread.setDaemon(true);
        thread.start();
        Thread thread2 = new Thread(() ->
        {
            for (int i = 0; i < 10; i++)
            {
                System.out.println(i);
            }
        });
        thread2.start();
    }

    public static void testSleep()
    {
        Thread thread = new Thread(() ->
        {
            try
            {
                Thread.sleep(10);
                System.out.println("running");
            } catch (InterruptedException e)
            {}
        });
        thread.start();
        while (thread.getState() != Thread.State.TERMINATED)
        {
            System.out.print(thread.getState() + " ");
        }
    }
}
