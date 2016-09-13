package keyword.class_p;

public class HideTest
{
    @SuppressWarnings("static-access")
    public static void main(String[] args)
    {
        A a = new B();
        a.println();
    }

    static class A
    {
        public static void println()
        {
            System.out.println("A");
        }
    }

    static class B extends A
    {
        public static void println()
        {
            System.out.println("B");
        }
    }
    
    static class C extends A
    {
//        public static String println()
//        {
//            System.out.println("C");
//            return "C";
//        }
    }
}
