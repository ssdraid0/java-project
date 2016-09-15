package data_structure.array;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayUtil
{

    /**
     * 输入一个数组中，找出出现次数超过数组长度的一半的数字。
     */
    public static Integer moreThanHalfNum(int[] array)
    {
        if (array == null)
            return null;
        int count = 0;
        Integer resultInteger = null;
        for (int i = 0; i < array.length; i++)
        {
            if (count == 0)
            {
                resultInteger = array[i];
                count = 1;
            } else if (array[i] == resultInteger)
                count++;
            else
                count--;
        }
        if (checkMoreThanHalf(array, resultInteger))
            return resultInteger;
        else
            return null;
    }

    private static boolean checkMoreThanHalf(int[] array, Integer number)
    {
        int times = 0;
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == number)
                times++;
        }
        if (times * 2 <= array.length)
            return false;
        else
            return true;
    }

    /**
     * 输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整数组成一个子数组。求所有子数组的和的最大值。
     */
    public static int findGreatestSubArray(int[] array)
    {
        if (array == null)
            return 0;
        int currentSum = 0;
        int greatestSum = 0;
        for (int i = 0; i < array.length; i++)
        {
            if (currentSum <= 0)
            {
                currentSum = array[i];
            } else
            {
                currentSum += array[i];
            }
            if (currentSum > greatestSum)
                greatestSum = currentSum;
        }
        return greatestSum;
    }

    /**
     * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字的最小的一个。
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
}
