package java_;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

/**
 * 1.Java的{@link Exception}和{@link Error}的层次结构？<br>
 * 首先有一个{@link Throwable}类，实现了{@link Serializable}接口。 <br>
 * 然后{@link Throwable}类有两个子类{@link Error}和{@link Exception} 。 <br>
 * 其中{@link Error}有四个子类：{@link AssertionError}， {@link LinkageError}， {@link ThreadDeath}，
 * {@link VirtualMachineError}。<br>
 * {@link Exception}也有四个子类：{@link CloneNotSupportedException}， {@link InterruptedException}，
 * {@link ReflectiveOperationException}， {@link RuntimeException}。<br>
 */
public class ThrowableQuestion
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

/**
 * .有哪些情况finally里的代码不会执行？<br>
 */
class TryCatchFinallyQuestion
{

}

/**
 * 1.{@link RuntimeException}有哪些常见的子类？每种至少举一个例子说明出现的场景。 <br>
 * {@link NullPointerException}：空指针异常。例如：{@link RuntimeExceptionQuestion#testNullPointerException()}<br>
 * {@link IndexOutOfBoundsException}：下标越界异常。例如：
 * {@link RuntimeExceptionQuestion#testIndexOutOfBoundsException()}<br>
 * {@link IllegalArgumentException}：非法参数异常。例如：{@link RuntimeExceptionQuestion#testIllegalArgumentException()}。
 * <br>
 * {@link ClassCastException}：类转换异常。将类A强行转换成类B，但类B不是类A的子类也不是父类。例如：
 * {@link RuntimeExceptionQuestion#testClassCastException()}。<br>
 * {@link ArrayStoreException}：数组存储异常。例如：{@link RuntimeExceptionQuestion#testArrayStoreException()}。<br>
 * {@link IllegalStateException}：非法状态异常。例如：使用{@link ListIterator}删除集合元素之前没有调用next或previous。<br>
 * {@link ArithmeticException}：算术异常。例如：除0。 <br>
 * {@link IllegalMonitorStateException}：线程在没有一个锁的情况去调用那个锁的{@link Object#wait()}，{@link Object#notify()}等方法。例如：
 * {@link RuntimeExceptionQuestion#testIllegalMonitorStateException()}。<br>
 * {@link SecurityException}：安全异常。例如：包名不符合规范，为java。<br>
 * <br>
 */
class RuntimeExceptionQuestion
{
    @SuppressWarnings("null")
    public static void testNullPointerException()
    {
        String string = null;
        string.length();
    }

    public static void testIndexOutOfBoundsException()
    {
        int[] a = new int[1];
        a[1] = 0; // ArrayIndexOutOfBoundsException
        List<Integer> list = new ArrayList<>(1);
        list.get(1); // IndexOutOfBoundsException
    }

    public static void testIllegalArgumentException()
    {
        List<Integer> list = new ArrayList<>(-1);
        list.size();
        Set<Integer> set = new HashSet<>(-1);
        set.size();
        Map<Integer, Integer> map = new HashMap<>(-1);
        map.size();
    }

    public static void testArithmeticException()
    {
        int i = 1 / 0;
        System.out.println(i);
    }

    public static void testIllegalStateException()
    {
        List<Integer> list = new ArrayList<>(2);
        list.add(1);
        list.add(2);
        ListIterator<Integer> listIterator = list.listIterator();
        listIterator.next();
        listIterator.remove();
        listIterator.next();
        listIterator.remove();

        // Set<Integer> set = new HashSet<>(2);
        // set.add(1);
        // set.add(2);
    }

    public static void testClassCastException()
    {
        Object x = new Integer(0);
        System.out.println((String) x);
        List<Integer> list = new ArrayList<>();
        System.out.println((LinkedList<Integer>) list);

    }

    public static void testArrayStoreException()
    {
        Object[] objects = new Integer[1];
        objects[0] = "string";
    }

    public static void testIllegalMonitorStateException()
    {
        Object object = new Object();
        try
        {
            object.wait();
        } catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
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
        Thread t = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
            }
        });
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
