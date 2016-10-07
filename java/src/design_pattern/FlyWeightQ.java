package design_pattern;

/**
 * ⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽</br>
 * 1.什么时候使用享元（Flyweight）模式？ </br>
 * 用于缓存经常使用的对象。</br>
 * </br>
 * 2.Java中哪些地方使用了享元模式？ </br>
 * Integer，Long，Short，Byte，Character的valueOf方法。</br>
 * </br>
 * 3. Integer，Long，Short，Byte，Character的缓存范围是多少？</br>
 * ⑴.Integer，Long，Short，Byte：-128到127（包括边界）。</br>
 * ⑵.Character：ASCII码上0到128（包括边界）的字符。</br>
 * </br>
 * 4.写出Java的{@link Long.LongCache}LongCache类。</br>
 * {@link LongCache}。</br>
 */
public class FlyWeightQ
{
    public static void main(String[] args)
    {
        Integer.valueOf(0);
        Long.valueOf(0);
        Short.valueOf((short) 0);
        Byte.valueOf((byte) 0);

        // 缓存ASCII表上0到128之间（包括边界）的字符
        System.out.println(Character.valueOf('a') == Character.valueOf('a'));
        System.out.println(Character.valueOf('Z') == Character.valueOf('Z'));
        System.out.println(Character.valueOf('Ⅱ') == Character.valueOf('Ⅱ'));
        System.out.println(Character.valueOf('中') == Character.valueOf('中'));
    }

    @SuppressWarnings("unused")
    private static class LongCache
    {
        private LongCache()
        {}
        static final Long cache[] = new Long[-(-128) + 127 + 1];
        static
        {
            for (int i = 0; i < cache.length; i++)
                cache[i] = new Long(i - 128);
        }
    }
}
