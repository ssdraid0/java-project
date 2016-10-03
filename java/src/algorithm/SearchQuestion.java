package algorithm;

/**
 * 1.输入一个int数组和int类型num，使用二分查找，返回num在数组中的位置。<br>
 * 有多个num的情形，返回最前/最后的一个。<br>
 * {@link #binarySearchFirst(int[], int)}，{@link #binarySearchLast(int[], int)}。<br>
 * <br>
 * 2.输入一个数组，这个数组是另一个递增排序的数组的一个旋转数组，通过二分法输出最小元素。<br>
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，数组{3,4,5,1,2}的最小值为 1。<br>
 * {@link #binarySearchMin(int[], int, int)}。<br>
 * <br>
 */
public class SearchQuestion
{
    /**
     * 输入一个int数组和int类型key，使用二分查找，返回key在数组中的位置。<br>
     * 有多个key的情形，返回最前的一个。<br>
     */
    public static int binarySearchFirst(int[] a, int k)
    {
        int start = 0;
        int end = a.length - 1;
        while (start < end)
        {
            int mid = start + ((end - start) >> 1);
            if (a[mid] < k)
                start = mid + 1;
            else
                end = mid;
        }
        if (a[start] == k)
            return start;
        return -1;
    }

    /**
     * 输入一个int数组和int类型key，使用二分查找，返回key在数组中的位置。<br>
     * 有多个key的情形，返回最后的一个。<br>
     */
    public static int binarySearchLast(int[] a, int k)
    {
        int start = 0;
        int end = a.length - 1;
        while (start < end)
        {
            int mid = start + ((end + 1 - start) >> 1);
            if (a[mid] <= k)
                start = mid;
            else
                end = mid - 1;
        }
        if (a[start] == k)
            return start;
        return -1;
    }

    /**
     * 输入一个数组，这个数组是另一个递增排序的数组的一个旋转数组，通过二分法输出最小元素。<br>
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，数组{3,4,5,1,2}的最小值为 1。<br>
     * {3,4,5,1,2}，{1,1,1,1,1}，，<br>
     * https://leetcode.com/problems/search-in-rotated-sorted-array/<br>
     */
    public static int binarySearchMin(int[] a, int start, int end)
    {
        if (start + 1 == end || start == end)
            return a[end] < a[start] ? a[end] : a[start];
        int index = (start + end) >> 1;
        if (a[start] == a[index] && a[end] == a[index])
        {// 此时两边中间都一样，考虑到特殊情况，我们两遍均遍历一次，进行最后的比较大小。
            int find1 = binarySearchMin(a, start, index);
            int find2 = binarySearchMin(a, index + 1, end);
            return find1 < find2 ? find1 : find2;
        } else if (a[index] >= a[start] && a[index] > a[end])
            return binarySearchMin(a, index + 1, end);
        else
            return binarySearchMin(a, start, index);
    }
}
