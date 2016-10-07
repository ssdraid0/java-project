package java_.class_;

/**
 * ⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽</br>
 * 1.Java成员变量分为哪三类？</br>
 * 属性（fields），局部变量（local variables），参数（parameters）。</br>
 * http://docs.oracle.com/javase/tutorial/java/javaOO/variables.html</br>
 * </br>
 * 2.静态成员类和非静态成员类的区别？</br>
 * 非静态成员类能访问外围实例的非静态成员。</br>
 */
public class ClassQ
{
    public static void main(String[] args)
    {
        // StaticQuestion.Block.test();
    }
}

/**
 * 1.Java中静态代码块只执行一次吗？</br>
 * 对。</br>
 * 2. Java中静态代码块，非静态代码块，构造方法执行顺序？</br>
 * 父类的静态代码块->子类的静态代码块-> 父类的非静态代码块->父类构造方法-> 子类非静态代码块->子类构造方法</br>
 * 3.写出代码{@link OrderQuestion#testNull()}的结果。</br>
 * A Static Code</br>
 * C Static Code</br>
 * A No Static Code</br>
 * A Constructor</br>
 * A No Static Code</br>
 * A Constructor</br>
 * B Static Code</br>
 * A No Static Code</br>
 * A Constructor</br>
 * B No Static Code</br>
 * B Constructor</br>
 * C No Static Code</br>
 * C Constructor</br>
 */
class OrderQuestion
{
    static class Test1
    {}

    static class Test2
    {
        static void test1()
        {
            C c = new C();
            c.toString();
        }

        static class A
        {
            static
            {
                System.out.println("A Static Code");
            }

            {
                System.out.println("A No Static Code");
            }

            public A()
            {
                System.out.println("A Constructor");

            }

        }

        static class B extends A
        {
            static
            {
                System.out.println("B Static Code");
            }

            {
                System.out.println("B No Static Code");
            }

            public B()
            {
                System.out.println("B Constructor");
            }
        }

        static class C extends A
        {
            A a = new A();
            B b = new B();

            static
            {
                System.out.println("C Static Code");
            }

            {
                System.out.println(a.toString());
                System.out.println("C No Static Code");
            }

            public C()
            {
                System.out.println("C Constructor");
            }
        }
    }
}