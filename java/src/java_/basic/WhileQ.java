package java_.basic;

/**
 * 1.下面代码的输出结果是什么？<br/>
 * 
 * <pre>
 * int a = 0;
 * do
 * {
 *     a--;
 * } while (a > 0);
 * System.out.println(a);
 * </pre>
 * 
 * -1<br/>
 */
public class WhileQ
{
    public static void main(String[] args)
    {

    }

    public static void doWhile()
    {
        int a = 0;
        do
        {
            a--;
        } while (a > 0);
        System.out.println(a);
    }
}
