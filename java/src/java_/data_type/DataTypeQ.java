package java_.data_type;

import java.util.HashSet;
import java.util.Set;

/**
 * ⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽</br>
 * 1.Java的基本数据类型有哪些？ </br>
 * byte，int，short，long，float，double，char，boolean。</br>
 * </br>
 * 2.Java的基本数据类型的默认值是多少？ </br>
 * int，short，long，byte：0</br>
 * float，double：0.0</br>
 * char：''</br>
 * boolean：false</br>
 * </br>
 * 3.Java的基本数据类型在什么情况下不需要赋值就能使用？</br>
 * 作为成员变量时。</br>
 * </br>
 * 4.Java的基本数据类型的位数和值范围？<</br>
 * byte：8位，-2^7到2^7-1，包括边界。</br>
 * short：16位，-2^15到2^15-1。</br>
 * int：32位，-2^31到2^31-1。</br>
 * long：64位，-2^64到2^64-1。</br>
 * char：无符号16位，0-2^16-1。</br>
 * </br>
 * 5.Java的基本数据类型转换规则是怎么样的？</br>
 * byte，short，int，long，float，double。</br>
 * 左边到右边，可以直接赋值。右边到左边，需要强制转换。</br>
 * </br>
 * 6.Java中{@link Byte}，{@link Short}，{@link Integer}，{@link Long}的缓存范围是多少？</br>
 * -128到127。 </br>
 * </br>
 * 7.Java中类型为double的字面量（Literal）有哪些？如何把它们转换为float类型？</br>
 * 1.0，+1.0，-1.0，1e1，-1e-1，-1.0e-1。</br>
 * 在前面加(float)，或者在后面加f或F。</br>
 */
public class DataTypeQ
{
    public static void main(String[] args)
    {
        // DataTypeQuestion question = new DataTypeQuestion();
        // question.test1();
        // LongQuestion.test1();
        // ShortQuestion.test1();
        
        float f1 = 1.0f, f2 = 1e1f, f3 = 1e+1f, f4 = +1e+1f, f5 = -1e-1f, f6 = -1.0e-1f;
        System.out.println(f1 + "   " + f2 + "   " + f3 + "   " + f4 + "   " + f5 + "   " + f6 + "   ");
        double d1 = 0, d2 = 1e1f, d3 = 1e+1f, d4 = +1e+1f, d5 = -1e-1f, d6 = -1.0e-1f;
        System.out.println(d1 + "   " + d2 + "   " + d3 + "   " + d4 + "   " + d5 + "   " + d6 + "   ");
    }

    int i;
    short s;
    long l;
    byte b;
    float f;
    double d;
    char c;
    boolean bool;

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
 * 1.{@link Character}判断是否是数字，是否是字母，是否是大写字母，是否是小写字母的方法是什么？</br>
 * {@link Character#isDigit(char)}，{@link Character#isLetter(char)}， {@link Character#isUpperCase(char)}，
 * {@link Character#isLowerCase(char)}。</br>
 */
class CharacterQuestion
{

}

/**
 */
class ShortQuestion
{
    public static void test1()
    {
        Set<Short> set = new HashSet<>();
        for (Short i = 0; i < 1024; i++)
        {
            set.add(i);
            set.remove(i - 1);
        }
        System.out.print(set.size());
    }
}

/**
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
