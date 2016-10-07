package java_.class_;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * ⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽</br>
 * 1.Java中final有哪些用法？ <br>
 * a.修饰变量，表示不能改变。<br>
 * b.修饰方法，表示不能重写。<br>
 * b.修饰类，表示不能继承。<br>
 * <br>
 * 2.除了{@link String}外，Java中还有哪些类用final修饰？<br>
 * {@link Integer}，{@link Short}，{@link Long}，{@link Float}，{@link Double}，{@link Byte}，{@link Boolean}，
 * {@link Character}。<br>
 * {@link StringBuilder}。<br>
 * <br>
 * 3.为什么{@link BigInteger}和{@link BigDecimal}没有用final修饰？<br>
 * 历史原因。<br>
 * <br>
 * 4.定义一个类{@link java_.class_.Constants}专门存放常量，在其中定义一个int常量TRUE，值为1，再定义一个类 {@link java_.class_.ConstantsTest}
 * 演示如何使用。写出代码。 <br>
 */
@SuppressWarnings("unused")
public class FinalQ
{

    public static void main(String[] args)
    {
        // testLocalVariables();
    }

    private static void testArgument(final int i)
    {
        // i=1; //错误
    }

    private static void testLocalVariable()
    {
        final int i;
        i = 2;
        System.out.println(i);
    }
}