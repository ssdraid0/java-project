package design_pattern.flyweight;

/**
 * 设计模式：享元（Flyweight）模式。</br>
 * 1.什么时候使用？ </br>
 * 用于缓存经常使用的对象。</br>
 * 2.JDK中哪些地方使用了？ </br>
 * Integer，Long，Short，Byte，Character的valueOf方法。</br>
 * 3.写出JDK源码的LongCache类。</br>
 */
public class FlyWeightTest
{
    public static void main(String[] args)
    {
        // 缓存-128到127之间（包括边界）
        Integer.valueOf(0);
        Long.valueOf(0);
        Short.valueOf((short) 0);
        Byte.valueOf((byte) 0);

        // 缓存ASCII表上0到128之间（包括边界）的字符
        System.out.println(Character.valueOf('a') == Character.valueOf('a'));
        System.out.println(Character.valueOf('Z') == Character.valueOf('Z'));
        System.out.println(Character.valueOf('Ⅱ') == Character.valueOf('Ⅱ'));
        System.out.println(Character.valueOf('中') == Character.valueOf('中'));
        /*
         * Character cache[] = new Character[127 + 1]; for (int i = 0; i <
         * cache.length; i++) System.out.println(new Character((char) i));
         */

    }
}
