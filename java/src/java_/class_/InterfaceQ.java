package java_.class_;

/**
 * ⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽</br>
 * 1.接口和抽象类的不同点？</br>
 * a.对于属性，接口只能有public静态常量，抽象类没有限制。</br>
 * b.对于方法，接口只能有抽象方法，静态方法和默认方法(Java8)，抽象类没有限制。</br>
 * c.接口的抽象方法只能是public，抽象类的抽象方法可以是public和protected。</br>
 * d.对于代码块，接口不能定义代码块或静态代码块。</br>
 * e.一个类可以实现多个接口，但只能继承一个抽象类。</br>
 * </br>
 * 2.接口和抽象类的相同点？</br>
 * a.都不能用final修饰。</br>
 * b.都不能被实例化。</br>
 * </br>
 * 3.接口可以有静态方法吗？</br>
 * 可以。</br>
 * </br>
 * 4.接口可以继承多个接口吗？可以实现接口吗？</br>
 * 可以。不能。</br>
 * </br>
 * 5.default方法只能在接口中定义吗？</br>
 * 对。</br>
 */
@SuppressWarnings("unused")
public class InterfaceQ
{
    private interface IF1
    {
        public static final int i = 1;

        public abstract void method1();

        public default void i()
        {}

        public static void s()
        {}
    }

    private interface IF2
    {}

    private interface IF3 extends IF1, IF2
    {}
}

/**
 * 1.抽象类可以有构造方法吗？可以没有抽象方法吗？</br>
 * 可以。可以。 </br>
 * </br>
 * 2.抽象类实现了一个接口，可以不实现其中的抽象方法吗？ </br>
 * 可以。</br>
 */
class AbstractClassQ
{
    abstract class A
    {}

}
