package algorithm.剑指offer;

import data_structure.array.ArrayUtil;

/**
 * 面试题 29：数组中出现次数超过一半的数组<br>
 * 题目： 数组中有一个数字出现次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 2出现的次数超过数组长度的一半，因此输出2.
 */
public class Q29
{
    public static void main(String[] args)
    {
        int[] array = { 1, 2, 3, 2, 2, 2, 5, 4, 2 };
        System.out.println(ArrayUtil.moreThanHalfNum(array));
    }
}
