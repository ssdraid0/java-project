package algorithm;

/**
* 1.输入一个从小到大排序的int数组，其中有些数字重复出现，删除这些数字，返回删除后的数组长度。<br>
* {@link #removeDuplicates(int[])}。<br>
* <br>
*/
public class ArrayIntRemove
{
    /**
     * 输入一个int数组，已经排好序，其中有些数字重复出现，删除这些数字，返回删除后的数组长度。<br>
     * https://leetcode.com/problems/remove-duplicates-from-sorted-array/<br>
     */
    public static int removeDuplicates(int a[])
    {
        if (a.length <= 1)
            return a.length;
        int length = 0;
        for (int i = 0; i < a.length; i++)
        {
            if (i == 0 || a[length - 1] != a[i])
                a[length++] = a[i];
        }
        return length;
    }
}
