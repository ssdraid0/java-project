package algorithm.剑指offer;

import java.util.LinkedHashMap;

/**
 * 面试题 35：第一个只出现一次的字符 题目：在字符串中找出第一个只出现一次的字符。如果输入" abaccdeff"，则 输出'b'。
 */
public class Q35
{

    public static void main(String[] args)
    {
        System.out.print(firstNotRepeatChar("agbaccdeff"));
    }

    public static Character firstNotRepeatChar(String str)
    {
        if (str == null)
            return null;
        char[] strChar = str.toCharArray();
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
}
