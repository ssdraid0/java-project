package java_.thread;

/**
 * 1.写出下面代码{@link #testWait()}的运行结果。</br>
 * 
 * <pre>
 * public static void testWait()
 * {
 *     String s = "";
 *     new Thread(() ->
 *     {
 *         synchronized (s)
 *         {
 *             try
 *             {
 *                 System.out.print("wait前，");
 *                 s.wait();
 *                 System.out.print("wait后，");
 *             } catch (InterruptedException e)
 *             {
 *                 System.out.print("wait异常，");
 *             }
 *         }
 *     }).start();
 * }
 * </pre>
 * 
 * 运行结果：wait前</br>
 * 2.写出下面代码{@link #testNotify()}的运行结果。</br>
 * 
 * <pre>
 * public static void testNotify()
 * {
 *     String s = "";
 *     new Thread(() ->
 *     {
 *         synchronized (s)
 *         {
 *             System.out.print("notify前，");
 *             s.notify();
 *             System.out.print("notify后，");
 *         }
 *     }).start();
 * }
 * </pre>
 * 
 * 运行结果：notify前，notify后，</br>
 * </br>
 */
public class WaitNotifyQ
{
    public static void main(String[] args)
    {
        // testWait();
        testNotify();
    }

    public static void testWait()
    {
        String s = "";
        new Thread(() ->
        {
            synchronized (s)
            {
                System.out.print("获取了锁，");
                try
                {
                    System.out.print("wait前，");
                    s.wait();
                    System.out.print("wait后，");
                } catch (InterruptedException e)
                {
                    System.out.print("wait异常，");
                }
            }
        }).start();
    }

    public static void testNotify()
    {
        String s = "";
        new Thread(() ->
        {
            synchronized (s)
            {
                System.out.print("获取了锁，");
                System.out.print("notify前，");
                // s.notify();
                System.out.print("notify后，");
                s.notify();
            }
        }).start();
    }

    public static void testWaitNotify()
    {

    }

    static class WaitSleep
    {

        public static void testWait1()
        {
            Thread thread = new Thread(() ->
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
            });
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

        public static String s = "";

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
