package java_;

import java.util.Arrays;

/**
 * 1.Java中数组是否能为null？是否能长度为0，但又不为null。<br>
 * 都能。<br>
 * {@link ArrayQuestion#nullTest()}。<br>
 * 2.
 */
public class ArrayQuestion
{
    public static void main(String[] args)
    {
        nullTest();
    }

    public static void nullTest()
    {
        int[] a1 = null;
        int[] a2 = new int[0];
        int[] a3 = {};
        int[][] a4 = {};
        int[][] a5 = {{}};
        System.out.println(a1==null); //true
        System.out.println(a2.length == 0); //true
        System.out.println(a2 == null); //false
        System.out.println(a3.length == 0); //true
        System.out.println(a3 == null); //false
        System.out.println(a4.length == 0); //true
        System.out.println(a5.length == 0); //false
        System.out.println(a5[0].length == 0); //true
    }
    public static void test2()
    {
        int[] a1 = { 3, 1, 4, 1, 5, 9, 2, 6, 5, 4 };
        Integer[] a2 = { 3, 1, 4, 1, 5, 9, 2, 6, 5, 4 };
        System.out.println(Arrays.asList(a1));
        System.out.println(Arrays.asList(a2));
        System.out.println(Arrays.toString(a1));
    }

}
