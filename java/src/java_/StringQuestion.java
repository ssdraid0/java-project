package java_;

/**
 * 1.{@link String}和{@link StringBuilder}的区别？<br>
 * a.{@link String}实际存储字符串的char数组是final不能改变的，{@link StringBuilder}不是。<br>
 * b.{@link String}线程安全。<br>
 * 
 */
public class StringQuestion
{
    public static void main(String[] args)
    {
        test1();
    }

    public static void test1()
    {
        String s1 = new String("a");
        String s2 = new String("a");
        String s3 = "a";
        String s4 = String.valueOf("a");

        System.out.println(s1 == s2); // false
        System.out.println(s1 == s3);// false
        System.out.println(s1 == s4);// false
        System.out.println(s3 == s4);// true
    }

    public static void test2()
    {
        final String a = "hello";
        String b = a + "world";

        String c = "hello";
        String d = c + "world";

        final String e = getHello();
        String f = e + "world";

        System.out.println(("helloworld" == b)); // true
        System.out.println(("helloworld" == d)); // false
        System.out.println(("helloworld" == f)); // false
    }

    public static String getHello()
    {
        return "Hello";
    }
}

/**
 * 1.{@link StringBuilder}的默认容量是多少？<br>
 * 默认容量是16。<br>
 */
class StringBuilderQuestion
{

}