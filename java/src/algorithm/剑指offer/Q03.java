package algorithm.剑指offer;

import data_structure.array.ArrayUtil;

/**
 * 面试题 3：二维数组中的查找<br>
 * 题目描述： 一个二维数组，每一行从左到右递增，每一列从上到下递增．输 入一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Q03
{
    public static void main(String args[])
    {
        int[][] testarray = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
        System.out.println(ArrayUtil.find(testarray, 1));
    }
}
