package java_.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 *
 */
public class ConditionQ
{
    public static void main(String[] args)
    {
        // testAWait();
        // testASignal();
        testAWaitASignal();
    }

    public static void testAWait()
    {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        new Thread(() ->
        {
            lock.lock();
            try
            {
                System.out.print("await前，");
                condition.await();
                System.out.print("await后，");
            } catch (InterruptedException e)
            {
                System.out.print("await异常，");
            }
            lock.unlock();
        }).start();
    }

    public static void testASignal()
    {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        new Thread(() ->
        {
            lock.lock();
            System.out.print("signal前，");
            condition.signal();
            System.out.print("signal后，");
            lock.unlock();
        }).start();
    }

    public static void testAWaitASignal()
    {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        new Thread(() ->
        {
            lock.lock();
            try
            {
                System.out.println("thread1开始");
                condition.await();
                System.out.println("thread1重新开始");
            } catch (Exception e)
            {}
            lock.unlock();
        }).start();
        new Thread(() ->
        {
            lock.lock();
            try
            {
                System.out.println("thread2开始");
                condition.signal();
                System.out.println("thread2结束");
            } catch (Exception e)
            {}
            lock.unlock();
        }).start();
    }
}
