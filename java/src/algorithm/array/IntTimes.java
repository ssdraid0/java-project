package algorithm.array;

import java.util.Arrays;

import algorithm.SearchQuestion;

/**
 * 1.输入一个int数组，其中只有一个数字出现一次，其余数字都出现两次，返回这个数字。</br>
 * {@link #oneNum(int[])}。</br>
 * 2.输入一个int数组，其中只有两个数字出现一次，其余数字都出现两次，输出这两个数字。</br>
 * {@link #twoNum(int[])}。</br>
 * 3.输入一个int数组，其中只有一个数字出现次数超过数组长度的一半，返回这个数字。</br>
 * {@link #moreThanHalf(int[])}。</br>
 * 4.输入一个按从小到大排序的int数组和一个int类型k，返回k的出现次数。</br>
 * {@link #timesOfK(int[], int)}。</br>
 */
public class IntTimes
{
    public static void main(String[] args)
    {
        int[] a = { 1, 1, 1, 1, 1 };
        int[] b = { 4, 5, 6 };
        System.out.println(median(a, b));
        System.out.println(timesOfK(a, 2));
    }

    /**
     * 输入一个int数组，其中只有一个数字出现一次，其余数字都出现两次。返回这个数字。</br>
     * 0^a=a</br>
     * a^b=b^a</br>
     * a^a=0</br>
     * https://leetcode.com/problems/single-number/</br>
     */
    public static int oneNum(int[] nums)
    {
        int num = 0;
        for (int i = 0; i < nums.length; i++)
            num ^= nums[i];
        return num;
    }

    /**
     * 输入一个int数组，其中只有两个数字出现一次，其余数字都出现两次。输出这两个数字。</br>
     * http://zhedahht.blog.163.com/blog/static/2541117420071128950682/</br>
     * https://leetcode.com/problems/single-number-iii/</br>
     */
    public static void twoNum(int[] nums)
    {
        int num = 0;
        for (int i = 0; i < nums.length; i++)
            num ^= nums[i];
        int indexOf1 = findFirstBitIs1(num);
        int num1 = 0, num2 = 0;
        for (int i = 0; i < nums.length; ++i)
        {
            // 以第indexOf1位是不是1为标准把原数组分成两个子数组
            if (isBit1(nums[i], indexOf1)) num1 ^= nums[i];
            else num2 ^= nums[i];
        }
        System.out.print(num1 + "," + num2);
    }

    /**
     * 输入一个int数组，其中只有三个数字出现一次，其余数字都出现两次。输出这三个数字。</br>
     * http://zhedahht.blog.163.com/blog/static/25411174201283084246412/</br>
     */
    public static void threeNum(int[] nums)
    {
        int num = 0;
        for (int i = 0; i < nums.length; i++)
            num ^= nums[i];
        int flips = 0;
        for (int i = 0; i < nums.length; i++) // 因为出现偶数次的seq[i]和xors的异或，异或结果不改变
            flips ^= lowbit(num ^ nums[i]); // 表示的是：flips = lowbit(a^b) ^ lowbit(a^c) ^ lowbit(b^c)
        // 三个数两两异或后lowbit有两个相同，一个不同，可以分为两组
        // 所以flips的值为：lowbit(a^b) 或 lowbit(a^c) 或 lowbit(b^c)
        // 得到三个数中的一个
        int num1 = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (lowbit(nums[i] ^ num) == flips)     // 找出三个数两两异或后的lowbit与另外两个lowbit不同的那个数
                num1 ^= nums[i];
        }
        // 找出后，与数组中最后一个值交换，利用twoSingleNum，找出剩余的两个
        for (int i = 0; i < nums.length; i++)
        {
            if (num1 == nums[i])
            {
                int temp = nums[i];
                nums[i] = nums[nums.length - 1];
                nums[nums.length - 1] = temp;
            }
        }
        System.out.print(num1 + ",");
        twoNum(Arrays.copyOfRange(nums, 0, nums.length - 1));
    }

    /**
     * 输入一个按从小到大排序的int数组和一个int类型k，返回k的出现次数。</br>
     */
    public static int timesOfK(int[] a, int k)
    {
        int number = 0;
        if (a != null)
        {
            int first = SearchQuestion.binarySearchFirst(a, k);
            int last = SearchQuestion.binarySearchLast(a, k);
            if (first != -1 && last != -1) number = last - first + 1;
        }
        return number;
    }

    /**
     * 输入一个int数组，数组中有一个数字出现次数超过数组长度的一半，返回这个数字。</br>
     * http://zhedahht.blog.163.com/blog/static/25411174201085114733349/</br>
     */
    public static int moreThanHalf(int[] nums)
    {
        int times = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (times == 0)
            {
                result = nums[i];
                times = 1;
            } else if (nums[i] == result) times++;
            else times--;
        }
        return result;
    }

    /**
     * 输入两个int类型数组，计算中位数并返回。</br>
     * https://leetcode.com/problemset/algorithms/</br>
     * https://discuss.leetcode.com/topic/4996/share-my-o-log-min-m-n-solution-with-explanation</br>
     */
    public static double median(int[] nums1, int[] nums2)
    {
        int length1 = nums1.length;
        int length2 = nums2.length;
        if (length1 > length2) return median(nums2, nums1);
        int i = 0, j = 0, min = 0, max = length1, half = (length1 + length2 + 1) / 2;
        double maxLeft = 0, minRight = 0;
        while (min <= max)
        {
            i = (min + max) / 2;
            j = half - i;
            if (j > 0 && i < length1 && nums2[j - 1] > nums1[i]) min = i + 1;
            else if (i > 0 && j < length2 && nums1[i - 1] > nums2[j]) max = i - 1;
            else
            {
                if (i == 0) maxLeft = (double) nums2[j - 1];
                else if (j == 0) maxLeft = (double) nums1[i - 1];
                else maxLeft = (double) Math.max(nums1[i - 1], nums2[j - 1]);
                break;
            }
        }
        if ((length1 + length2) % 2 == 1) return maxLeft;
        if (i == length1) minRight = (double) nums2[j];
        else if (j == length2) minRight = (double) nums1[i];
        else minRight = (double) Math.min(nums1[i], nums2[j]);
        return (double) (maxLeft + minRight) / 2;
    }

    /**
     * 找到num的二进制从右到左第一个为1的位置。</br>
     */
    private static int findFirstBitIs1(int num)
    {
        int indexBit = 0;
        while ((num & 1) == 0)
        {
            num = num >> 1;
            indexBit++;
        }
        return indexBit;
    }

    /**
     * 判断num的二进制从右到左的第index位是否为1。</br>
     */
    private static boolean isBit1(int num, int index)
    {
        num = num >> index;
        return (num & 1) == 1;
    }

    private static int lowbit(int x)
    {
        return x & ~(x - 1);
    }
}
