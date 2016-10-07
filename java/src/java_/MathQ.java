package java_;

/**
 * 1.下面代码的结果是什么？</br>
 * 
 * <pre>
 * System.out.print(Math.round(-1.5) + "，");
 * System.out.print(Math.round(1.2) + "，");
 * System.out.print(Math.round(1.5) + "，");
 * </pre>
 * 
 *  -1，1，2，</br>
 */
public class MathQ
{
    public static void main(String[] args)
    {
        testRound();
    }

    public static void testRound()
    {
        System.out.print(Math.round(-1.5) + "，");
        System.out.print(Math.round(1.2) + "，");
        System.out.print(Math.round(1.5) + "，");
    }
}
