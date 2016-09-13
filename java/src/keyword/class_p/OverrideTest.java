package keyword.class_p;

public class OverrideTest
{
    public static void main(String[] args)
    {
        A a1 = new A();
        A a2 = new B();
        A a3 = new C();
        a1.println();
        a2.println();
        a3.println();
    }

    static class A
    {
        public Object println()
        {
            System.out.println("A");
            return new Object();
        }
    }

    static class B extends A
    {
        public Object println()
        {
            System.out.println("B");
            return new Object();

        }
    }
    static class C extends A
    {
        public String println()
        {
            System.out.println("C");
            return new String();
        }
    }
}
