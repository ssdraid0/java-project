package java_;

import java.util.Arrays;

/**
 * 1.Java中数组是否能为null？<br>
 * 能。<br>
 * <br>
 * 2.
 */
public class ArrayQuestion
{
    public static void main(String[] args)
    {
        test1();
    }

    public static void test1()
    {
        int[] i = new int[1];
        System.out.println(i.length);
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
