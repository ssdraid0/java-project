package algorithm.array;

/**
 * 1.输入一个char数组，把所有空格替换成"%20"，返回替换后的字符串。</br>
 * {@link #replaceBlank(char[])}。</br>
 * 2.输入一个char数组，输出第一个只出现一次的字符，只包含小写字母。</br>
 * {@link #firstUniqueLetter(char[])}。</br>
 * 3.输入一个字符串"I am a student"， 该方法把字符串修改为"student a am I"。</br>
 * {@link #reverseWord(char[])}。</br>
 * 4.字符串左旋转操作；循环左移字符串。</br>
 * 输入一个字符串"abcdefg"和一个整数5，该方法左旋转5位得到"cdefgab"。</br>
 * {@link #leftRotate(char[], int)}。</br>
 * 5.输入一个char数组，输出所有排列。</br>
 * {@link #permutation(char[], int, int)}。</br>
 * 6.输入一个char数组，输出所有组合。</br>
 * {@link #combination(char[])}。</br>
 */
public class CharFind
{
    public static void main(String[] args)
    {
        String s = "abcba";
        System.out.print("findFirstRepeatOnce：");
        firstUniqueLetter(s.toCharArray());
        System.out.println();
        System.out.print("replaceBlank：");
        System.out.println(replaceBlank(s.toCharArray()));
        System.out.print("leftRotate：");
        char[] leftRotate = s.toCharArray();
        leftRotate(leftRotate, 2);
        System.out.println(leftRotate);
        System.out.print("reverseWord：");
        char[] reverseWord = s.toCharArray();
        reverseWord(reverseWord);
        System.out.println(reverseWord);
        System.out.print("maxNumber：");
        // char c1[] = { 'a', 'b', 'c' };
        // permutation(c1);
        // char c2[] = { 'a', 'b', 'c', 'a' };
        // permutationWithRe(c2);
        String string = "abc";
        combination(string.toCharArray());
        System.out.println();
        String s1 = "abbaaaaa";
        // longestPalindromic(s1.toCharArray());
        toZigZag(s1.toCharArray(), 3);
    }

    /**
     * 输入一个char数组，把所有空格替换成"%20"，返回替换后的字符串。</br>
     */
    public static char[] replaceBlank(char[] c)
    {
        if (c.length == 0) return null;
        char[] newC = new char[c.length * 3];
        int length = 0;
        for (int i = 0; i < c.length; i++)
        {
            if (c[i] == ' ')
            {
                newC[length++] = '%';
                newC[length++] = '2';
                newC[length++] = '0';
            } else
            {
                newC[length++] = c[i];
            }
        }
        return newC;
    }

    /**
     * 输入一个char数组，输出第一个只出现一次的字符。</br>
     * char数组只包含小写字母。</br>
     * http://zhedahht.blog.163.com/blog/static/25411174200722191722430/</br>
     * https://leetcode.com/problems/first-unique-character-in-a-string/</br>
     * https://discuss.leetcode.com/topic/55148/java-7-lines-solution-29ms</br>
     */
    public static void firstUniqueLetter(char[] c)
    {
        int times[] = new int[26];
        for (int i = 0; i < c.length; i++)
            times[c[i] - 'a']++;
        for (int i = 0; i < c.length; i++)
        {
            if (times[c[i] - 'a'] == 1) System.out.print(c[i]);
        }
    }

    /**
     * 输入一个字符串"I am a student"， 该方法把字符串修改为"student a am I"。</br>
     * 不考虑标点符号。</br>
     * https://leetcode.com/problems/reverse-words-in-a-string/</br>
     */
    public static void reverseWord(char c[])
    {
        reverse(c, 0, c.length - 1);
        int wordStart = 0;
        for (int i = 0; i < c.length; i++)
        {
            if (c[i] == ' ')
            {
                reverse(c, wordStart, i - 1);
                wordStart = i + 1;
            } else if (i == c.length - 1)
            {
                reverse(c, wordStart, i);
            }
        }
    }

    /**
     * 字符串左旋转操作；循环左移字符串。</br>
     * 输入一个字符串"abcdefg"和一个整数 5，该方法左旋转 5位得到"cdefgab"。</br>
     * http://zhedahht.blog.163.com/blog/static/2541117420073993725873/</br>
     */
    public static void leftRotate(char[] c, int n)
    {
        n %= c.length;
        reverse(c, 0, c.length - n - 1);
        reverse(c, c.length - n, c.length - 1);
        reverse(c, 0, c.length - 1);
    }

