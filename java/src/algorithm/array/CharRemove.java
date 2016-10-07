package algorithm.array;

/**
 * 1.输入一个char数组，删除所有空格，返回删除后的长度。</br>
 * {@link #removeBlank(char[])}。</br>
 * </br>
 * 2.输入一个char数组c，和一个char数组remove，删除c数组中在remove数组也出现的字符，</br>
 * 返回删除后c数组的长度。</br>
 * {@link #removeChar(char[], char[])}。</br>
 * </br>
 */
public class CharRemove
{
    /**
     * 输入一个char数组，删除所有空格，返回删除后的长度。</br>
     */
    public static int removeBlank(char[] c)
    {
        if (c == null || c.length == 0) return 0;
        int length = 0;
        for (int i = 0; i < c.length; i++)
        {
            if (c[i] != ' ')
            {
                c[length++] = c[i];
            }
        }
        return length;
    }

    /**
     * 输入一个char数组c，和一个char数组remove，删除c数组中在remove数组也出现的字符，</br>
     * 返回删除后c数组的长度。</br>
     * http://zhedahht.blog.163.com/blog/static/25411174200801931426484/</br>
     */
    public static int removeChar(char[] c, char[] remove)
    {
        if (c == null || c.length == 0) return 0;
        if (remove == null || remove.length == 0) return c.length;
        boolean[] contains = new boolean[256];
        for (int i = 0; i < remove.length; i++)
        {
            contains[remove[i]] = true;
        }
        int length = 0;
        for (int i = 0; i < c.length; i++)
        {
            if (contains[c[i]])
            {
                c[length++] = c[i];
            }
        }
        return length;
    }
}
