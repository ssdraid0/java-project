package java_;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1.{@link Thread}有几种状态？<br>
 * 创建({@link Thread.State#NEW})：还没有调用{@link Thread#start()}方法。<br>
 * 就绪({@link Thread.State#RUNNABLE})。<br>
 * 等待({@link Thread.State#WAITING})。<br>
 * 定时等待({@link Thread.State#TIMED_WAITING})。<br>
 * 阻塞({@link Thread.State#BLOCKED})。<br>
 * 死亡({@link Thread.State#TERMINATED})：run方法运行结束后。<br>
 * <br>
 * 2.多次调用同一个{@link Thread}的{@link Thread#start()}方法会怎样？<br>
 * 会抛出{@link IllegalThreadStateException}异常。<br>
 * <br>
 * 3.{@link Thread#join()}，{@link Thread#join(long)}，{@link Thread#join(long, int)}的作用是什么？。<br>
 * {@link Thread#join(long)}：等待调用这个方法的线程最多xx毫秒。等待0毫秒意味着一直等到线程死亡。<br>
 * {@link Thread#join()}：等同于参数为0的{@link Thread#join(long)}。<br>
 * <br>
 * 4.守护线程和用户线程的区别？如何把一个线程设置为守护线程？<br>
 * 主线程执行结束后，用户线程会继续执行，所有的用户线程执行完毕后，不管守护线程是否执行完成都强行结束守护线程。<br>
 * {@link Thread#setDaemon(boolean)}。<br>
 * <br>
 * 5.{@link Thread}怎么设置优先级？优先级的范围？默认优先级是多少？<br>
 * {@link Thread#setPriority(int)}。<br>
 * 范围是1-10（包括边界）。默认是5。<br>
 * <br>
 * 6.静态方法{@link Thread#sleep(long)}的作用是什么？调用后{@link Thread}进入什么状态？<br>
 * 让调用这个方法的{@link Thread}睡眠xx毫秒。<br>
 * 进入{@link Thread.State#TIMED_WAITING}状态。 <br>
 * <br>
 * 7.静态方法{@link Thread#yield()}的作用是什么？<br>
 * 让{@link Thread}放弃当前获得的时间片。<br>
 * <br>
 * 8.实例方法{@link Thread#interrupt()}的作用是什么？{@link Thread#interrupted()}和{@link Thread#isInterrupted()}的区别？<br>
 * 通知一个线程应该结束了。通常和静态方法{@link Thread#interrupted()}配合使用。代码在{@link ThreadQuestion.Interrupt#test1()}。<br>
 * {@link Thread#interrupted()}是静态方法，{@link Thread#isInterrupted()}是实例方法。<br>
 * <br>
 */
public class ThreadQuestion
{
    public static void main(String[] args)
    {
        // SychronizedQuestion.WaitSleep.testSleep1();
        // SychronizedQuestion.WaitSleep.testWait1();
        // SychronizedQuestion.WaitSleep.testWaitTime1();
        // SychronizedQuestion.WaitNotify.testWait();
        // WaitNotifyQuestion.NotifyNotifyAll.testNotifyNotifyAll2();
        // Join.test1();
        // SetDaemon.test1();
        // Interrupt.test1();
        CallableQuestion.test1();
    }

    static class Start
    {
        public static void test1()
        {
            Thread t = new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                }
            });
            t.start();
            t.start();
        }
    }

    static class Join
    {
        public static void test1()
        {
            Thread thread = new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    for (int i = 0; i < 100; i++)
                    {
                        System.out.println(1);
                    }
                }
            });
            thread.start();
            try
            {
                thread.join(10);
            } catch (InterruptedException e)
            {

            }
            Thread thread2 = new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    for (int i = 0; i < 10; i++)
                    {
                        System.out.println(2);
                    }
                }
            });
            thread2.start();
        }
    }

    static class SetDaemon
    {
        public static void test1()
        {
            Thread thread = new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    for (int i = 0; i < 500; i++)
                    {
                        System.out.println(i);
                    }
                }
            });
            thread.setDaemon(true);
            thread.start();
            Thread thread2 = new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    for (int i = 0; i < 10; i++)
                    {
                        System.out.println(i);
                    }
                }
            });
            thread2.start();
        }
    }

    static class Sleep
    {
        public static void test1()
        {
            Thread thread = new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    for (int i = 0; i < 5; i++)
                    {
                        System.out.print("1 ");
                        try
                        {
                            Thread.sleep(100);
                        } catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                    }
                }
            });
            thread.start();
            while (thread.getState() != Thread.State.TERMINATED)
            {
                System.out.print(thread.getState() + " ");
                // try
                // {
                // Thread.sleep(10);
                // } catch (InterruptedException e)
                // {
                // e.printStackTrace();
                // }
            }
        }
    }

    static class Interrupt
    {
        public static void test1()
        {
            Thread thread = new Thread(() -> {
                while (!Thread.interrupted())
                {
                    System.out.print("1");
                }
                // 在这里进行线程被中断后需要的操作
                System.out.println("finish");
            });
            thread.start();
            try
            {
                Thread.sleep(1);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            thread.interrupt();
        }
    }
}

class RunnableQuestion
{
    static class MyRunnable1 implements Runnable
    {
        @Override
        public void run()
        {
        }
    }

    static class MyRunnable2 implements Runnable
    {
        @Override
        public void run()
        {
            System.out.println("Hello from a thread!");
        }
    }
}

/**
 * 1.violate和sychronized的区别？<br>
 * sychronized保证原子性和可见性。<br>
 * violate只保证可见性。<br>
 * 
 * 2.violate能禁止进行指令重排序吗？<br>
 * 对。<br>
 */
class ViolateQuestion
{

    public static void test1()
    {
        new Test1().test();
    }

    static class Test1
    {
        int i;

        public void test()
        {
            new Thread(() -> {
                System.out.println("Thread1 Start");
                for (int j = 0; j < 1000; j++)
                {
                    System.out.print(i + ",");
                }
                System.out.println("Thread1 End");
            }).start();
            new Thread(() -> {
                try
                {
                    System.out.println("Thread2 Start");
                    i = 1;
                    Thread.sleep(1);
                    i = 2;
                    Thread.sleep(1);
                    System.out.println("Thread2 End");
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }).start();
        }
    }

}

/**
 * 1.synchronized有几种用法？<br>
 * a.修饰代码块：<br>
 * b.修饰实例方法：等价于synchronized(this)。<br>
 * c.修饰静态方法：等价于synchronized(一个类)。<br>
 * <br>
 * 2.用synchronized实现一个死锁，写出代码。<br>
 * 代码：{@link SychronizedQuestion#testDeadLock()}。<br>
 * <br>
 * 3.用synchronized实现生产者消费者。<br>
 * 代码：{@link SychronizedQuestion.ProducerConsumer#testProducerConsumer()}。<br>
 * <br>
 * 4.用synchronized实现三个线程交替打印10次ABC。<br>
 * 代码：{@link SychronizedQuestion.ProducerConsumer#testPrintABC()}。<br>
 * <br>
 * 5.什么是乐观锁，悲观锁？<br>
 * 乐观锁：<br>
 * 悲观锁：<br>
 */
class SychronizedQuestion
{
    public static void test1()
    {
        SychronizedThis s1 = new SychronizedThis();
        Thread thread1 = new Thread(s1, "Thread1");
        Thread thread2 = new Thread(s1, "Thread2");
        thread1.start();
        thread2.start();
    }

    public static void test2()
    {
        Thread thread1 = new Thread(new SychronizedThis(), "Thread1");
        Thread thread2 = new Thread(new SychronizedThis(), "Thread2");
        thread1.start();
        thread2.start();
    }

    public static void testInstanceMethod1()
    {
        SychronizedInstanceMethod s = new SychronizedInstanceMethod();
        Thread thread1 = new Thread(s, "Thread1");
        Thread thread2 = new Thread(s, "Thread2");
        thread1.start();
        thread2.start();
    }

    public static void testInstanceMethod2()
    {
        Thread thread1 = new Thread(new SychronizedInstanceMethod(), "Thread1");
        Thread thread2 = new Thread(new SychronizedInstanceMethod(), "Thread2");
        thread1.start();
        thread2.start();
    }

    public static void testStaticMethod1()
    {
        Thread thread1 = new Thread(new SychronizedStaticMethod(), "Thread1");
        Thread thread2 = new Thread(new SychronizedStaticMethod(), "Thread2");
        thread1.start();
        thread2.start();
    }

    public static void testClass1()
    {
        Thread thread1 = new Thread(new SychronizedClass(), "Thread1");
        Thread thread2 = new Thread(new SychronizedClass(), "Thread2");
        thread1.start();
        thread2.start();
    }

    public static void testDeadLock()
    {
        final Object left = new Object();
        final Object right = new Object();
        Thread t1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                synchronized (left)
                {
                    try
                    {
                        Thread.sleep(2000);
                    } catch (InterruptedException e)
                    {
                    }
                    synchronized (right)
                    {
                        System.out.println("leftRight end!");
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                synchronized (right)
                {
                    try
                    {
                        Thread.sleep(2000);
                    } catch (InterruptedException e)
                    {
                    }
                    synchronized (left)
                    {
                        System.out.println("rightLeft end!");
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }

    public static void testPrintABC()
    {
        PrintABC printABC = new PrintABC("C");
        new Thread(new PrintABCRun(printABC, "C", "A")).start();
        new Thread(new PrintABCRun(printABC, "A", "B")).start();
        new Thread(new PrintABCRun(printABC, "B", "C")).start();
    }

    public static void test5()
    {
        boolean flag = true;
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        List<Integer> listAll = new ArrayList<Integer>();
        Thread t1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < 1000; i++)
                {
                    list1.add(0);
                }
            }
        });
        Thread t2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < 2000; i++)
                {
                    list2.add(0);
                }
            }
        });
        t1.start();
        t2.start();
        while (flag)
        {
            if (t1.getState().equals(Thread.State.TERMINATED) && t2.getState().equals(Thread.State.TERMINATED))
            {
                break;
            }
        }
        Thread t3 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for (Integer i : list1)
                {
                    listAll.add(i);
                }
                for (Integer i : list2)
                {
                    listAll.add(i);
                }
            }
        });
        t3.start();
        while (flag)
        {
            if (t3.getState().equals(Thread.State.TERMINATED))
            {
                System.out.println("统计完成，总数量 " + listAll.size());
                break;
            }
        }
    }

    static class SychronizedThis implements Runnable
    {
        private static int count;

        @Override
        public void run()
        {
            synchronized (this)
            {
                for (int i = 0; i < 5; i++)
                {
                    try
                    {
                        System.out.println(Thread.currentThread().getName() + ":" + (count++));
                        Thread.sleep(100);
                    } catch (InterruptedException e)
                    {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }

    static class SychronizedInstanceMethod implements Runnable
    {
        private static int count;

        public synchronized void method()
        {
            for (int i = 0; i < 5; i++)
            {
                try
                {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void run()
        {
            method();
        }
    }

    static class SychronizedStaticMethod implements Runnable
    {
        private static int count;

        public synchronized static void method()
        {
            for (int i = 0; i < 5; i++)
            {
                try
                {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void run()
        {
            method();
        }
    }

    static class SychronizedClass implements Runnable
    {
        private static int count;

        @Override
        public void run()
        {
            synchronized (SychronizedClass.class)
            {
                for (int i = 0; i < 5; i++)
                {
                    try
                    {
                        System.out.println(Thread.currentThread().getName() + ":" + (count++));
                        Thread.sleep(100);
                    } catch (InterruptedException e)
                    {
                    }
                }
            }
        }
    }

    static class ProducerConsumer
    {
        public static void testProducerConsumer()
        {
            Container container = new Container(5);// 定义箱子最大容量，此处为5
            Producer producer = new Producer(container);// 箱子中的苹果数要同步，所以将箱子对象引用作为形参传给生产者和消费者
            Consumer consumer = new Consumer(container);//
            new Thread(producer, "producer").start();// 启动生产消费模式
            new Thread(consumer, "consumer").start();
        }

        static class Container
        {
            public int max; // 定义容器最大容量
            public int currentNum;// 定义容器当前容量

            public Container(int max)
            {
                this.max = max;
                currentNum = 0;
            }
        }

        static class Producer implements Runnable
        {
            public Container con;

            public Producer(Container con)
            {
                this.con = con;
            }

            public void run()
            {
                while (true)
                {// 有无数个苹果
                    synchronized (con)
                    {
                        if (con.currentNum < con.max)
                        {// 若当前容器不满，则可以生产
                            con.notify();// 生产完则通知并释放锁
                            con.currentNum++;
                            System.out.println(" 生产者正在生产...+1, 当前产品数：" + con.currentNum);
                        } else if (con.currentNum == con.max)
                        {//
                            System.out.println("箱子已经饱和，生产者停止生产，正在等待消费...");
                            try
                            {
                                con.wait();
                            } catch (InterruptedException e)
                            {
                                System.out.println(e.getMessage());
                            }
                        }// if else if
                    }// syn 执行完同步块 释放锁，输出结果中连续出现两次生产者是因为：释放锁后，若没有等待线程，则还是先执行到哪个线程的同步块就执行它

                    try
                    {
                        Thread.sleep(100);// 调节生产者频率，过快容易猝死~~
                    } catch (InterruptedException e)
                    {
                        System.out.println(e.getMessage());
                    }// try
                }// while
            }
        }

        static class Consumer implements Runnable
        {
            public Container con;

            public Consumer(Container con)
            {
                this.con = con;
            }

            public void run()
            {
                while (true)
                {
                    synchronized (con)
                    {
                        if (con.currentNum > 0)
                        {
                            con.notify();
                            con.currentNum--;
                            System.out.println(" 消费者正在消费...-1, 当前产品数：" + con.currentNum);
                        } else if (con.currentNum == 0)
                        {
                            System.out.println("箱子已经空了，消费者停止消费，正在等待生产...");
                            try
                            {
                                con.wait();
                            } catch (InterruptedException e)
                            {
                                System.out.println(e.getMessage());
                            }
                        }// else if
                    }// syn

                    try
                    {
                        Thread.sleep(140);// 调节消费者频率，过快容易撑死~~
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }// try
                }// while
            }// run
        }
    }

    static class PrintABC
    {
        public PrintABC(String s)
        {
            this.lastStr = s;
        }

        public String lastStr;
    }

    static class PrintABCRun implements Runnable
    {
        PrintABC printABC;
        String prev;
        String cur;

        public PrintABCRun(PrintABC printABC, String prev, String cur)
        {
            this.printABC = printABC;
            this.prev = prev;
            this.cur = cur;
        }

        @Override
        public void run()
        {
            for (int i = 0; i < 10; i++)
            {
                synchronized (printABC)
                {
                    while (!prev.equals(printABC.lastStr)) // wait until last printed character was "C"
                    {
                        try
                        {

                            printABC.wait();
                        } catch (InterruptedException e)
                        {
                        }
                    }
                    System.out.print(cur);// change last printed character
                    printABC.lastStr = cur;
                    printABC.notifyAll();// wrong if abc.notify()
                }
            }
        }
    }
}

/**
 * 1.写出代码的结果。<br>
 * <br>
 * 2.{@link Thread#sleep(long)}和{@link Object#wait()}的区别？<br>
 * a.调用{@link Thread#sleep(long)}后线程进入定时等待状态({@link Thread.State#TIMED_WAITING})。调用{@link Object#wait()}
 * 后线程进入等待状态( {@link Thread.State#WAITING})。调用{@link Object#wait(long)}后线程也进入定时等待状态(
 * {@link Thread.State#TIMED_WAITING})。<br>
 * b.{@link Thread#sleep(long)}不会释放锁，{@link Object#wait()}会释放锁。<br>
 * c.{@link Thread#sleep(long)}阻塞一段时间后自动唤醒，{@link Object#wait()}需要别的线程调用{@link Object#notify()}或
 * {@link Object#notifyAll()}唤醒。<br>
 * <br>
 * 3.{@link Object#notify()}和{@link Object#notifyAll()}的区别？<br>
 * {@link Object#notify()}是随机唤醒一个线程，{@link Object#notifyAll()}是唤醒所有线程。<br>
 * 测试代码：{@link WaitNotifyQuestion.NotifyNotifyAll#testNotifyNotifyAll1()}，
 * {@link WaitNotifyQuestion.NotifyNotifyAll#testNotifyNotifyAll2()} <br>
 */
class WaitNotifyQuestion
{
    static class WaitNotify
    {
        public static String s = "";

        public static void testWaitNotify()
        {
            new Thread(new Wait()).start();
            new Thread(new Notify()).start();
        }

        public static void testWait2()
        {
            new Thread(new WaitInstance()).start();
        }

        public static void testWait3()
        {
            new Thread(new WaitClass()).start();
        }

        public static void testWaitInstanceMethod()
        {
            new Thread(new WaitInstanceMethod()).start();
        }

        static class Wait implements Runnable
        {
            public void run()
            {
                synchronized (s)
                {
                    try
                    {
                        System.out.println("wait前");
                        s.wait();
                        System.out.println("wait后");
                    } catch (InterruptedException e)
                    {
                        System.out.println("wait异常");
                    }
                    System.out.println("获取了锁");
                }
            }
        }

        static class WaitInstance implements Runnable
        {
            public void run()
            {
                synchronized (s)
                {
                    try
                    {
                        System.out.println("wait前");
                        Object o = new Object();
                        o.wait();
                        System.out.println("wait后");
                    } catch (InterruptedException e)
                    {
                    }
                }
            }
        }

        static class WaitClass implements Runnable
        {
            public void run()
            {
                synchronized (Object.class)
                {
                    try
                    {
                        System.out.println("wait前");
                        Object.class.wait();
                        // Object o = new Object();
                        // o.wait();
                        System.out.println("wait后");
                    } catch (InterruptedException e)
                    {
                    }
                }
            }
        }

        static class WaitInstanceMethod implements Runnable
        {
            public synchronized void run()
            {
                try
                {
                    System.out.println("wait前");
                    this.wait();
                    System.out.println("wait后");
                } catch (InterruptedException e)
                {
                }
            }
        }

        static class Notify implements Runnable
        {
            public void run()
            {
                synchronized (s)
                {
                    System.out.println("notify前");
                    s.notify();
                    System.out.println("notify后");
                    System.out.println("释放了锁");
                }
            }
        }
    }

    static class WaitSleep
    {
        public static void testSleep1()
        {
            Thread thread = new Thread(new Sleep());
            System.out.println(thread.getState());
            thread.start();
            while (true)
            {
                System.out.println(thread.getState());
                try
                {
                    Thread.sleep(10);
                } catch (InterruptedException e)
                {
                    System.out.println(e.getMessage());
                }
            }
        }

        public static void testWait1()
        {
            Thread thread = new Thread(new Wait());
            System.out.println(thread.getState());
            thread.start();
            while (true)
            {
                System.out.println(thread.getState());
                try
                {
                    Thread.sleep(10);
                } catch (InterruptedException e)
                {
                    System.out.println(e.getMessage());
                }
            }
        }

        public static void testWaitTime1()
        {
            Thread thread = new Thread(new WaitTime());
            System.out.println(thread.getState());
            thread.start();
            while (true)
            {
                System.out.println(thread.getState());
                try
                {
                    Thread.sleep(100);
                } catch (InterruptedException e)
                {
                    System.out.println(e.getMessage());
                }
            }
        }

        static class Sleep implements Runnable
        {
            public void run()
            {
                try
                {
                    Thread.sleep(100);
                } catch (InterruptedException e)
                {
                    System.out.println(e.getMessage());
                }
            }
        }

        public static String s = "";

        static class Wait implements Runnable
        {
            public void run()
            {
                synchronized (s)
                {
                    try
                    {
                        s.wait();
                    } catch (InterruptedException e)
                    {
                        System.out.println("wait异常");

                    }
                }
            }
        }

        static class WaitTime implements Runnable
        {
            public void run()
            {
                synchronized (s)
                {
                    try
                    {
                        s.wait(1000);
                    } catch (InterruptedException e)
                    {
                        System.out.println("wait异常");
                    }
                }
            }
        }
    }

    static class NotifyNotifyAll
    {
        public static void testNotifyNotifyAll1()
        {
            new Thread(new Wait1("1")).start();
            new Thread(new Wait1("2")).start();
            new Thread(new Notify1("1")).start();
        }

        public static void testNotifyNotifyAll2()
        {
            new Thread(new Wait1("1")).start();
            new Thread(new Wait1("2")).start();
            new Thread(new NotifyAll1("1")).start();
        }

        static String s = "";

        static class Wait1 implements Runnable
        {
            private String name;

            public Wait1(String name)
            {
                this.name = name;
            }

            @Override
            public void run()
            {
                synchronized (s)
                {
                    try
                    {
                        for (int i = 0; i < 5; i++)
                        {
                            System.out.println("wait" + name + "前");
                        }
                        s.wait();
                        for (int i = 0; i < 5; i++)
                        {
                            System.out.println("wait" + name + "后");
                        }
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }

        static class Notify1 implements Runnable
        {
            private String name;

            public Notify1(String name)
            {
                this.name = name;
            }

            @Override
            public void run()
            {
                synchronized (s)
                {
                    for (int i = 0; i < 5; i++)
                    {
                        System.out.println("notify" + name + "前");
                    }
                    s.notify();
                    for (int i = 0; i < 5; i++)
                    {
                        System.out.println("notify" + name + "后");
                    }
                }
            }
        }

        static class NotifyAll1 implements Runnable
        {
            private String name;

            public NotifyAll1(String name)
            {
                this.name = name;
            }

            @Override
            public void run()
            {
                synchronized (s)
                {
                    for (int i = 0; i < 5; i++)
                    {
                        System.out.println("notifyAll" + name + "前");
                    }
                    s.notifyAll();
                    for (int i = 0; i < 5; i++)
                    {
                        System.out.println("notifyAll" + name + "后");
                    }
                }
            }
        }
    }

}

/**
 * 1.{@link ReentrantLock}和synchronized的区别是什么？<br>
 * a.{@link ReentrantLock}通过{@link ReentrantLock#lock()}方法获取锁，通过{@link ReentrantLock#unlock()}
 * 方法释放锁，比synchronized灵活。<br>
 * b.{@link ReentrantLock}能通过{@link ReentrantLock#tryLock()}方法的返回值判断锁是否获取成功。<br>
 */
class ReentrantLockQuestion
{

}

/**
 * 1.{@link Callable}和{@link Runnable}的区别？<br>
 * {@link Runnable#run()}方法没有返回值，{@link Callable#call()}有返回值。<br>
 * <br>
 * 2.<br>
 * <br>
 */
class CallableQuestion
{
    public static void test1()
    {
        Callable<Integer> callable = new Callable<Integer>()
        {
            public Integer call() throws Exception
            {
                return new Random().nextInt(100);
            }
        };
        FutureTask<Integer> future = new FutureTask<Integer>(callable);
        new Thread(future).start();
        try
        {
            Thread.sleep(5000);// 可能做一些事情
            System.out.println(future.get());
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } catch (ExecutionException e)
        {
            e.printStackTrace();
        }
    }
}
