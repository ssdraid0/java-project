package java_;

/**
 * 1.Java的基本数据类型有哪些？ <br>
 * int，short，long，float，double，byte，char，boolean。<br>
 * <br>
 * 2.Java的基本数据类型的默认值是多少？ <br>
 * int，short，long，byte：0<br>
 * float，double：0.0<br>
 * char：''<br>
 * boolean：false<br>
 * <br>
 * 3.Java的基本数据类型在什么情况下不需要赋值就能使用？<br>
 * 作为成员变量时。<br>
 * <br>
 * 4.Java的基本数据类型的位数和值范围？<<br>
 * byte：8位，-2^7到2^7-1，包括边界。<br>
 * short：16位，-2^15到2^15-1。<br>
 * int：32位，-2^31到2^31-1。<br>
 * 0 long：64位，-2^64到2^64-1。<br>
 * char：无符号16位，0-2^16-1。<br>
 * <br>
 * 5.Java的基本数据类型转换规则是怎么样的？<br>
 * byte，short，int，long，float，double。<br>
 * 左边转换右边，可以直接赋值。右边转换左边，需要强制转换。<br>
 * <br>
 * 6.Java中{@link Byte}，{@link Short}，{@link Integer}，{@link Long}的缓存范围是多少？<br>
 * -128到127。 <br>
 * <br>
 */
public class DataTypeQuestion
{
    int i;
    short s;
    long l;
    byte b;
    float f;
    double d;
    char c;
    boolean bool;

    public static void main(String[] args)
    {
        // DataTypeQuestion question = new DataTypeQuestion();
        // question.test1();
        LongQuestion.test1();
    }

    public void test1()
    {
        System.out.println(i);
        System.out.println(s);
        System.out.println(l);
        System.out.println(b);
        System.out.println(f);
        System.out.println(d);
        System.out.println(c);
        System.out.println(bool);
    }

    public static void test2()
    {
        byte b = 0;
        short s = 1;
        int i = 2;
        long l = 3;
        float f = 4;
        double d = 5;
        System.out.println(i);
        System.out.println(s);
        System.out.println(l);
        System.out.println(b);
        System.out.println(f);
        System.out.println(d);
    }
}

/**
 * 1.{@link Character}判断是否是数字，是否是字母，是否是大写字母，是否是小写字母的方法是什么？<br>
 * {@link Character#isDigit(char)}，{@link Character#isLetter(char)}， {@link Character#isUpperCase(char)}，
 * {@link Character#isLowerCase(char)}。<br>
 */
class CharacterQuestion
{

}

/**
 * 
 */
class LongQuestion
{
    public static void test1()
    {
        Long a = -128L;
        Long b = -128L;
        System.out.println(a == b);
        Long c = -129L;
        Long d = -129L;
        System.out.println(c == d);
        Long e = new Long(-128L);
        Long f = new Long(-128L);
        System.out.println(e == f);
        System.out.println(Long.valueOf(-129) == Long.valueOf(-129));
        System.out.println(Long.valueOf(-128) == Long.valueOf(-128));
        System.out.println(Long.valueOf(127) == Long.valueOf(127));
        System.out.println(Long.valueOf(128) == Long.valueOf(128));
    }
}
