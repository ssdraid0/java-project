package algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
* 1.输入一个int数组，返回连续最长递增子序列的长度。<br>
* 例如：输入[100, 4, 200, 1, 3, 2]，返回{1, 2, 3, 4}的长度4。<br>
* {@link #longestIncreaseSeq(int[])}。<br>
*/
public class IntLongest
{
    /**
     * 输入一个int数组，返回连续最长递增子序列的长度。 <br>
     * 例如：输入[100,5,200,2,6,3,4]，返回{2,3,4,5,6}的长度4。<br>
     * https://leetcode.com/problems/longest-consecutive-sequence/<br>
     */
    public static int longestIncreaseSeq(int[] num)
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
}
