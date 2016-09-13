package design_pattern.adapter;

public class Test
{

    public static void main(String[] args)
    {
        // 有一个实现了IAB接口的类AB
        IAB iab = new AB();
        iab.a();
        iab.b();
        // 有一个没有实现IAB接口的类B，要让下面的代码正常运行，必须修改B类使其继承IAB接口并重写b方法。现在要求不修改B类解决这个问题。
        // IAB iab = new B();
        // iab.a();
        // iab.b();
        // 方法1，使用类适配器，写一个类BAdapter继承B并实现IAB接口，重写a方法。
        IAB iab2 = new BAdapter1();
        iab2.a();
        iab2.b();
        // 方法2，使用对象适配器，写一个类BAdapter实现IAB接口并添加一个成员变量B，重写a方法和b方法，b方法调用成员变量B的b方法。
        IAB iab3 = new BAdapter2();
        iab3.a();
        iab3.b();
    }
}
