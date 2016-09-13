package algorithm.剑指offer;

/**
 * 面试题 40：数组中只出现一次的数字。
 * <p>
 * 题目：一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序 找出这两个只出现一次的数字。要求时间复杂度是 O(n)，空间复杂度为 O(1)
 */
public class Q40
{
    public static void main(String[] args)
    {
        int[] array={2,4,3,6,3,2,5,5};
        findNumsAppearOnce(array);
    }

    public static void findNumsAppearOnce(int[] array)
    {
        if (array == null)
            return;
        int number = 0;
        for (int i : array)
            number ^= i;
        int index = findFirstBitIs1(number);
        int number1 = 0;
        int number2 = 0;
        for (int i : array)
        {
            if (isBit1(i, index))
                number1 ^= i;
            else
                number2 ^= i;
        }
        System.out.println(number1);
        System.out.println(number2);
    }

    private static int findFirstBitIs1(int number)
    {
        int indexBit = 0;
        while ((number & 1) == 0)
        {
            number = number >> 1;
            ++indexBit;
        }
        return indexBit;
    }

    private static boolean isBit1(int number, int index)
    {
        number = number >> index;
        return (number & 1) == 0;
    }
}
