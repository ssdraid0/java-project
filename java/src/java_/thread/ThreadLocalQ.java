package java_.thread;

/**
 * 1.{@link ThreadLocal}的作用是什么？<br/>
 * 为每一个线程提供一个独立的变量副本，避免了多线程访问冲突。<br/>
 * 因为每一个线程都拥有自己的变量副本，从而也就没有必要对该变量进行同步了。<br/>
 * http://qifuguang.me/2015/09/02/[Java并发包学习七]解密ThreadLocal/<br/>
 * <br/>
 * 2.{@link ThreadLocal}是如何实现的？<br/>
 */
public class ThreadLocalQ
{
    public static void main(String[] args)
    {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        threadLocal.set(1);
        new Thread(() ->
        {
            for (int i = 0; i < 3; i++)
            {
                System.out.println(threadLocal.get());
                threadLocal.set(i);
            }
        }).start();
        new Thread(() ->
        {
            for (int i = 0; i < 3; i++)
            {
                System.out.println(threadLocal.get());
                threadLocal.set(i);
            }
        }).start();
    }

}
