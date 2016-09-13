package algorithm.剑指offer;

/**
*面试题 10：二进制中 1 的个数
*题目：请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如
*把 9 表示成二进制是 1001；有 2 位是 1，因此如果输入 9，函数输出 2.
 */
public class Q10
{
    public static int numberOf1(int n)
    {
        int count = 0;
        while (n != 0)
        {
            count++;
            //(n - 1) & n的结果是将n的二进制的最低位的1改为0
            n = (n - 1) & n;
        }
        return count;
    }

    public static void main(String[] args)
    {
        System.out.println(numberOf1(3));
    }
}
