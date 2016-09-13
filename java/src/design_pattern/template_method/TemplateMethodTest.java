package design_pattern.template_method;

import java.util.AbstractList;
import java.util.ArrayList;

/**
 * 设计模式：模板方法（Template Method）模式。</br>
 * 1.什么时候使用？ </br>
 * 用来定义一个算法的步骤，其中的某些步骤让子类重写。</br>
 * 2.JDK中哪些地方使用了？ </br>
 * AbstractList的indexOf(Object o)，equals(Object
 * o)方法。indexOf和equals方法都使用了listIterator()方法，该方法都被子类重写了。
 * 
 */
public class TemplateMethodTest
{
    @SuppressWarnings("unused")
    public static void main(String[] args)
    {
        AbstractList<Integer> abstractList = null;
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.indexOf(null);
        arrayList.hashCode();
        arrayList.equals(null);

    }
}
