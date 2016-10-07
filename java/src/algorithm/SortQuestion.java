package algorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1.有哪些常见排序算法？最好，平均，最坏时间复杂度是多少？空间复杂度是多少？是否稳定？</br>
 * 选择排序：n^2，n^2，n^2。1。不稳定。</br>
 * 冒泡排序：n，n^2，n^2。1。稳定。</br>
 * 快速排序：nlogn，nlogn，n^2。不稳定。</br>
 * 堆排序：nlogn，nlogn，nlogn。不稳定。</br>
 * 归并排序：nlogn，nlogn，nlogn。稳定。</br>
 * Timsort：n，nlogn，nlogn。稳定。</br>
 * </br>
 * 2.实现冒泡排序，快速排序，堆排序，归并排序，折半插入排序。</br>
 * 冒泡排序：{@link #bubbleSort(int[])}。</br>
 * 快速排序：{@link #quickSort(int[], int, int)}。</br>
 * 堆排序：{@link #heapSort(int[])}。</br>
 * 归并排序：{@link #mergeSort(int[], int, int)}。</br>
 * </br>
 * 3.输入一个int数组，把奇数放到左边。</br>
 * {@link #moveOddToLeft(int[])}。</br>
 */
public class SortQuestion
{
    public static void main(String[] args)
    {
        int[] a = { 16, 7, 3, 20, 17, 8 };
        // SelectSortQuestion.sort(a);
        // BubbleSortQuestion.sort(a);
        // QuickSortQuestion.sort(a);
        // insertSort(a);
        binaryInsertSort(a);
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

    public static void quickSort(int[] a, int start, int end)
    {
        if (start < end)
        {
            int left = start, right = end, x = a[start];
            while (left < right)
            {
                // 从右向左找第一个小于x的数
                while (left < right && a[right] >= x)
                    right--;
                if (left < right) a[left++] = a[right];
                // 从左向右找第一个大于等于x的数
                while (left < right && a[left] < x)
                    left++;
                if (left < right) a[right--] = a[left];
            }
            a[left] = x;
            quickSort(a, start, left - 1);
            quickSort(a, left + 1, end);
        }
    }

    /**
     * https://en.wikipedia.org/wiki/Merge_sort</br>
     */
    public static void mergeSort(int[] a, int start, int end)
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
            if (a[i] <= a[j]) temp[k++] = a[i++];
            else temp[k++] = a[j++];
        }
        // 把左边剩余的数移入数组
        while (i <= mid)
            temp[k++] = a[i++];
        // 把右边剩余的数移入数组
        while (j <= end)
            temp[k++] = a[j++];
        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++)
            a[k2 + start] = temp[k2];
    }

    /**
     * http://blog.csdn.net/xiaoxiaoxuewen/article/details/7570621/</br>
     * https://en.wikipedia.org/wiki/Heapsort</br>
     */
    public static void heapSort(int[] a)
    {
        if (a == null || a.length <= 1) return;
        // 获得初始堆
        for (int i = a.length >> 1; i >= 0; i--)
            maxHeap(a, a.length, i);
        // 调整初始堆
        for (int i = a.length - 1; i >= 1; i--)
        {
            int t = a[i];
            a[i] = a[0];
            a[0] = t;
            maxHeap(a, i, 0);
        }
    }

    private static void maxHeap(int[] a, int heapSize, int index)
    {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;
        if (left < heapSize && a[left] > a[index]) largest = left;
        if (right < heapSize && a[right] > a[largest]) largest = right;
        if (index != largest)
        {
            int t = a[index];
            a[index] = a[largest];
            a[largest] = t;
            maxHeap(a, heapSize, largest);
        }
    }

    /**
     * {@link Arrays#sort(int[])}</br>
     * https://en.wikipedia.org/wiki/Insertion_sort</br>
     */
    public static void insertSort(int[] a)
    {
        for (int i = 0, j = i; i < a.length - 1; i++, j = i)
        {
            int ai = a[i + 1];
            while (ai < a[j])
            {
                a[j + 1] = a[j];
                if (j-- == 0) break;
            }
            a[j + 1] = ai;
        }
    }

    /**
     * {@link Arrays#sort(Object[], Comparator)}</br>
     */
    public static void binaryInsertSort(int[] a)
    {
        for (int i = 1; i < a.length; i++)
        {
            int t = a[i];
            int low = 0;
            int high = i - 1;
            while (low <= high)
            {
                int mid = (low + high) / 2;
                if (t < a[mid]) high = mid - 1;
                else low = mid + 1;
            }
            for (int j = i; j >= low + 1; j--)
            {
                a[j] = a[j - 1];
            }
            a[low] = t;
        }
    }

    /**
     * 输入一个int数组，把奇数放到左边。</br>
     * http://zhedahht.blog.163.com/blog/static/25411174200741295930898/</br>
     */
    public static void moveOddToLeft(int a[])
    {
        if (a == null) return;
        int begin = 0;
        int end = a.length - 1;
        while (begin < end)
        {
            if (a[begin] % 2 != 0)
            {
                begin++;
                continue;
            }
            if (a[end] % 2 == 0)
            {
                end--;
                continue;
            }
            int temp = a[begin];
            a[begin] = a[end];
            a[end] = temp;
        }
    }

    /**
     * 输入一个int数组和一个int类型k，找出int数组中最大的k个数，</br>
     * 存储到另一个数组，最后返回这个数组。</br>
     * http://zhedahht.blog.163.com/blog/static/2541117420072432136859/</br>
     * http://www.cnblogs.com/big-sun/p/4085793.html</br>
     */
    public static int[] topK(int[] a, int k)
    {
        int heap[] = createHeap(a, k);
        for (int i = k; i < a.length; i++)
        {
            if (a[i] > heap[0]) insertHeap(heap, a[i]);
        }
        return heap;
    }

    private static int[] createHeap(int[] a, int k)
    {
        int[] heap = new int[k];
        for (int i = 0; i < k; i++)
            heap[i] = a[i];
        for (int i = 1; i < k; i++)
        {
            int child = i;
            int parent = (i - 1) / 2;
            while (parent >= 0 && child != 0 && heap[parent] > a[i])
            {
                heap[child] = heap[parent];
                child = parent;
                parent = (parent - 1) / 2;
            }
            heap[child] = a[i];
        }
        return heap;
    }

    private static void insertHeap(int[] heap, int value)
    {
        heap[0] = value;
        int parent = 0;
        while (parent < heap.length)
        {
            int left = 2 * parent + 1, right = 2 * parent + 2;
            int minIndex = parent;
            if (left < heap.length && heap[parent] > heap[left]) minIndex = left;
            if (right < heap.length && heap[minIndex] > heap[right]) minIndex = right;
            if (minIndex == parent) break;
            else
            {
                int temp = heap[parent];
                heap[parent] = heap[minIndex];
                heap[minIndex] = temp;
                parent = minIndex;
            }
        }
    }
}
