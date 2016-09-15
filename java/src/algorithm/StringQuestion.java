package algorithm;

import java.util.LinkedHashMap;

/**
 * 1.把字符串中的每个空格替换成"%20"。<br>
 * {@link StringQuestion#replaceBlank(String)}。<br>
 * 2.找出第一个只出现一次的字符位置。<br>
 * {@link StringQuestion#findFirstRepeatOnce(String)}。<br>
 * 3.翻转句子中单词的顺序。<br>
 * {@link StringQuestion#reverseSentence(String)}。<br>
 * 4.实现字符串左旋转操作。<br>
 * {@link StringQuestion#leftRotateString(String, int)}。<br>
 * 5.输出字符串中字符的所有排列。<br>
 * {@link StringQuestion#permutation(char[], int, int)}。<br>
 */
public class StringQuestion
{
    public static void main(String[] args)
    {
        String s = "abcba";
        System.out.println(findFirstRepeatOnce(s));
        permutation(s.toCharArray(), 0, s.length() - 1);
    }

    /**
     * 把字符串中的每个空格替换成"%20"。<br>
     */
    public static String replaceBlank(String s)
    {
        if (s == null)
            return null;
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == ' ')
            {
                sBuilder.append("%20");
            } else
            {
                sBuilder.append(s.charAt(i));
            }
        }
        return new String(sBuilder);
    }

    /**
     * 找出第一个只出现一次的字符。
     */
    public static Character findFirstRepeatOnce(String s)
    {
        if (s == null)
            return null;
        char[] strChar = s.toCharArray();
        LinkedHashMap<Character, Integer> hash = new LinkedHashMap<Character, Integer>();
        for (char item : strChar)
        {
            if (hash.containsKey(item))
                hash.put(item, hash.get(item) + 1);
            else
                hash.put(item, 1);
        }
        for (char key : hash.keySet())
        {
            if (hash.get(key) == 1)
                return key;
        }
        return null;
    }

    /**
     * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。<br>
     * 为简单起见，标点符号和普通字母一样处理。例如输入字符串" I am a student."， 则输出" student. a am I" .<br>
     */
    public static void reverseSentence(String s)
    {
        if (s == null)
            return;
        String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--)
        {
            sb.append(str[i] + " ");
        }
        System.out.println(sb);
    }

    /**
     * 实现字符串左旋转操作。<br>
     * 比如输入字符串“ abcdefg”和 数字 2。该方法左旋转 2 位得到的结果“ cdefgab"。<br>
     */
    public static void leftRotateString(String sentence, int index)
    {
        if (sentence == null || index > sentence.length() || index < 0)
        {
            return;
        }
        String[] splitString = { sentence.substring(0, index), sentence.substring(index, sentence.length()) };
        StringBuilder resultbBuffer = new StringBuilder();
        for (int i = splitString.length - 1; i >= 0; i--)
        {
            resultbBuffer.append(splitString[i]);
        }
        System.out.println(resultbBuffer.toString());
    }

    /**
     * 输出字符串中字符的所有排列，允许重复的排列。
     */
    public static void permutation(String s)
    {
        permutation(s.toCharArray(), 0, s.length() - 1);
    }

    private static void permutation(char[] c, int begin, int end)
    {
        if (begin == end - 1) // 只剩一个元素
        {
            System.out.println(c);
        } else
        {
            for (int i = begin; i < end; i++)
            {
                swap(c, i, begin);
                permutation(c, begin + 1, end);
                swap(c, i, begin);
            }
        }
    }

    private static void swap(char[] c, int i, int j)
    {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
}
