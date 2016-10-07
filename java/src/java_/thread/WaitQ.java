package java_.thread;

/**
 * ⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽</br>
 * 1.{@link Thread#sleep(long)}和{@link Object#wait()}的区别？</br>
 * ⑴.调用{@link Thread#sleep(long)}后线程进入定时等待状态({@link Thread.State#TIMED_WAITING})。调用{@link Object#wait()}
 * 后线程进入等待状态( {@link Thread.State#WAITING})。调用{@link Object#wait(long)}后线程也进入定时等待状态(
 * {@link Thread.State#TIMED_WAITING})。</br>
 * ⑵.{@link Thread#sleep(long)}不会释放锁，{@link Object#wait()}会释放锁。</br>
 * ⑶.{@link Thread#sleep(long)}阻塞一段时间后自动唤醒，</br>
 * {@link Object#wait()}需要别的线程调用{@link Object#notify()}或{@link Object#notifyAll()}唤醒。</br>
 * {@link Object#wait(long)}如何在规定时间内没有被别的线程唤醒就会自动唤醒。</br>
 * </br>
 */
public class WaitQ
{
    public static void main(String[] args)
    {
        testWait();
    }

    public static void testSleep()
    {
        Thread thread = new Thread(() ->
        {
            try
            {
                Thread.sleep(100);
            } catch (InterruptedException e)
            {
                System.out.println(e.getMessage());
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

    public static void testWait()
    {
        String s = "";
        new Thread(() ->
        {
            synchronized (s)
            {
                try
                {
                    System.out.println("wait前");
                    s.wait(1000);
                    System.out.println("wait后");
                } catch (Exception e)
                {}
            }
        }).start();
    }
}
