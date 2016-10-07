package algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 1.输入一个int数组，返回连续子数组元素和的最大值。<br>
 * {@link #maxSubArray(int[])}。<br>
 * 2.输入一个int数组和一个int类型sum，输出数组中和为sum的两个元素。<br>
 * {@link #twoSum(int[], int)}。<br>
 * 3.输入一个按从小到大排序的int数组和一个int类型sum，有两个元素和为sum，输出这两个元素。<br>
 * {@link #twoSum2(int[], int)}。<br>
 */
public class IntSum
{
    public static void main(String[] args)
    {
        int[] a = { 1, 2, 3, 4, 5, 6 };
        twoSum2(a, 7);
    }

    /**
     * 输入一个int数组，返回连续子数组元素和的最大值。<br>
     * http://zhedahht.blog.163.com/blog/static/254111742007219147591/<br>
     * https://leetcode.com/problems/maximum-subarray/<br>
     */
    public static int maxSubArray(int[] a)
    {
        int[] sum = new int[a.length];
        int max = a[0];
        sum[0] = a[0];
        for (int i = 0; i < a.length; i++)
        {
            sum[i] = a[i] + Math.max(sum[i - 1], 0);
            max = Math.max(max, sum[i]);
        }
        return max;
    }

    /**
     * 输入一个int数组和一个int类型sum，输出数组中和为sum的两个元素。<br>
     * https://leetcode.com/problems/two-sum/<br>
     * https://discuss.leetcode.com/topic/2447/accepted-java-o-n-solution/<br>
     */
    public static void twoSum(int[] a, int sum)
    {
        int num1 = 0, num2 = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++)
        {
            if (map.containsKey(sum - a[i]))
            {
                num2 = i;
                num1 = map.get(sum - a[i]);
                System.out.print(num1 + "," + num2);
                return;
            }
            map.put(a[i], i);
        }
    }

    /**
     * 输入一个按从小到大排序的int数组和一个int类型sum，有两个元素和为sum，输出这两个元素。<br>
     * http://zhedahht.blog.163.com/blog/static/2541117420072143251809/<br>
     * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/<br>
     */
    public static void twoSum2(int[] a, int sum)
    {
        if (a == null || a.length == 0) return;
        int left = 0, right = a.length - 1;
        while (left < right)
        {
            int curSum = a[left] + a[right];
            if (curSum == sum)
            {
                System.out.println("找到一个：" + a[left] + "," + a[right]);
                // 如果要输出所有的，加上下面代码并去掉return。
                // right--; left++;
                return;
            } else if (curSum > sum) right--;
            else left++;
        }
    }
}
