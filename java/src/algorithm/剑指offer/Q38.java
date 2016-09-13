package algorithm.剑指offer;

/**
 * 面试题 38：数字在排序数组中出现的次数 题目：统计一个数字在排序数组中出现的次数。例如输入排序数组{1,2,3,3,3， 3,3,4,5}和数字
 * 3，由于 3 在这个数组中出现了 4 次，因此输出 4。
 * <p>
 * 解法：用二分查找，分别找出第一个3，和最后一个3的位置，然后计算个数。
 */
public class Q38
{

    public static void main(String[] args)
    {
        int[] array = { 1, 2, 3, 3, 3, 3, 4, 5 };
        System.out.println(getNumberOfK(array, 3));
    }

    private static int getNumberOfK(int[] array, int k)
    {
        int number = 0;
        if (array != null)
        {
            int first = getFirstK(array, k, 0, array.length - 1);
            int last = getLastK(array, k, 0, array.length - 1);
            if (first > -1 && last > -1)
                number = last - first + 1;
        }
        return number;
    }

    private static int getFirstK(int[] array, int k, int start, int end)
    {
        if (start > end)
            return -1;
        int middleIndex = (start + end) / 2;
        int middleData = array[middleIndex];
        if (middleData == k)
        {
            if ((middleIndex > 0 && array[middleIndex - 1] != k) || middleIndex == 0)
                return middleIndex;
            else
                end = middleIndex - 1;
        } else if (middleData > k)
            end = middleIndex - 1;
        else
            start = middleIndex + 1;
        return getFirstK(array, k, start, end);
    }

    private static int getLastK(int[] array, int k, int start, int end)
    {
        if (start > end)
            return -1;
        int middleIndex = (start + end) / 2;
        int middleData = array[middleIndex];
        if (middleData == k)
        {
            if ((middleIndex < array.length - 1 && array[middleIndex + 1] != k) || middleIndex == array.length - 1)
                return middleIndex;
            else
                start = middleIndex + 1;
        } else if (middleData < k)
            start = middleIndex + 1;
        else
            end = middleIndex - 1;
        return getLastK(array, k, start, end);
    }
}
