package java_;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1.{@link Class}类的{@link Class#getFields()}方法和{@link Class#getDeclaredFields()}方法的区别？<br>
 * {@link Class#getMethods()}方法和{@link Class#getDeclaredMethods()}方法的区别？<br>
 * {@link Class#getConstructors()}方法和{@link Class#getDeclaredConstructors()}方法的区别？<br>
 * <br>
 * {@link Class#getFields()}方法：获取类或接口的public属性，包括继承的public属性。<br>
 * {@link Class#getDeclaredFields()}方法：获取类或接口的public，protected，private属性，不包括继承的属性。<br>
 * <br>
 * {@link Class#getMethods()}方法：获取类或接口的public方法，包括继承的public方法。<br>
 * {@link Class#getDeclaredMethods()}方法：获取类或接口的public，protected，default，private方法，不包括继承的方法。<br>
 * <br>
 * {@link Class#getConstructors()}方法：获取类的public构造器，包括继承的public构造器。<br>
 * {@link Class#getDeclaredConstructors()}方法：获取类的public，protected，default，private构造器，不包括继承的构造器。<br>
 * <br>
 * 2.{@link Field}类的{@link Field#toGenericString()}方法和{@link Field#toString()}方法的区别？<br>
 * {@link Method}类的{@link Method#toGenericString()}方法和{@link Method#toString()}方法的区别？<br>
 * {@link Constructor}类的{@link Constructor#toGenericString()}方法和{@link Constructor#toString()}方法的区别？<br>
 * {@link Field#toGenericString()}方法，{@link Method#toGenericString()}方法，{@link Constructor#toGenericString()}
 * 方法能打印出泛型。<br>
 * <br>
 */
public class ReflectiveQuestion
{
    public static void main(String[] args)
    {
        // ClassNameQuestion.test1();
        // MethodQuestion.testMethod2();
        // ConstructorQuestion.test1();
        ClassNameQuestion.test2();
    }
}

class ClassNameQuestion
{
    @SuppressWarnings("unchecked")
    public static void test1()
    {
        try
        {
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = list1.getClass().newInstance();
            list2.add(0);
            System.out.println(list2.size());
        } catch (InstantiationException | IllegalAccessException e)
        {
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static void test2()
    {
        List<Integer> list = new ArrayList<>();
        Constructor<?>[] constructors = list.getClass().getConstructors();
        try
        {
            for (Constructor<?> constructor : constructors)
            {
                if (constructor.getParameterTypes().length == 1 && constructor.getParameterTypes()[0] == int.class)
                {
                    List<Integer> list1 = (List<Integer>) constructor.newInstance(10);
                    list1.add(0);
                    System.out.println(list1.size());
                }
            }
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e)
        {
            e.printStackTrace();
        }
    }
}

/**
 * 2.对基本数据类型，数组，{@link Void}，void调用{@link Class#getDeclaredFields()}方法或{@link Class#getFields()}方法结果是多少？<br>
 * 基本数据类型，数组，void：都是0。<br>
 * {@link Void}：都是1。<br>
 * 测试代码：{@link FieldQuestion#testVoidvoidPrimitiveType()}。<br>
 * <br>
 * 3.有一个类{@link FieldQuestion.Class}，如何使用反射判断每个属性有哪些修饰符？如何找出修饰符为private static的属性？<br>
 * 代码：{@link FieldQuestion#testModifier()}。<br>
 * <br>
 * 4.有一个类{@link FieldQuestion.Class}，如何使用反射修改属性string1的值？<br>
 * 代码：{@link FieldQuestion#testValue()}。<br>
 * <br>
 */
class FieldQuestion
{
    static class Class1
    {
        private String string1;
        public String string2;
    }

    static class Class2 extends Class1
    {
        @SuppressWarnings("unused")
        private short s1;
        @SuppressWarnings("unused")
        private static short s2;
        public int i1;
        public int i2;
    }

    public static void testClassAndInterface()
    {
        System.out.println(Class2.class.getFields().length);
        System.out.println(Class2.class.getDeclaredFields().length);
        System.out.println(Interface2.class.getFields().length);
        System.out.println(Interface2.class.getDeclaredFields().length);
    }

    public static void testVoidvoidPrimitiveType()
    {
        System.out.println(Void.class.getFields().length);
        System.out.println(Void.class.getDeclaredFields().length);
        System.out.println(void.class.getFields().length);
        System.out.println(void.class.getDeclaredFields().length);
        System.out.println(int.class.getFields().length);
        System.out.println(int.class.getDeclaredFields().length);
    }

    public static void testModifier()
    {
        Field[] fields = Class2.class.getDeclaredFields();
        for (int i = 0; i < fields.length; i++)
        {
            int modifiers = fields[i].getModifiers();
            System.out.println(Modifier.toString(modifiers));
        }
        for (int i = 0; i < fields.length; i++)
        {
            int modifiers = fields[i].getModifiers();
            if (Modifier.isPrivate(modifiers) && Modifier.isStatic(modifiers))
            {
                System.out.println(fields[i].getName());
            }
        }
    }

    public static void testValue()
    {
        try
        {
            Class1 class1 = new Class1();
            Field field = Class1.class.getDeclaredField("string1");
            field.set(class1, "abc");
            System.out.println(class1.string1);
        } catch (Exception e)
        {
            System.out.println("异常：" + e.getMessage());
        }
    }

    static interface Interface1
    {
        int i1 = 0;
    }

    static interface Interface2 extends Interface1
    {
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;
    }

    public static void testInterface1()
    {
        System.out.println(Interface1.class.getName());
        System.out.println(Interface1.class.getFields().length);
        System.out.println(Interface1.class.getDeclaredFields().length);

    }
}

/**
 * 1.通过反射找到{@link Class2}类中修饰符包括public和final，返回类型为void，名为wait，有两个参数：int和long，抛出一个{@link InterruptedException}
 * 异常的方法。<br>
 * 代码：{@link MethodQuestion#test1()}。<br>
 * <br>
 * 2.通过反射调用{@link ArrayList}的{@link ArrayList#add(Object)}方法给一个list添加元素。<br>
 * 代码：{@link MethodQuestion#test3()}。<br>
 * <br>
 */
class MethodQuestion
{
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
    
    public static void test2()
    {
        try
        {
            Class2.class.getMethod("wait", long.class,int.class);
        } catch (NoSuchMethodException | SecurityException e)
        {
            e.printStackTrace();
        }
    }

    public static void test3()
    {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        try
        {
            Method method = List.class.getMethod("add", Object.class);
            method.invoke(list, 1);
            System.out.println(list.size());
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    static class Class1
    {

    }

    static class Class2 extends Class1
    {

    }
}

/**
 * 
 * 
 */
class ConstructorQuestion
{

    public static void test1()
    {
        // List<Integer> list1 = new ArrayList<>();
        // Constructor<?>[] constructor = list1.getClass().getConstructors();
        Constructor<?>[] constructors1 = Class2.class.getConstructors();
        Constructor<?>[] constructors2 = Class2.class.getDeclaredConstructors();
        System.out.println(constructors1.length);
        System.out.println(constructors2.length);
    }

    static class Class1
    {
        public Class1()
        {

        }

        @SuppressWarnings("unused")
        private Class1(int i)
        {

        }
    }

    static class Class2 extends Class1
    {
        public Class2()
        {

        }

        public Class2(int i)
        {

        }

        @SuppressWarnings("unused")
        private Class2(int i, int j)
        {

        }
    }
}
