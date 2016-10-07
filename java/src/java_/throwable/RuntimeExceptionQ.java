package java_.throwable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

/**
 * 1.{@link RuntimeException}有哪些常见的子类？每种至少举一个例子说明出现的场景。 <br>
 * {@link NullPointerException}：空指针异常。例如：{@link #testNullPointerException()}<br>
 * {@link IndexOutOfBoundsException}：下标越界异常。例如： {@link #testIndexOutOfBoundsException()}<br>
 * {@link IllegalArgumentException}：非法参数异常。例如：{@link #testIllegalArgumentException()}。 <br>
 * {@link ClassCastException}：类转换异常。将类A强行转换成类B，但类B不是类A的子类也不是父类。例如： {@link #testClassCastException()}。<br>
 * {@link ArrayStoreException}：数组存储异常。例如：{@link #testArrayStoreException()}。<br>
 * {@link IllegalStateException}：非法状态异常。例如：使用{@link ListIterator}删除集合元素之前没有调用next或previous。<br>
 * {@link ArithmeticException}：算术异常。例如：除0。 <br>
 * {@link IllegalMonitorStateException}：线程在没有一个锁的情况去调用那个锁的{@link Object#wait()}，{@link Object#notify()}等方法。例如：
 * {@link #testIllegalMonitorStateException()}。<br>
 * {@link SecurityException}：安全异常。例如：包名不符合规范，为java。<br>
 * <br>
 */
public class RuntimeExceptionQ
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
        {}
    }
}
