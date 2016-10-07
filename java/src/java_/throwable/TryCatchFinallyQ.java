package java_.throwable;

/**
 * ⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽<br>
 * 1.什么情况下finally里的代码不会执行？</br>
 * System.exit(0);</br>
 * </br>
 * 2.如果try，catch，finally中都出现了return，return的执行顺序？</br>
 * try->try中return->catch->catch中return->finally->finally中return。</br>
 * {@link #tryWithoutException()}，{@link #tryExceptionBefore()}，{@link #tryExceptionIn()}。</br>
 */
@SuppressWarnings("finally")
public class TryCatchFinallyQ
{
    public static void main(String[] args)
    {
        tryWithoutException();
        // System.out.println(tryExceptionIn());
        // tryExceptionBefore();
        // finallyNotRun();
    }

    /**
     * try中没有异常。
     */
    public static int tryWithoutException()
    {
        int j = 0;
        try
        {
            System.out.println(j);
            return j = j + 1;
        } catch (Exception e)
        {
            System.out.println("catch");
            System.out.println(j);
            return j = j + 2;
        } finally
        {
            System.out.println("finally");
            System.out.println(j);
            return j = j + 3;
        }
    }

    /**
     * try中return前有异常。
     */
    public static int tryExceptionBefore()
    {
        int j = 0;
        try
        {
            @SuppressWarnings("unused")
            int i = 1 / 0;
            System.out.println(j);
            return j = j + 1;
        } catch (Exception e)
        {
            System.out.println("catch");
            System.out.println(j);
            return j = j + 2;
        } finally
        {
            System.out.println("finally");
            System.out.println(j);
            return j = j + 3;
        }
    }

    /**
     * try中return中有异常。
     */
    public static int tryExceptionIn()
    {
        int j = 0;
        try
        {
            return ++j / 0;
        } catch (Exception e)
        {
            System.out.println("catch");
            return ++j;
        } finally
        {
            System.out.println("finally");
            return ++j;
        }
    }

    public static void finallyNotRun()
    {
        try
        {
            throw new Exception();
        } catch (Exception e)
        {
            System.out.println("catch");
            System.exit(0);
            return;
        } finally
        {
            System.out.println("finally");
        }
    }
}
