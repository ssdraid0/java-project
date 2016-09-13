package design_pattern.prototype;

import java.util.ArrayList;

/**
 * 设计模式：原型（Prototype）模式。</br>
 * 1.什么时候使用？ </br>
 * 用一个实例创建另一个实例。</br>
 * 2.JDK中哪些地方使用了？ </br>
 * Object的clone方法。</br>
 */
public class ProtoTypeTest
{

    public static void main(String[] args)
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.clone();
    }

}
