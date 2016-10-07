package java_.collection;

import java.util.Arrays;
import java.util.List;

/**
 * ⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽</br>
 * 1.{@link Object#hashCode()}的返回值是什么。</br>
 * 一个8位10进制数，代表对象的地址。</br>
 * </br>
 * 2.一个类有下面这些属性，如何实现hashCode和equals方法。</br>
 * 
 * <pre>
 * private byte b;
 * private short s;
 * private int i;
 * private long l;
 * private float f;
 * private double d;
 * private char c;
 * private boolean bool;
 * private int[] iArray;
 * private List<Integer> iList;
 * private String string;
 * </pre>
 * 
 * <pre>
 * public int hashCode()
 * {
 *     final int prime = 31;
 *     int result = 1;
 *     result = prime * result + b;
 *     result = prime * result + s;
 *     result = prime * result + i;
 *     result = prime * result + (int) (l ^ (l >>> 32));
 *     result = prime * result + Float.floatToIntBits(f);
 *     long temp;
 *     temp = Double.doubleToLongBits(d);
 *     result = prime * result + (int) (temp ^ (temp >>> 32));
 *     result = prime * result + c;
 *     result = prime * result + (bool ? 1231 : 1237);
 *     result = prime * result + Arrays.hashCode(iArray);
 *     result = prime * result + ((iList == null) ? 0 : iList.hashCode());
 *     result = prime * result + ((string == null) ? 0 : string.hashCode());
 *     return result;
 * }
 * </pre>
 * 
 * <pre>
 * public boolean equals(Object obj)
 * {
 *     if (this == obj) return true;
 *     if (obj == null) return false;
 *     if (!(obj instanceof Class1)) return false;
 *     Class1 other = (Class1) obj;
 *     if (b != other.b) return false;
 *     if (bool != other.bool) return false;
 *     if (c != other.c) return false;
 *     if (Double.doubleToLongBits(d) != Double.doubleToLongBits(other.d)) return false;
 *     if (Float.floatToIntBits(f) != Float.floatToIntBits(other.f)) return false;
 *     if (i != other.i) return false;
 *     if (!Arrays.equals(iArray, other.iArray)) return false;
 *     if (iList == null)
 *     {
 *         if (other.iList != null) return false;
 *     } else if (!iList.equals(other.iList)) return false;
 *     if (l != other.l) return false;
 *     if (s != other.s) return false;
 *     if (string == null)
 *     {
 *         if (other.string != null) return false;
 *     } else if (!string.equals(other.string)) return false;
 *     return true;
 * }
 * </pre>
 * 
 * 3.分析boolean类型的hashCode计算方法。</br>
 * 
 * <pre>
 * private boolean bool;
 * 
 * public int hashCode()
 * {
 *     final int prime = 31;
 *     int result = 1;
 *     result = prime * result + (bool ? 1231 : 1237);
 * }
 * </pre>
 * 
 * http://stackoverflow.com/questions/3912303/boolean-hashcode</br>
 * 1231，1237是第202,203位质数。</br>
 * {@link Boolean#hashCode(boolean)}
 */
@SuppressWarnings("unused")
public class HashcodeQ
{
    public static void main(String[] args)
    {
        testHashCode();
    }

    public static void testHashCode()
    {
        Object object = new Object();
        System.out.println(object.hashCode());
    }

    private static class Class1
    {
        private byte b;
        private short s;
        private int i;
        private long l;
        private float f;
        private double d;
        private char c;
        private boolean bool;
        private int[] iArray;
        private List<Integer> iList;
        private String str;

        @Override
        public int hashCode()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + b;
            result = prime * result + s;
            result = prime * result + i;
            result = prime * result + (int) (l ^ (l >>> 32));
            result = prime * result + Float.floatToIntBits(f);
            long temp;
            temp = Double.doubleToLongBits(d);
            result = prime * result + (int) (temp ^ (temp >>> 32));
            result = prime * result + c;
            result = prime * result + (bool ? 1231 : 1237);
            result = prime * result + Arrays.hashCode(iArray);
            result = prime * result + ((iList == null) ? 0 : iList.hashCode());
            result = prime * result + ((str == null) ? 0 : str.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj)
        {
            if (this == obj) return true;
            if (obj == null) return false;
            if (!(obj instanceof Class1)) return false;
            Class1 other = (Class1) obj;
            if (b != other.b) return false;
            if (bool != other.bool) return false;
            if (c != other.c) return false;
            if (Double.doubleToLongBits(d) != Double.doubleToLongBits(other.d)) return false;
            if (Float.floatToIntBits(f) != Float.floatToIntBits(other.f)) return false;
            if (i != other.i) return false;
            if (!Arrays.equals(iArray, other.iArray)) return false;
            if (iList == null)
            {
                if (other.iList != null) return false;
            } else if (!iList.equals(other.iList)) return false;
            if (l != other.l) return false;
            if (s != other.s) return false;
            if (str == null)
            {
                if (other.str != null) return false;
            } else if (!str.equals(other.str)) return false;
            return true;
        }
    }
}
