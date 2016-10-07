package java_.throwable;

import java.io.Serializable;

/**
 * 1.{@link Exception}和{@link Error}的层次结构？<br>
 * 首先有一个{@link Throwable}类，实现了{@link Serializable}接口。 </br>
 * 然后{@link Throwable}类有两个子类{@link Error}和{@link Exception} 。 </br>
 * 其中{@link Error}有四个子类：{@link AssertionError}， {@link LinkageError}， {@link ThreadDeath}，
 * {@link VirtualMachineError}。</br>
 * {@link Exception}也有四个子类：{@link CloneNotSupportedException}， {@link InterruptedException}，
 * {@link ReflectiveOperationException}， {@link RuntimeException}。</br>
 * 2.哪些是检查型异常（Checked Exception），哪些非检查型异常（Unchecked Exception）？</br>
 * 继承{@link RuntimeException}的都是非检查型异常，继承{@link Exception}的都是检查型异常。</br>
 * </br>
 */
public class ThrowableQ
{
    public static void main(String[] args)
    {
        // VirtualMachineErrorQuestion.testOutOfMemoryError();
        // VirtualMachineErrorQuestion.testStackOverflowError();
        // RuntimeExceptionQuestion.testIllegalMonitorStateException();
        // IllegalArgumentExceptionQuestion.testNumberFormatException1();
        ReflectiveOperationExceptionQuestion.testNoSuchFieldException1();
    }
}

class RuntimeExceptionQuestion
{

}

/**
 * 1.{@link OutOfMemoryError}和{@link StackOverflowError}遇到过哪些情况？<br>
 * {@link OutOfMemoryError}：{@link VirtualMachineErrorQuestion#testOutOfMemoryError1()}。<br>
 * {@link StackOverflowError}：{@link VirtualMachineErrorQuestion#testStackOverflowError1()}。<br>
 */
class VirtualMachineErrorQuestion
{

    public static void testOutOfMemoryError1()
    {
        int[] i = new int[Integer.MAX_VALUE];
        System.out.println(i.length);
    }

    public static void testStackOverflowError1()
    {
        testStackOverflowError1();
    }
}

/**
 * 1.{@link IllegalArgumentException}有哪些子类？每种至少举一个例子说明出现的场景。 <br>
 * {@link IllegalThreadStateException}：非法线程状态异常。例如：
 * {@link IllegalArgumentExceptionQuestion#testIllegalThreadStateException1()}。<br>
 * {@link NumberFormatException}：数字转换异常。例如：
 * {@link IllegalArgumentExceptionQuestion#testNumberFormatException1()}。<br>
 * <br>
 * 2. <br>
 */
class IllegalArgumentExceptionQuestion
{
    public static void testIllegalThreadStateException1()
    {
        Thread t = new Thread(() ->
        {});
        t.start();
        t.start();
    }

    public static void testNumberFormatException1()
    {
        Integer.parseInt("a");
    }
}

/**
 * 1.{@link ReflectiveOperationException}有哪些子类？每种至少举一个例子说明出现的场景。 <br>
 * {@link ClassNotFoundException}：类找不到。例如：
 * {@link ReflectiveOperationExceptionQuestion#testClassNotFoundException1()}。<br>
 * {@link NoSuchFieldException}：类没有这种属性。例如：
 * {@link ReflectiveOperationExceptionQuestion#testNoSuchFieldException1()}。<br>
 * {@link IllegalAccessException}：
 */
class ReflectiveOperationExceptionQuestion
{
    public static void testClassNotFoundException1()
    {
        try
        {
            System.out.println(Class.forName("java.lang.ClassAndClass").toString());
        } catch (ClassNotFoundException e)
        {
            System.out.println("异常:" + e.getMessage());
        }
    }

    public static void testNoSuchFieldException1()
    {
        try
        {
            System.out.println(int.class.getDeclaredField("i"));
        } catch (NoSuchFieldException e)
        {
            System.out.println("异常：" + e.getMessage());
        } catch (SecurityException e)
        {
            System.out.println("异常：" + e.getMessage());
        }
    }
}
