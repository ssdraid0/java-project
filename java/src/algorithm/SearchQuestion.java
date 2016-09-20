package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 1.输入一个数组和值，使用二分查找，返回值在数组中的位置。<br>
 * {@link #binarySearch(int[], int)}。<br>
 * 2.输入一个数组，这个数组是另一个递增排序的数组的一个旋转数组，通过二分法输出最小元素。<br>
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，数组{3,4,5,1,2}的最小值为 1。<br>
 * {@link #findMin(int[])}。<br>
 * 3.输入一个int数组，返回连续最长递增子序列的长度。<br>
 * 例如：输入[100, 4, 200, 1, 3, 2]，返回{1, 2, 3, 4}的长度4。<br>
 * {@link #findLCS(int[])}。<br>
 */
public class SearchQuestion
{
    public static void main(String[] args)
    {
        // int[] a = { 1, 3, 5, 7, 9 };
        // System.out.println(binarySearch(a, 1));
        // System.out.println(binarySearch(a, 3));
        // System.out.println(binarySearch(a, 5));
        // System.out.println(binarySearch(a, 7));
        // System.out.println(binarySearch(a, 9));
        // System.out.println(binarySearch(a, 10));
        int[] a2 = { 100, 4, 200, 2, 6, 3, 5 };
        System.out.println(findLCS(a2));
        int[] a3 = topK(a2, 3);
        for (int i = 0; i < a3.length; i++)
        {
            System.out.print(a3[i] + ",");
        }
    }

    /**
     * 输入一个int数组和int类型key，使用二分查找，返回key在数组中的位置。<br>
     */
    public static int binarySearch(int[] a, int key)
    {
        int start = 0;
        int end = a.length - 1;
        while (start <= end)
        {
            int mid = (start + end) >>> 1;
            if (a[mid] < key)
                start = mid + 1;
            else if (a[mid] > key)
                end = mid - 1;
            else
                return mid;
        }
        return -1;
    }

   

    /**
     * 输入一个数组，这个数组是另一个递增排序的数组的一个旋转数组，通过二分法输出最小元素。<br>
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，数组{3,4,5,1,2}的最小值为 1。<br>
     * https://leetcode.com/problems/search-in-rotated-sorted-array/<br>
     */
    public static int findMin(int[] a)
    {
        return findMin(a, 0, a.length - 1);
    }

    private static int findMin(int[] a, int first, int last)
    {
        if (first + 1 == last || first == last)
            return a[last] < a[first] ? a[last] : a[first];
        int index = (first + last) / 2;
        if (a[first] == a[index] && a[last] == a[index])
        {// 此时两边中间都一样，考虑到特殊情况，我们两遍均遍历一次，进行最后的比较大小。
            int find1 = findMin(a, first, index);
            int find2 = findMin(a, index + 1, last);
            return find1 < find2 ? find1 : find2;
        } else if (a[index] >= a[first] && a[index] > a[last])
            return findMin(a, index + 1, last);
        else
            return findMin(a, first, index);
    }

    /**
     * [ToDo]输入一个数组，输出最长递增序列。 <br>
     * 例如输入{1, 10,12, 11, 4, 100, 3, 2}，输出"1,2,3,4"。<br>
     */
    public static void findLIS(int[] a)
    {
        int[] b = new int[a.length + 1];// 数组B；
        b[0] = Integer.MIN_VALUE;// 把B[0]设为最小，假设任何输入都大于；
        b[1] = a[0];// 初始时，最大递增子序列长度为1的最末元素为a1
        int lisLength = 1;// Len为当前最大递增子序列长度，初始化为1；
        int start, end, mid;// p,r,m分别为二分查找的上界，下界和中点；
        for (int i = 1; i < a.length; i++)
        {
            start = 0;
            end = lisLength;
            while (start <= end)// 二分查找最末元素小于ai+1的长度最大的最大递增子序列；
            {
                mid = (start + end) >> 1;
                if (b[mid] < a[i])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
            b[start] = a[i];// 将长度为p的最大递增子序列的当前最末元素置为ai+1;
            if (start > lisLength)
                lisLength++;// 更新当前最大递增子序列长度；
        }
        System.out.println(lisLength);
    }

    /**
     * 输入一个int数组，返回连续最长递增子序列的长度。 <br>
     * 例如：输入[100,5,200,2,6,3,4]，返回{2,3,4,5,6}的长度4。<br>
     * https://leetcode.com/problems/longest-consecutive-sequence/<br>
     */
    public static int findLCS(int[] num)
    {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : num)
        {
            if (!map.containsKey(n))
            {
                int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
                int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
                int sum = left + right + 1;
                map.put(n, sum);
                result = Math.max(result, sum);
                if (left != 0)
                    map.put(n - left, sum);
                if (right != 0)
                    map.put(n + right, sum);
            }
        }
        return result;
    }
    
    /**
     * 输入一个int数组和一个int类型k，找出int数组中最大的k个数，<br>
     * 存储到另一个数组，最后返回这个数组。<br>
     * http://zhedahht.blog.163.com/blog/static/2541117420072432136859/<br>
     * http://www.cnblogs.com/big-sun/p/4085793.html<br>
     */
    public static int[] topK(int[] a, int k)
    {
        int heap[] = createHeap(a, k);
        for (int i = k; i < a.length; i++)
        {
            if (a[i] > heap[0])
            {
                insertHeap(heap, a[i]);
            }
        }
        return heap;
    }

    private static int[] createHeap(int[] a, int k)
    {
        int[] heap = new int[k];
        for (int i = 0; i < k; i++)
        {
            heap[i] = a[i];
        }
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
            if (left < heap.length && heap[parent] > heap[left])
                minIndex = left;
            if (right < heap.length && heap[minIndex] > heap[right])
                minIndex = right;
            if (minIndex == parent)
                break;
            else
            {
                int temp = heap[parent];
                heap[parent] = heap[minIndex];
                heap[minIndex] = temp;
                parent = minIndex;
            }
        }
    }

    @SuppressWarnings("unused")
    private static void findSmallTest()
    {
        int[] a = { 3, 4, 5, 1, 2 };
        int[] a2 = { 2, 2, 1, 1 };
        int[] a3 = { 3, 3, 1, 2 };
        int[] a4 = { 2, 3, 1, 1 };
        System.out.println(findMin(a));
        System.out.println(findMin(a2));
        System.out.println(findMin(a3));
        System.out.println(findMin(a4));
    }
}
