package java_.thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * ⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽</br>
 * 1.{@link FutureTask}和{@link Runnable}的区别？</br>
 * ⑴.{@link FutureTask}能获得返回值。</br>
 * ⑵.{@link FutureTask}能设置等待时间。</br>
 */
public class FutureTaskQ
{
    public static void main(String[] args)
    {
        test1();
    }

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
            Thread.sleep(1000);// 可能做一些事情
            System.out.println(future.get());
        } catch (InterruptedException e)
        {} catch (ExecutionException e)
        {}
    }
}
