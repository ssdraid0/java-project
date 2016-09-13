package keyword.class_p;

/**
 * .静态成员类和非静态成员类的区别？<br>
 * 非静态成员类能访问外围实例的非静态成员。<br>
 * .重载（Overload），重写（Override），隐藏（hide）的定义。<br>
 * 重载：一个类的两个方法，方法名相同，但参数不同。<br>
 * 重写：两个实例方法分别在子类和父类，方法名，参数和返回类型相同。<br>
 * 隐藏：两个静态方法分别在子类和父类，方法名，参数和返回类型相同。<br>
 * .一个类B继承类A，B有一个{@code void println(Object o)}方法，A有一个{@code void println(String s)}方法，这种情况是否为重载？<br>
 * .是。<br>
 * .写出下面代码{@link OverloadTest#main(String[])}的结果。<br>
 * .写出下面代码{@link OverrideTest#main(String[])}的结果。<br>
 * .写出下面代码{@link HideTest#main(String[])}的结果。<br>
 */
public class ClassQuestion
{
    int i = 0;

    class NonStaticMemberClass
    {
        void m()
        {
            System.out.println(i);
        }
    }

    static class StaticMemberClass
    {
        void m()
        {
            // System.out.println(i);

        }
    }

    void f()
    {

    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
    }

}
