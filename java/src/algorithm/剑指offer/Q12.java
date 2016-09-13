package algorithm.剑指offer;

/**

 * 面试题 12：打印 1 到最大的 n 位数。<br>
 * 题目：输入数字 n，按顺序打印出从 1 到最大的 n 位进制数。比如输入 3，则打 印出 1、
 * 2、 3 一直到 999。
 */
public class Q12
{
    public static void printToMaxOfNDigits(int n)
    {
        int[] array = new int[n];
        if (n <= 0)
            return;
        printArray(array, 0);
    }

    private static void printArray(int[] array, int n)
    {
        for (int i = 0; i < 10; i++)
        {
            if (n != array.length)
            {
                array[n] = i;
                printArray(array, n + 1);
            } else
            {
                boolean isFirstNo0 = false;
                for (int j = 0; j < array.length; j++)
                {
                    if (array[j] != 0)
                    {
                        System.out.print(array[j]);
                        if (!isFirstNo0)
                            isFirstNo0 = true;
                    } else
                    {
                        if (isFirstNo0)
                            System.out.print(array[j]);
                    }
                }
                System.out.println();
                return;
            }
        }
    }

    public static void main(String[] args)
    {
        printToMaxOfNDigits(2);
    }
}
