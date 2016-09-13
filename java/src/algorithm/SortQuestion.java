package algorithm;

/**
 * 1.有哪些常见排序算法？最好，平均，最坏时间复杂度是多少？空间复杂度是多少？<br>
 * 选择排序：n^2，n^2，n^2。1。<br>
 * 冒泡排序：n，n^2，n^2。1。<br>
 * 快速排序：nlogn，nlogn，n^2。<br>
 * 归并排序：nlogn，nlogn，nlogn。<br>
 * 堆排序：nlogn，nlogn，nlogn。<br>
 * Timsort：n，nlogn，nlogn。<br>
 */
public class SortQuestion
{
    public static void main(String[] args)
    {
        int[] a = { 2, 5, 3, 8, 7, 6 };
        // SelectSortQuestion.sort(a);
        // BubbleSortQuestion.sort(a);
        QuickSortQuestion.sort(a);
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(i);
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
 * 1.<br>
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
