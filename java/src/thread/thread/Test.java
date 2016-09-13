package thread.thread;

public class Test
{

    public static void main(String[] args)
    {
        MyThread mt1 = new MyThread("线程a");
        MyThread mt2 = new MyThread("线程b");
        mt1.start();
        mt1.start();
        // mt2.start();
    }

}
