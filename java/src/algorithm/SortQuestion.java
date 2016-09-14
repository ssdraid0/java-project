package algorithm;

/**
 * 1.有哪些常见排序算法？最好，平均，最坏时间复杂度是多少？空间复杂度是多少？<br>
 * 选择排序：n^2，n^2，n^2。1。<br>
 * 冒泡排序：n，n^2，n^2。1。<br>
 * 快速排序：nlogn，nlogn，n^2。<br>
 * 归并排序：nlogn，nlogn，nlogn。<br>
 * 堆排序：nlogn，nlogn，nlogn。<br>
 * Timsort：n，nlogn，nlogn。<br>
 * <br>
 * 2.实现冒泡排序，快速排序，堆排序，归并排序。<br>
 * 冒泡排序：{@link BubbleSortQuestion#sort(int[])}。<br>
 * 快速排序：{@link QuickSortQuestion#sort(int[])}。<br>
 * 堆排序：{@link HeapSortQuestion#sort(int[])}。<br>
 * 归并排序：{@link MergeSortQuestion#sort(int[])}。<br>
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
        MergeSortQuestion.sort(a);
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i]);
        }
    }
}

class SelectSortQuestion
{
    public static void sort(int[] a)
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
}

class BubbleSortQuestion
{
    public static void sort(int[] a)
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
}

/**
 * {@link https://en.wikipedia.org/wiki/Quicksort}。
 */
class QuickSortQuestion
{
    public static void sort(int[] a)
    {
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int l, int r)
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
            sort(a, l, i - 1); // 递归调用
            sort(a, i + 1, r);
        }
    }
}

/**
 * {@link https://en.wikipedia.org/wiki/Heapsort}。
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

/**
 * {@link https://en.wikipedia.org/wiki/Merge_sort}。
 */
class MergeSortQuestion
{
    public static void sort(int[] a)
    {
        sort(a, 0, a.length - 1);
    }

    private static int[] sort(int[] a, int low, int high)
    {
        int mid = (low + high) / 2;
        if (low < high)
        {
            // 左边
            sort(a, low, mid);
            // 右边
            sort(a, mid + 1, high);
            // 左右归并
            merge(a, low, mid, high);
        }
        return a;
    }

    private static void merge(int[] nums, int low, int mid, int high)
    {
        int[] temp = new int[high - low + 1];
        int i = low;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;

        // 把较小的数先移到新数组中
        while (i <= mid && j <= high)
        {
            if (nums[i] <= nums[j])
            {
                temp[k++] = nums[i++];
            } else
            {
                temp[k++] = nums[j++];
            }
        }

        // 把左边剩余的数移入数组
        while (i <= mid)
        {
            temp[k++] = nums[i++];
        }

        // 把右边边剩余的数移入数组
        while (j <= high)
        {
            temp[k++] = nums[j++];
        }

        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++)
        {
            nums[k2 + low] = temp[k2];
        }
    }
}
