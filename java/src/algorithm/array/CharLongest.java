package algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 1.输入一个char数组，输出连续最长的数字子数组。</br>
 * {@link #longestNum(char[])}。</br>
 * 2.输入一个char数组，输出连续最长不重复的子数组。</br>
 * {@link #longestNotRepeat(char[])}。</br>
 */
public class CharLongest
{
    public static void main(String[] args)
    {
        String s = "abc123cba1234cba";
        longestNum(s.toCharArray());
        String s1 = "BDCABA";
        String s2 = "ABCBDAB";
        longestCommon(s1.toCharArray(), s2.toCharArray());
        System.out.println();
        longestCommon2(s1.toCharArray(), s2.toCharArray());
    }

    /**
     * 输入一个char数组，输出连续最长的数字子数组。</br>
     */
    public static void longestNum(char[] c)
    {
        StringBuilder maxStr = new StringBuilder();
        StringBuilder curStr = new StringBuilder();
        for (int i = 0; i < c.length; i++)
        {
            if (!Character.isDigit(c[i]))
            {
                curStr = null;
                continue;
            }
            if (curStr == null)
            {
                curStr = new StringBuilder(Character.toString(c[i]));
            } else
            {
                curStr.append(c[i]);
            }
            if (curStr.length() > maxStr.length())
                maxStr = curStr;
        }
        System.out.println("连续最长的数字子数组：" + maxStr);
    }

    /**
     * 输入一个char数组，输出连续最长不重复的子数组。 </br>
     * 例如：输入abcabcdabc，输出abcd。</br>
     * https://discuss.leetcode.com/topic/8232/11-line-simple-java-solution-o-n-with-explanation</br>
     * https://leetcode.com/problems/longest-substring-without-repeating-characters/</br>
     */
    public static void longestNotRepeat(char[] c)
    {
        if (c == null || c.length == 0)
            return;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int first = 0;
        for (int i = 0, j = 0; i < c.length; i++)
        {
            if (map.containsKey(c[i]))
            {
                j = Math.max(j, map.get(c[i]) + 1);
            }
            map.put(c[i], i);
            if (max < i - j + 1)
            {
                max = i - j + 1;
                first = j;
            }
        }
        for (int i = 0; i < max; i++)
            System.out.print("连续最长不重复的子数组：" + c[first + i]);
    }

    /**
     * [ToDo]输入两个char数组，输出两个char数组的最长公共子序列的长度。</br>
     * 不要求连续。</br>
     * http://blog.csdn.net/biangren/article/details/8038605</br>
     */
    public static void longestCommon(char[] c1, char[] c2)
    {
        int[] len = new int[c2.length];
        int[] diagonal = new int[c2.length - 1];
        StringBuilder builder = null;
        for (int d = 0; d < c1.length; d++)
        {
            for (int w = 0; w < c2.length; w++)
            {
                if (d == 0 && w == 0)
                {
                    if (c1[d] == c2[w])
                    {
                        len[w] = 1;
                        if (builder == null)
                            builder = new StringBuilder(c1[d]);
                    }
                } else if (d == 0 && w > 0)
                {
                    if (c1[d] == c2[w])
                    {
                        len[w] = 1;
                        if (builder == null)
                            builder = new StringBuilder(c1[d]);
                    } else
                        len[w] = len[w - 1];
                } else if (d > 0 && w == 0)
                {
                    if (c1[d] == c2[w])
                    {
                        len[w] = 1;
                        if (builder == null)
                            builder = new StringBuilder(c1[d]);
                    }
                } else if (d > 0 && w > 0)
                {
                    if (c1[d] == c2[w])
                    {
                        len[w] = diagonal[w - 1] + 1;
                        if (builder == null)
                            builder = new StringBuilder(c1[d]);
                        else
                            builder.append(c1[d]);
                    } else
                        len[w] = Math.max(len[w - 1], len[w]);
                }
            }
            for (int w = 0; w < len.length - 1; w++)
                diagonal[w] = len[w];
        }
        System.out.println("最长公共子序列长度：" + len[len.length - 1]);
        System.out.println("最长公共子序列：" + builder);
    }

    /**
     *  [ToDo]输入两个char数组，找出找两个char数组的最长公共子串。</br>
     * 要求连续。</br>
     * http://blog.csdn.net/biangren/article/details/8038605</br>
     * https://en.wikipedia.org/wiki/Longest_common_substring_problem</br>
     */
    public static void longestCommon2(char[] str1, char[] str2)
    {
        int len1, len2;
        len1 = str1.length;
        len2 = str2.length;
        int maxLen = len1 > len2 ? len1 : len2;

        int[] max = new int[maxLen];// 保存最长子串长度的数组
        int[] maxIndex = new int[maxLen];// 保存最长子串长度最大索引的数组
        int[] c = new int[maxLen];

        int i, j;
        for (i = 0; i < len2; i++)
        {
            for (j = len1 - 1; j >= 0; j--)
            {
                if (str2[i] == str1[j])
                {
                    if ((i == 0) || (j == 0))
                        c[j] = 1;
                    else
                        c[j] = c[j - 1] + 1;// 此时C[j-1]还是上次循环中的值，因为还没被重新赋值
                } else
                {
                    c[j] = 0;
                }
                // 如果是大于那暂时只有一个是最长的,而且要把后面的清0;
                if (c[j] > max[0])
                {
                    max[0] = c[j];
                    maxIndex[0] = j;

                    for (int k = 1; k < maxLen; k++)
                    {
                        max[k] = 0;
                        maxIndex[k] = 0;
                    }
                }
                // 有多个是相同长度的子串
                else if (c[j] == max[0])
                {
                    for (int k = 1; k < maxLen; k++)
                    {
                        if (max[k] == 0)
                        {
                            max[k] = c[j];
                            maxIndex[k] = j;
                            break; // 在后面加一个就要退出循环了
                        }
                    }
                }
            }
            for (int temp : c)
            {
                System.out.print(temp);
            }
            System.out.println();
        }
        // 打印最长子字符串
        for (j = 0; j < maxLen; j++)
        {
            if (max[j] > 0)
            {
                System.out.println("第" + (j + 1) + "个公共子串:");
                for (i = maxIndex[j] - max[j] + 1; i <= maxIndex[j]; i++)
                    System.out.print(str1[i]);
                System.out.println(" ");
            }
        }
    }

    /**
     * 输入一个char数组，输出最长回文字符串。</br>
     * https://leetcode.com/problems/longest-palindromic-substring/</br>
     * https://discuss.leetcode.com/topic/21848/ac-relatively-short-and-very-clear-java-solution</br>
     */
    public static void longestPalindromic(char[] c)
    {
        int length = 0, start = 0, end = 0;
        for (int i = 0; i < c.length; i++)
        {
            if (isPalindrome(c, i - length - 1, i))
            {
                start = i - length - 1;
                end = i;
                length = length + 2;
            } else if (isPalindrome(c, i - length, i))
            {
                start = i - length;
                end = i;
                length = length + 1;
            }
        }
        for (int i = start; i <= end; i++)
            System.out.print(c[i]);
    }

    private static boolean isPalindrome(char[] c, int begin, int end)
    {
        if (begin < 0)
            return false;
        while (begin < end)
        {
            if (c[begin++] != c[end--])
                return false;
        }
        return true;
    }
}
