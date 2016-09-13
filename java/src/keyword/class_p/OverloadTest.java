package keyword.class_p;

public class OverloadTest
{
    public static void main(String[] args)
    {
        B a = new B();
        a.println(new String());
        a.println(new Object());
        a.println(1);
    }
    public static class A
    {
        public void println(String s)
        {
            System.out.println("A");
        }
    }

     static class B extends A
    {
        public void println(Object o)
        {
            System.out.println("B");
        }
        
        public void println(int i)
        {
            System.out.println("int");
        }
    }
}

