package java_;

public class ExpressionQuestion
{
    public static void main(String[] args)
    {
        AddQuestion.test2();
    }

    // int a[] = { 1, 2, 3 };
    // int i = 0;
    // a[i] = a[++i];
    // System.out.println(a[0]);
    // System.out.println(a[1]);
    // System.out.println(a[2]);
}

/**
 * 1 .解释代码{@link AddQuestion#test1()}中的 {@code byte b = 0; b = b + 1; }为什么无法运行，
 * {@code float f = 0; f = (f + 1); }为什么又可以。<br>
 * 因为Java中加法运算的结果是int。<br>
 */
class AddQuestion
{
    public static void test1()
    {
        byte b = 0;
        b = (byte) (b + 1);
        // b = b + 1;
        float f = 0;
        f = (float) (f + 1);
        f = (f + 1);
        System.out.println(f);
    }

    public static void test2()
    {
        short s = 1;
        s += 1;
        byte b = 1;
        b += 1;
        System.out.println(s + b);
    }
}
