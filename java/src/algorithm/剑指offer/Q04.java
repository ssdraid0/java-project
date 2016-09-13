package algorithm.剑指offer;

/**
 * 面试题 4：替换空格。<br>
 * 题目：请实现一个函数，把字符串中的每个空格替换成“ %20”。<br>
 */
public class Q04
{
    public static String replaceBlank(String input)
    {
        if (input == null)
            return null;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < input.length(); i++)
        {
            if (input.charAt(i) == ' ')
            {
                stringBuilder.append("%20");
            } else
            {
                stringBuilder.append(String.valueOf(input.charAt(i)));
            }
        }
        return new String(stringBuilder);
    }

    public static void main(String[] args)
    {
        String s = "We are happy.";
        System.out.println(replaceBlank(s));
    }
}
