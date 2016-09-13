package algorithm;

import java.util.HashMap;

/**
 * 1.找出第一个出现两次的字符位置。<br>
 * {@link StringQuestion#findFirst(String)}。<br>
 * <br>
 * 2.
 */
public class StringQuestion
{
    public static void main(String[] args)
    {
        String s = "abcba";
        System.out.println(findFirst(s));
    }

    /**
     * 找出第一个只出现一次的字符的位置。
     */
    public static int findFirst(String s)
    {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (!map.containsKey(c))
            {
                map.put(c, 1);
            } else
            {
                int count = map.get(c);
                map.put(c, count + 1);
            }
        }
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (map.get(c) == 1)
            {
                return i;
            }
        }
        return -1;
    }
}
