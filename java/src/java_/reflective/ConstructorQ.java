package java_.reflective;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * ⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽<br>
 * 1.{@link Class#getConstructors()}和{@link Class#getDeclaredConstructors()}的区别？<br>
 * {@link Class#getConstructors()}：只获取public构造器，包括继承的。<br>
 * {@link Class#getDeclaredConstructors()}：：获取所有构造器，不包括继承的。<br>
 * {@link #testGetConstructor()}<br>
 * <br>
 * 2.通过{@link Constructor}构造一个对象的过程？<br>
 * ⑴.通过{@link Class#getConstructors()}获取类的所有构造器。<br>
 * ⑵.通过{@link Constructor#getParameters()}找出需要的构造器。<br>
 * ⑶.通过{@link Constructor#newInstance(Object...)}构造一个对象。<br>
 * {@link #testNewInstance()}<br>
 */
public class ConstructorQ
{
    public static void main(String[] args)
    {
        testNewInstance();
    }

    public static void testGetConstructor()
    {
        // List<Integer> list1 = new ArrayList<>();
        // Constructor<?>[] constructor = list1.getClass().getConstructors();
        Constructor<?>[] constructors1 = Class2.class.getConstructors();
        Constructor<?>[] constructors2 = Class2.class.getDeclaredConstructors();
        System.out.println(constructors1.length);
        System.out.println(constructors2.length);
    }

    public static void testNewInstance()
    {
        Constructor<?>[] constructors1 = Class2.class.getConstructors();
        for (Constructor<?> c : constructors1)
        {
            if (c.getParameters() != null && c.getParameters().length == 1
                    && c.getParameters()[0].getType() == int.class)
            {
                try
                {
                    Class2 class2;
                    class2 = (Class2) c.newInstance(1);
                    class2.say();
                } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                        | InvocationTargetException e)
                {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    @SuppressWarnings("unused")
    private static class Class1
    {
        public Class1()
        {}

        public Class1(int i)
        {}

    }

    @SuppressWarnings("unused")
    private static class Class2
    {
        public Class2()
        {}

        public Class2(int i)
        {}

        public void say()
        {
            System.out.println("Hello");
        }
    }
}