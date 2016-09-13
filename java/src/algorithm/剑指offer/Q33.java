package algorithm.剑指offer;

import data_structure.array.ArrayUtil;

/**
 * 面试题 33：把数组排成最小的数<br>
 * 题目：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字的最小的一个。例如输入{3,32,321}，则打印最小的数字是
 * 321323.
 */
public class Q33
{
    public static void main(String[] args)
    {
        int a[] = {3,32,321};
        ArrayUtil.printMin(a);
    }
}