    /**
     * 输入一个char数组，输出字符的所有排列。</br>
     * 例如输入abc，输出abc、acb、bac、bca、cab、cba。</br>
     * https://leetcode.com/problems/permutation-sequence/</br>
     */
    public static void permutation(char[] c, int start, int end)
    {
        if (start == end) // 只剩一个元素
        {
            System.out.println(c);
        } else
        {
            for (int i = start; i <= end; i++)
            {
                swap(c, i, start);
                permutation(c, start + 1, end);
                swap(c, i, start);
            }
        }
    }

    /**
     * 输入一个char数组，输出字符的所有组合。</br>
     * 例如输入abc，输出a、b、c、ab、ac、bc、abc。</br>
     * http://zhedahht.blog.163.com/blog/static/2541117420114172812217/</br>
     */
    public static void combination(char[] c)
    {
        int num = (int) Math.pow(2.0, c.length);
        for (int i = 1; i < num; i++)
        {
            for (int j = 0; j < c.length; j++)
            {
                if (((i >> j) & 1) == 1) System.out.print(c[j]);
            }
            System.out.print(",");
        }
    }

    /**
     * 输入一个char数组，输出ZigZag形式。</br>
     * 例如输入"PAYPALISHIRING"，输出"PAHNAPLSIIGYIR"。</br>
     * P-----A-----H-----N</br>
     * A--P--L--S--I--I--G</br>
     * Y------I------R-----</br>
     * https://leetcode.com/problems/zigzag-conversion/</br>
     * https://discuss.leetcode.com/topic/41037/java-solution-easy-and-clear-interesting-approach</br>
     */
    public static void toZigZag(char[] c, int depth)
    {
        if (depth <= 1) return;
        StringBuilder[] builder = new StringBuilder[depth];
        for (int i = 0; i < builder.length; i++)
            builder[i] = new StringBuilder();   // init every sb element,important step!!!!
        for (int i = 0, incre = 1, index = 0; i < c.length; i++)
        {
            builder[index].append(c[i]);
            if (index == 0) incre = 1;
            if (index == depth - 1) incre = -1;
            index += incre;
        }
        for (int i = 0; i < builder.length; i++)
        {
            System.out.print(builder[i]);
        }
    }

    /**
     * [ToDo]输入两个char数组，找出找两个char数组的最长公共子串。</br>
     * 最长公共子串：这个子串要求在原字符串中是连续的。</br>
     * http://blog.csdn.net/biangren/article/details/8038605</br>
     */
    public static void lCSubstring(char[] c1, char[] c2)
    {
        int maxLen = Math.max(c1.length, c2.length);
        int[] max = new int[maxLen];
        int[] maxIndex = new int[maxLen];
        int[] c = new int[maxLen]; // 记录对角线上的相等值的个数
        for (int i = 0; i < c2.length; i++)
        {
            for (int j = c1.length - 1; j >= 0; j--)
            {
                if (c2[i] == c1[j])
                {
                    if ((i == 0) || (j == 0)) c[j] = 1;
                    else c[j] = c[j - 1] + 1;
                } else
                {
                    c[j] = 0;
                }
                if (c[j] > max[0])
                { // 如果是大于那暂时只有一个是最长的,而且要把后面的清0;
                    max[0] = c[j]; // 记录对角线元素的最大值，之后在遍历时用作提取子串的长度
                    maxIndex[0] = j; // 记录对角线元素最大值的位置
                    for (int k = 1; k < maxLen; k++)
                    {
                        max[k] = 0;
                        maxIndex[k] = 0;
                    }
                } else if (c[j] == max[0])
                { // 有多个是相同长度的子串
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
        }
        for (int j = 0; j < maxLen; j++)
        {
            if (max[j] > 0)
            {
                System.out.println("第" + (j + 1) + "个公共子串:");
                for (int i = maxIndex[j] - max[j] + 1; i <= maxIndex[j]; i++)
                    System.out.print(c1[i]);
                System.out.println(" ");
            }
        }
    }

    private static void reverse(char[] c, int start, int end)
    {
        for (int i = start, j = end; i < j; i++, j--)
        {
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
        }
    }

    private static void swap(char[] c, int i, int j)
    {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
}
