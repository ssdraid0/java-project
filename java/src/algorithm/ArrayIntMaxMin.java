package algorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1. 输入一个int类型数组，寻找两个数，一个在左边，一个在右边，使右边减左边的值最大。 <br>
 * 返回这个最大值。 <br>
 * {@link #minMax(int[])}。<br>
 * 2.输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。<br>
 * {@link #printMin(int[])}。<br>
 * <br>
 */
public class ArrayIntMaxMin
{
    public static void main(String[] args)
    {
    }

    /**
     * 输入一个int类型数组，寻找两个数，一个在左边，一个在右边，使右边减左边的值最大。<br>
     * 返回这个最大值。<br>
     * 输入一个数组，代表股票每天的价格。 <br>
     * 买股票前必须卖出股票，手里最多能持有1个股票，股票在某天买了，不能在那天卖。<br>
     * 返回最大收益。<br>
     * 例如：输入{ 1, 5, 3, 7, 2, 6 }，返回最大收益7-1=6。<br>
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/<br>
     * http://zhedahht.blog.163.com/blog/static/2541117420116135376632/<br>
     * http://blog.csdn.net/diu_brother/article/details/51226794<br>
     */
    public static int minMax(int[] a)
    {
        if (a == null || a.length <= 1)
            return 0;
        int[] diff = new int[a.length];
        int minLeft = a[0];
        for (int i = 1; i < diff.length; i++)
        {
            diff[i] = Math.max(diff[i - 1], a[i] - minLeft);
            minLeft = Math.min(minLeft, a[i]);
        }
        return diff[diff.length - 1];
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
                    return -1; // 左边小于右边
                else if (left.charAt(i) > right.charAt(i))
                    return 1; // 左边大于右边
            }
            return 0;
        }
    }

    public static void print(int[] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + ",");
        }
    }
}
