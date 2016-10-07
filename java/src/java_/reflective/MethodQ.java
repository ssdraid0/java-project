package java_.reflective;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽<br>
 * 1.通过反射找到{@link Class2}类中修饰符包括public和final，返回类型为void，名为wait，有两个参数：int和long，抛出一个{@link InterruptedException}
 * 异常的方法。<br>
 * 代码：{@link #test1()}。<br>
 * <br>
 * 2.通过反射调用{@link ArrayList}的{@link ArrayList#add(Object)}方法给一个list添加元素。<br>
 * 代码：{@link #testInvoke()}。<br>
 * <br>
 */
public class MethodQ
{
    public static void main(String[] args)
    {}

    public static void test1()
    {
        Method[] methods = Class2.class.getMethods();
        for (Method method : methods)
        {
            if (method.getName().equals("wait") && Modifier.isPublic(method.getModifiers())
                    && Modifier.isFinal(method.getModifiers()) && method.getReturnType() == void.class
                    && method.getParameters().length == 2 && method.getExceptionTypes().length == 1)
            {
                List<Class<?>> parameters = Arrays.asList(method.getParameterTypes());
                List<Class<?>> exceptions = Arrays.asList(method.getExceptionTypes());
                if (parameters.contains(long.class) && parameters.contains(int.class)
                        && exceptions.contains(InterruptedException.class))
                {
                    System.out.println(method);
                }
            }
        }
    }

    public static void testInvoke()
    {
        try
        {
            List<Integer> list = new ArrayList<>();
            Method method = List.class.getMethod("add", Object.class);
            method.invoke(list, 1);
            System.out.println(list.size());
        } catch (Exception e)
        {}
    }

    public static void test3()
    {
        try
        {
            Class2.class.getMethod("wait", long.class, int.class);
        } catch (NoSuchMethodException | SecurityException e)
        {
            e.printStackTrace();
        }
    }

    static class Class1
    {}

    static class Class2 extends Class1
    {}
}
