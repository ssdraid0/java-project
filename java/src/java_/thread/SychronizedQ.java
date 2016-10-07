package java_.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * ⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽</br>
 * 1.synchronized有几种用法？</br>
 * a.修饰代码块：</br>
 * b.修饰实例方法：等价于synchronized(this)，锁是实例。</br>
 * c.修饰静态方法：等价于synchronized(xxx.class)，锁是类。</br>
 * </br>
 * 2.可重入锁是什么意思？synchronized是可重入锁吗？</br>
 * 一个线程在在拥有一个锁的情况能重复进入需要这个锁的地方。是。</br>
 * {@link #reenterLock}。</br>
 * </br>
 * 3.让一个线程释放锁的方法有哪些？</br>
 * ⑴.线程执行完。 </br>
 * ⑵.{@link Object#wait()}。</br>
 * ⑶.抛出异常。</br>
 * </br>
 * 4.用synchronized实现一个死锁，写出代码。</br>
 * 代码：{@link #deadLock()}。</br>
 * </br>
 * 5.用synchronized实现三个线程交替打印10次ABC。</br>
 * 代码：{@link #testPrintABC()}。</br>
 * </br>
 * 6.用synchronized实现生产者消费者。</br>
 * 代码：{@link #producerConsumer()}。</br>
 * </br>
 * 7.什么是乐观锁，悲观锁？</br>
 * 乐观锁：</br>
 * 悲观锁：</br>
 */
public class SychronizedQ
{
    public static void main(String[] args)
    {
        // testPrintABC();
        // testProducerConsumer();
        releaseLock();
        // reenterLock();
    }

    public static void releaseLock()
    {
        Object object = new Object();
        new Thread(() ->
        {
            synchronized (object)
            {
                System.out.println("1");
                try
                {
                    object.wait(1000);
                } catch (Exception e)
                {}
                System.out.println("1");
            }
        }).start();

        new Thread(() ->
        {
            synchronized (object)
            {
                System.out.println("2");
            }
        }).start();
    }

    /**
     * 可重入锁。</br>
     */
    public static void reenterLock()
    {
        String s = "";
        new Thread(() ->
        {
            synchronized (s)
            {
                System.out.println("1");
            }
            synchronized (s)
            {
                System.out.println("2");
            }
        }).start();
    }

    public static void count()
    {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> sum = new ArrayList<>();
        Thread t1 = new Thread(() ->
        {
            for (int i = 0; i < 1000; i++)
                list1.add(0);
        });
        Thread t2 = new Thread(() ->
        {
            for (int i = 0; i < 1000; i++)
                list2.add(0);
        });
        t1.start();
        t2.start();
        while (true)
        {
            if (t1.getState().equals(Thread.State.TERMINATED) && t2.getState().equals(Thread.State.TERMINATED)) break;
        }
        Thread t3 = new Thread(() ->
        {
            for (Integer i : list1)
                sum.add(i);
            for (Integer i : list2)
                sum.add(i);
            System.out.println("总数量：" + sum.size());
        });
        t3.start();
    }

    /**
     * 用synchronized实现一个死锁。</br>
     */
    public static void deadLock()
    {
        Object left = new Object();
        Object right = new Object();
        new Thread(() ->
        {
            synchronized (left)
            {
                try
                {
                    Thread.sleep(2000);
                } catch (InterruptedException e)
                {}
                synchronized (right)
                {
                    System.out.println("leftRight end!");
                }
            }
        }).start();
        new Thread(() ->
        {
            synchronized (right)
            {
                try
                {
                    Thread.sleep(2000);
                } catch (InterruptedException e)
                {}
                synchronized (left)
                {
                    System.out.println("rightLeft end!");
                }
            }
        }).start();
    }

    /**
     * 用synchronized实现三个线程交替打印10次ABC。</br>
     */
    public static void testPrintABC()
    {
        PrintABC printABC = new PrintABC("C");
        new Thread(new PrintABCRun(printABC, "C", "A")).start();
        new Thread(new PrintABCRun(printABC, "A", "B")).start();
        new Thread(new PrintABCRun(printABC, "B", "C")).start();
    }

    private static class PrintABC
    {
        public String lastStr;

        public PrintABC(String s)
        {
            this.lastStr = s;
        }
    }

    private static class PrintABCRun implements Runnable
    {
        private PrintABC printABC;
        private String prev;
        private String cur;

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
                        {}
                    }
                    System.out.print(cur);// change last printed character
                    printABC.lastStr = cur;
                    printABC.notifyAll();// wrong if abc.notify()
                }
            }
        }
    }

    /**
     * 用synchronized实现生产者消费者。</br>
     */
    public static void producerConsumer()
    {
        Container container = new Container(5);// 定义箱子最大容量为5
        new Thread(new Producer(container)).start();// 箱子中的产品数要同步
        new Thread(new Consumer(container)).start();
    }

    private static class Container
    {
        public int max; // 容器最大容量
        public int current;// 容器当前容量

        public Container(int max)
        {
            this.max = max;
            this.current = 0;
        }
    }

    private static class Producer implements Runnable
    {
        public Container container;

        public Producer(Container c)
        {
            this.container = c;
        }

        public void run()
        {
            while (true)
            {
                synchronized (container)
                {
                    if (container.current < container.max)
                    {
                        container.current++;
                        System.out.println("生产1个, 总产品数：" + container.current);
                        container.notify();
                    } else if (container.current == container.max)
                    {
                        System.out.println("等待消费");
                        try
                        {
                            container.wait();
                        } catch (InterruptedException e)
                        {}
                    }
                }
                // synchronized 执行完同步块释放锁，
                // 输出结果中连续出现多次生产者是因为：释放锁后，若没有等待线程，则还是先执行到哪个线程的同步块就执行它
                try
                {
                    Thread.sleep(100);// 调节生产者频率，过快容易猝死
                } catch (InterruptedException e)
                {}
            }
        }
    }

    private static class Consumer implements Runnable
    {
        public Container container;

        public Consumer(Container c)
        {
            this.container = c;
        }

        public void run()
        {
            while (true)
            {
                synchronized (container)
                {
                    if (container.current > 0)
                    {
                        container.current--;
                        System.out.println("消费1个, 总产品数：" + container.current);
                        container.notify();
                    } else if (container.current == 0)
                    {
                        System.out.println("等待生产");
                        try
                        {
                            container.wait();
                        } catch (InterruptedException e)
                        {}
                    }
                }
                try
                {
                    Thread.sleep(500);// 调节消费者频率，过快容易撑死
                } catch (InterruptedException e)
                {}
            }
        }
    }
}
