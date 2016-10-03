package java_;

/**
 * ⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽<br>
 * 1.{@link String}和{@link StringBuilder}的区别？<br>
 * ⑴.{@link String}实际存储字符串的char数组是final不能改变的，{@link StringBuilder}不是。<br>
 * ⑵.{@link String}线程安全。<br>
 * 2.{@link String#equals(Object)}是如何比较字符串？<br>
 * ⑴.先比较引用，引用相同返回true。 </br>
 * ⑵.再判断Object对象是否为String类型，不是返回false。 </br>
 * ⑶.再判断长度是否相同，不相同返回false。 </br>
 * ⑷.再从头开始比较每个字符。 </br>
 * 3.{@link String#intern()}的作用是什么？<br>
 * 如果常量池已经包含一个等于此 String 对象的字符串（由 equals(Object) 方法确定），<br>
 * 则返回常量池中的字符串。否则，将此 String 对象添加到常量池中，并且返回此 String 对象的引用。<br>
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