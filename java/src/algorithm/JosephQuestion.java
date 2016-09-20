package algorithm;

/**
 * 1.输入两个int类型n和m，表示0,1,2,...,n-1个这些数排成一个圆圈。<br>
 * 从数字 0 开始每次从这个圆圈里删除第 m 个数字。返回这个圆圈里剩下的最后一个数字。<br>
 * {@link #last(int, int)}<br>
 */
public class JosephQuestion
{
    public static void main(String[] args)
    {

    }

    /**
     * 输入两个整数n和m，表示0,1,2,...,n-1个这些数排成一个圆圈。<br>
     * 从数字 0 开始每次从这个圆圈里删除第 m 个数字。返回这个圆圈里剩下的最后一个数字。<br>
     */
    public static int last(int n, int m)
    {
        if (n < 1 || m < 1)
            return -1;
        int last = 0;
        for (int i = 2; i <= n; i++)
        {
            last = (last + m) % i;
        }
        return last;
    }
}
