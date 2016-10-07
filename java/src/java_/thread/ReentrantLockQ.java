package java_.thread;

import java.util.Calendar;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽</br>
 * 1.{@link ReentrantLock}和synchronized的区别是什么？<br>
 * a.{@link ReentrantLock}通过{@link ReentrantLock#lock()}方法获取锁，通过{@link ReentrantLock#unlock()}
 * 方法释放锁，比synchronized灵活。<br>
 * b.{@link ReentrantLock}能通过{@link ReentrantLock#tryLock()}方法的返回值判断锁是否获取成功。<br>
 */
public class ReentrantLockQ
{

    public static void main(String[] args)
    {
        test1();
//        ReentrantLockQ tester = new ReentrantLockQ();
//    
//        // 1、测试可重入
//        tester.testReentry();
//        tester.testReentry(); // 能执行到这里而不阻塞，表示锁可重入
//        tester.testReentry(); // 再次重入
//    
//        // 释放重入测试的锁，要按重入的数量解锁，否则其他线程无法获取该锁。
//        tester.getLock().unlock();
//        tester.getLock().unlock();
//        tester.getLock().unlock();
//    
//        // 2、测试互斥
//        // 启动3个线程测试在锁保护下的共享数据data的访问
//        new Thread(new workerThread(tester)).start();
//        new Thread(new workerThread(tester)).start();
//        new Thread(new workerThread(tester)).start();
    }

    public static void test1()
    {
        ReentrantLock lock = new ReentrantLock();
        new Thread(() ->
        {
            lock.lock();
            for (int i = 0; i < 100; i++)
            {
                System.out.print("1,");
            }
            lock.unlock();
        }).start();
        new Thread(() ->
        {
            lock.lock();
            for (int i = 0; i < 100; i++)
            {
                System.out.print("2,");
            }
            lock.unlock();
        }).start();
    }

    private ReentrantLock lock = null;

    public int data = 100;     // 用于线程同步访问的共享数据

    public ReentrantLockQ()
    {
        lock = new ReentrantLock(); // 创建一个自由竞争的可重入锁
    }

    public ReentrantLock getLock()
    {
        return lock;
    }

    public void testReentry()
    {
        lock.lock();
        Calendar now = Calendar.getInstance();
        System.out.println(now.getTime() + " " + Thread.currentThread() + " get lock.");
    }

    // 线程调用的方法
    public void testRun() throws Exception
    {
        lock.lock();
        Calendar now = Calendar.getInstance();
        try
        {
            // 获取锁后显示 当前时间 当前调用线程 共享数据的值（并使共享数据 + 1）
            System.out.println(now.getTime() + " " + Thread.currentThread() + " accesses the data " + data++);
            Thread.sleep(1000);
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            lock.unlock();
        }
    }

    // 工作线程，调用TestServer.testRun
    static class workerThread implements Runnable
    {
        private ReentrantLockQ tester = null;

        public workerThread(ReentrantLockQ testLock)
        {
            this.tester = testLock;
        }

        public void run()
        {
            try
            {
                tester.testRun();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
