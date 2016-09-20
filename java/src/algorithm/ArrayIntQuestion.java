package algorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1.输入一个int数组，其中只有一个数字出现一次，其余数字都出现两次，返回这个数字。<br>
 * {@link #oneSingleNum(int[])}。<br>
 * 2.输入一个int数组，其中只有两个数字出现一次，其余数字都出现两次，输出这两个数字。<br>
 * {@link #twoSingleNum(int[])}。<br>
 * 4.输入一个int数组，把奇数放到左边。<br>
 * {@link #moveOddToLeft(int[])}。<br>
 * 5.输入一个int数组，数组中有一个数字出现次数超过数组长度的一半，返回这个数字。<br>
 * {@link #moreThanHalf(int[])}。<br>
 * 6.输入一个int数组，返回连续子数组元素和的最大值。<br>
 * {@link #maxSubArray(int[])}。<br>
 * 7.输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。<br>
 * {@link #printMin(int[])}。<br>
 */
public class ArrayIntQuestion
{
    public static void main(String[] args)
    {
        int[] a = { 1, 1, 2, 3, 3, 4, 4 };
        System.out.println(oneSingleNum(a));
        print(a);
        int[] a2 = { 1, 1, 2, 3, 4, 5, 5 };
        System.out.println();
        threeSingleNum(a2);
        System.out.println();
        // twoSingleNumTest();
    }

    /**
     * 输入一个int数组，其中只有一个数字出现一次，其余数字都出现两次。返回这个数字。<br>
     * 0^a=a<br>
     * a^b=b^a<br>
     * a^a=0<br>
     * https://leetcode.com/problems/single-number/<br>
     */
    public static int oneSingleNum(int a[])
    {
        int x = 0;
        for (int i = 0; i < a.length; i++)
            x ^= a[i];
        return x;
    }

    /**
     * 输入一个int数组，其中只有两个数字出现一次，其余数字都出现两次。输出这两个数字。<br>
     * http://zhedahht.blog.163.com/blog/static/2541117420071128950682/<br>
     * https://leetcode.com/problems/single-number-iii/<br>
     */
    public static void twoSingleNum(int a[])
    {
        int x = 0;
        for (int i = 0; i < a.length; i++)
            x ^= a[i];
        int indexOf1 = findFirstBitIs1(x);
        int num1 = 0, num2 = 0;
        for (int i = 0; i < a.length; ++i)
        {
            if (isBit1(a[i], indexOf1))
                num1 ^= a[i];
            else
                num2 ^= a[i];
        }
        System.out.print(num1 + "," + num2);
    }

    private static int findFirstBitIs1(int num)
    {
        int indexBit = 0;
        while (((num & 1) == 0) && (indexBit < 32))
        {
            num = num >> 1;
            ++indexBit;
        }
        return indexBit;
    }

    private static boolean isBit1(int num, int indexBit)
    {
        num = num >> indexBit;
        return (num & 1) == 1;
    }

    /**
     * 输入一个int数组，其中只有三个数字出现一次，其余数字都出现两次。输出这三个数字。<br>
     * http://zhedahht.blog.163.com/blog/static/25411174201283084246412/<br>
     */
    public static void threeSingleNum(int[] a)
    {
        int i, x = 0;
        for (i = 0; i < a.length; i++)
            x ^= a[i];
        int flips = 0;
        for (i = 0; i < a.length; i++) // 因为出现偶数次的seq[i]和xors的异或，异或结果不改变
            flips ^= lowbit(x ^ a[i]); // 表示的是：flips = lowbit(a^b) ^ lowbit(a^c) ^ lowbit(b^c)
        // 三个数两两异或后lowbit有两个相同，一个不同，可以分为两组
        // 所以flips的值为：lowbit(a^b) 或 lowbit(a^c) 或 lowbit(b^c)
        // 得到三个数中的一个
        int num1 = 0;
        for (i = 0; i < a.length; i++)
        {
            if (lowbit(a[i] ^ x) == flips)     // 找出三个数两两异或后的lowbit与另外两个lowbit不同的那个数
                num1 ^= a[i];
        }
        // 找出后，与数组中最后一个值交换，利用twoSingleNum，找出剩余的两个
        for (i = 0; i < a.length; i++)
        {
            if (num1 == a[i])
            {
                int temp = a[i];
                a[i] = a[a.length - 1];
                a[a.length - 1] = temp;
            }
        }
        System.out.print(num1 + ",");
        twoSingleNum(Arrays.copyOfRange(a, 0, a.length - 1));
    }

    public static int lowbit(int x)
    {
        return x & ~(x - 1);
    }

    /**
     * 输入一个int数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。<br>
     */
    public static void printMin(int a[])
    {
        String[] s = new String[a.length];
        for (int i = 0; i < a.length; i++)
        {
            s[i] = Integer.toString(a[i]);
        }
        StringComparator stringComparator = new StringComparator();
        Arrays.sort(s, stringComparator);
        for (String string : s)
        {
            System.out.print(string);
        }
    }

    private static class StringComparator implements Comparator<String>
    {
        @Override
        public int compare(String s1, String s2)
        {
            String left = s1 + s2;
            String right = s2 + s1;
            for (int i = 0; i < left.length(); i++)
            {
                if (left.charAt(i) < right.charAt(i))
                    return -1;
                else if (left.charAt(i) > right.charAt(i))
                    return 1;
            }
            return 1;
        }
    }

    /**
     * 输入一个int数组，把奇数放到左边。<br>
     * http://zhedahht.blog.163.com/blog/static/25411174200741295930898/<br>
     */
    public static void moveOddToLeft(int a[])
    {
        if (a.length <= 1)
            return;
        int begin = 0;
        int end = a.length - 1;
        while (begin < end)
        {
            if (a[begin] % 2 != 0)
            {
                begin++;
                continue;
            }
            if (a[end] % 2 == 0)
            {
                end--;
                continue;
            }
            int temp = a[begin];
            a[begin] = a[end];
            a[end] = temp;
        }
    }

    /**
     * 输入一个int数组，数组中有一个数字出现次数超过数组长度的一半，返回这个数字。<br>
     * http://zhedahht.blog.163.com/blog/static/25411174201085114733349/<br>
     */
    public static Integer moreThanHalf(int[] a)
    {
        if (a == null)
            return null;
        int times = 0;
        Integer result = null;
        for (int i = 0; i < a.length; i++)
        {
            if (times == 0)
            {
                result = a[i];
                times = 1;
            } else if (a[i] == result)
                times++;
            else
                times--;
        }
        return result;
    }

    /**
     * 输入一个int数组，返回连续子数组元素和的最大值。<br>
     * http://zhedahht.blog.163.com/blog/static/254111742007219147591/<br>
     * https://leetcode.com/problems/maximum-subarray/<br>
     */
    public static int maxSubArray(int[] a)
    {
        int[] sum = new int[a.length];
        int max = a[0];
        for (int i = 0; i < a.length; i++)
        {
            if (i == 0)
                sum[i] = a[i];
            else
            {
                sum[i] = a[i] + Math.max(sum[i - 1], 0);
                max = Math.max(max, sum[i]);
            }
        }
        return max;
    }

    private static void print(int[] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + ",");
        }
    }

    @SuppressWarnings("unused")
    private static void twoSingleNumTest()
    {
        int[] a = { 1, 1, 2, 3, 3, 4, 5, 5 };
        twoSingleNum(a);
    }

}
