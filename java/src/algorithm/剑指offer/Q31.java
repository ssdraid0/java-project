package algorithm.剑指offer;

import data_structure.array.ArrayUtil;

/**
 * 面试题 31：连续子数组的最大和。<br>
 * 题目：输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整 数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为 O(n)。 例
 * 如输入的数组为{1,-2,3,10,-4,7,2,-5}，和最大的子数组为{3,10,-4,7,2}。
 */
public class Q31
{
    public static void main(String[] args)
    {
        int[] array = { 1, -2, 3, 10, -4, 7, 2, -5 };
        System.out.println(ArrayUtil.findGreatestSubArray(array));
    }

}
