package java_;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 1.Java成员变量分为哪三类？<br>
 * 属性（fields），局部变量（local variables），参数（parameters）。<br>
 * {@link http://docs.oracle.com/javase/tutorial/java/javaOO/variables.html}<br>
 * <br>
 */
public class ClassQuestion
{
    public static void main(String[] args)
    {
        // StaticQuestion.Block.test();
    }
}

/**
 * 1.Java中static有哪些用法？ <br>
 * a.修饰属性，可以直接使用类名调用。 <br>
 * b.修饰代码块。<br>
 * c.修饰内部类，如果一个类只可能被另一个类使用并且不使用外部类的成员，那么这个类就应该定义为静态内部类。<br>
 * d.静态导包，无需类名就能调用静态成员，通常用于常量。<br>
 * <br>
 * 2.代码{@link StaticQuestion.Block#test()}能否输出Hello World？。<br>
 * 能。<br>
 */
class StaticQuestion
{
    static class Field
    {

    }

    static class Block
    {
        static
        {
            System.out.println("Hello World");
        }

        static void test()
        {

        }
    }

    static class Package
    {
        public final class Constants
        {
            public static final int TRUE = 1;

            private Constants()
            {

            }
        }
    }
}

/**
 * 1.Java中final有哪些用法？ <br>
 * a.修饰成员变量，表示不能改变。<br>
 * b.修饰方法，表示不能重写。<br>
 * b.修饰类，表示不能继承。<br>
 * <br>
 * 2.为什么{@link String}要设计成final？<br>
 * a.线程安全。b.无法被继承，保证实际存储字符串的char数组不会被修改。 <br>
 * <br>
 * 3.除了{@link String}外，Java中还有哪些类用final修饰？<br>
 * {@link Integer}，{@link Short}，{@link Long}，{@link Float}，{@link Double}，{@link Byte}，{@link Boolean}，
 * {@link Character}。<br>
 * {@link StringBuilder}。<br>
 * <br>
 * 4.为什么{@link BigInteger}和{@link BigDecimal}没有用final修饰？<br>
 * 历史原因。<br>
 * <br>
 * 5.定义一个类{@link java_.static_p.Constants}专门存放常量，在其中定义一个int常量TRUE，值为1，再定义一个类{@link java_.static_p.ConstantsTest}
 * 演示如何使用。写出代码。 <br>
 */
class FinalQuestion
{
    static class LocalVariables
    {
        static void test()
        {
            final int i;
            i = 2;
            System.out.println(i);
        }
    }
    
    static class Method
    {
        static class A
        {
            static final void method1()
            {
                
            }
        }
        static class B extends A
        {

        }
        
    }
}

/**
 * 1.Java中静态代码块只执行一次吗？<br>
 * 对。<br>
 * 2. Java中静态代码块，非静态代码块，构造方法执行顺序？<br>
 * 父类的静态代码块->子类的静态代码块-> 父类的非静态代码块->父类构造方法-> 子类非静态代码块->子类构造方法<br>
 * 3.写出代码{@link OrderQuestion#test1()}的结果。<br>
 * A Static Code<br>
 * C Static Code<br>
 * A No Static Code<br>
 * A Constructor<br>
 * A No Static Code<br>
 * A Constructor<br>
 * B Static Code<br>
 * A No Static Code<br>
 * A Constructor<br>
 * B No Static Code<br>
 * B Constructor<br>
 * C No Static Code<br>
 * C Constructor<br>
 */
class OrderQuestion
{
    static class Test1
    {

    }

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