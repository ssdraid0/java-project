package algorithm;

/**
 * 1.有哪些常见排序算法？最好，平均，最坏时间复杂度是多少？空间复杂度是多少？是否稳定？<br>
 * 选择排序：n^2，n^2，n^2。1。不稳定。<br>
 * 冒泡排序：n，n^2，n^2。1。稳定。<br>
 * 快速排序：nlogn，nlogn，n^2。不稳定。<br>
 * 堆排序：nlogn，nlogn，nlogn。不稳定。<br>
 * 归并排序：nlogn，nlogn，nlogn。稳定。<br>
 * Timsort：n，nlogn，nlogn。稳定。<br>
 * <br>
 * 2.实现冒泡排序，快速排序，堆排序，归并排序。<br>
 * 冒泡排序：{@link #bubbleSort(int[])}。<br>
 * 快速排序：{@link #quickSort(int[])}。<br>
 * 堆排序：{@link HeapSortQuestion#sort(int[])}。<br>
 * 归并排序：{@link #mergeSort(int[])}。<br>
 * <br>
 * 3.输入一个已经按从小到大排序的int数组，其中有些数字重复出现，删除这些数字，返回删除后的数组长度。<br>
 * {@link #removeDuplicates(int[])}。<br>
 * 4.输入一个已经按从小到大排序的int数组和一个int类型sum，输出数组中和为sum的两个元素的下标。
* {@link #sumOfTwo(int[], int)}。<br>
 */
public class SortQuestion
{
    public static void main(String[] args)
    {
        int[] a = { 2, 5, 3, 8, 7, 4 };
        // SelectSortQuestion.sort(a);
        // BubbleSortQuestion.sort(a);
        // QuickSortQuestion.sort(a);
        // HeapSortQuestion.sort(a);
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i]);
        }
    }

    public static void selectSort(int[] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            for (int j = i; j < a.length; j++)
            {
                if (a[i] > a[j])
                {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    public static void bubbleSort(int[] a)
    {
        for (int i = a.length - 1; i > 1; i--)
        {
            for (int j = 0; j < i; j++)
            {
                if (a[j] > a[j + 1])
                {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(int[] a)
    {
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(int[] a, int l, int r)
    {
        if (l < r)
        {
            int i = l, j = r, x = a[l];
            while (i < j)
            {
                // 从右向左找第一个小于x的数
                while (i < j && a[j] >= x)
                    j--;
                if (i < j)
                    a[i++] = a[j];
                // 从左向右找第一个大于等于x的数
                while (i < j && a[i] < x)
                    i++;
                if (i < j)
                    a[j--] = a[i];
            }
            a[i] = x;
            quickSort(a, l, i - 1); // 递归调用
            quickSort(a, i + 1, r);
        }
    }

    /**
     * https://en.wikipedia.org/wiki/Merge_sort<br>
     */
    public static void mergeSort(int[] a)
    {
        mergeSort(a, 0, a.length - 1);
    }

    private static int[] mergeSort(int[] a, int start, int end)
    {
        int mid = (start + end) / 2;
        if (start < end)
        {
            // 左边
            mergeSort(a, start, mid);
            // 右边
            mergeSort(a, mid + 1, end);
            // 左右归并
            merge(a, start, mid, end);
        }
        return a;
    }

    private static void merge(int[] a, int start, int mid, int end)
    {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;

        // 把较小的数先移到新数组中
        while (i <= mid && j <= end)
        {
            if (a[i] <= a[j])
            {
                temp[k++] = a[i++];
            } else
            {
                temp[k++] = a[j++];
            }
        }

        // 把左边剩余的数移入数组
        while (i <= mid)
        {
            temp[k++] = a[i++];
        }

        // 把右边边剩余的数移入数组
        while (j <= end)
        {
            temp[k++] = a[j++];
        }

        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++)
        {
            a[k2 + start] = temp[k2];
        }
    }

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

    /**
     * 输入一个已经按从小到大排序的int数组，和一个int类型sum，输出数组中和为sum的两个元素的下标。
     * http://zhedahht.blog.163.com/blog/static/2541117420072143251809/<br>
     * https://leetcode.com/problems/two-sum/<br>
     */
    public static void sumOfTwo(int[] a, int sum)
    {
        if (a == null || a.length == 0)
            return;
        boolean found = false;
        int left = 0, right = a.length - 1;
        int index1 = 0, index2 = 0;
        while (left < right)
        {
            int curSum = a[right] + a[left];
            if (curSum == sum)
            {
                index1 = left;
                index2 = right;
                found = true;
                break;
            } else if (curSum > sum)
                right--;
            else
                left++;
        }
        if (found)
        {
            System.out.print(index1 + "," + index2);
        }
    }
}

/**
 * {@link http://blog.csdn.net/xiaoxiaoxuewen/article/details/7570621/}。<br>
 * {@link https://en.wikipedia.org/wiki/Heapsort}。<br>
 */
class HeapSortQuestion
{

    public static void sort(int[] a)
    {
        if (a == null || a.length <= 1)
        {
            return;
        }
        buildMaxHeap(a);
        for (int i = a.length - 1; i >= 1; i--)
        {
            exchange(a, 0, i);
            maxHeap(a, i, 0);
        }
    }

    private static void buildMaxHeap(int[] a)
    {
        int half = a.length / 2;
        for (int i = half; i >= 0; i--)
        {
            maxHeap(a, a.length, i);
        }
    }

    private static void maxHeap(int[] a, int heapSize, int index)
    {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;
        if (left < heapSize && a[left] > a[index])
        {
            largest = left;
        }
        if (right < heapSize && a[right] > a[largest])
        {
            largest = right;
        }
        if (index != largest)
        {
            exchange(a, index, largest);
            maxHeap(a, heapSize, largest);
        }
    }

    private static void exchange(int[] array, int index1, int index2)
    {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
