package java_.class_;

/**
 * ⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽</br>
 * 1.Java中static有哪些用法？ </br>
 * ⑴.修饰属性，可以直接使用类名调用。 </br>
 * ⑵.修饰代码块。</br>
 * ⑶.修饰内部类，如果一个类只可能被另一个类使用并且不使用外部类的成员，那么这个类就应该定义为静态内部类。</br>
 * ⑷.静态导包，无需类名就能调用静态成员，通常用于常量。</br>
 * </br>
 * 2.代码{@link StaticQuestion.Block#test()}能否输出Hello World？。</br>
 * 能。</br>
 */
public class StaticQ
{
    static class Field
    {}

    static class Block
    {
        static
        {
            System.out.println("Hello World");
        }

        static void test()
        {}
    }

    static class Package
    {
        public final class Constants
        {
            public static final int TRUE = 1;

            private Constants()
            {}
        }
    }
}
