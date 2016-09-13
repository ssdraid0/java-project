package keyword.abstract_p;

/**
 * 1.抽象类和接口的区别？<br>
 * a.对于属性，接口中只能有公有的静态常量。<br>
 * b.对于方法，抽象类可以有抽象方法，也可以有一般方法，接口只能有抽象方法，默认方法或静态方法。 接口中的所有方法都必须是public。<br>
 * c.接口可以继承多个接口。抽象类只能继承一个抽象类。<br>
 * d.对于代码块，接口不能定义代码块或静态代码块。<br>
 * 2.抽象类需要重写父类的抽象方法吗？<br>
 * 不需要。可以重写也可以不重写。<br>
 * 3.接口或抽象类的抽象方法都必须是public吗？<br>
 * 错。接口的抽象方法必须是public，抽象类的抽象方法可以是public或protected。<br>
 * 4.接口能实现接口吗？<br>
 * 不能。<br>
 * 5.default方法只能在接口中定义吗？<br>
 * 对。<br>
 * 6.为什么要避免在接口中定义常量？<br>
 * 因为接口可能被其他类实现，这些类的命名空间全部被污染。<br>
 */
public abstract class AbstractTest
{

    private void privateM()
    {

    }

    public void publicM()
    {

    }

    public abstract void publicAM();

}
