package algorithm.剑指offer;

/**
 * 面试题 34：丑数
 * <p>
 * 题目：我们把只包含因子 2,3,和 5 的称为丑数。求按从小到大的顺序的第 1500 个丑数。例如 6、 8 都是丑数，但 14 不是，因为它包含因子
 * 7.习惯上我们把 1 当做第一个丑数。
 */
public class Q34
{
    public static void main(String[] args)
    {
        System.out.println(getUglyNumber(1500));
    }

    public static int getUglyNumber(int n)
    {
        if (n <= 0)
            return 0;
        int[] uglynumber = new int[n];
        uglynumber[0] = 1;
        int nextuglyindex = 1;
        int pMulitBy2 = 0;
        int pMulitBy3 = 0;
        int pMulitBy5 = 0;
        while (nextuglyindex < n)
        {
            int minnum = min(uglynumber[pMulitBy2] * 2, min(uglynumber[pMulitBy3] * 3, uglynumber[pMulitBy5] * 5));
            uglynumber[nextuglyindex] = minnum;
            while (uglynumber[pMulitBy2] * 2 <= uglynumber[nextuglyindex])
                pMulitBy2++;
            while (uglynumber[pMulitBy3] * 3 <= uglynumber[nextuglyindex])
                pMulitBy3++;
            while (uglynumber[pMulitBy5] * 5 <= uglynumber[nextuglyindex])
                pMulitBy5++;
            nextuglyindex++;
        }
        int answer = uglynumber[nextuglyindex - 1];
        return answer;
    }

    private static int min(int i, int j)
    {
        if (i <= j)
            return i;
        else
        {
            return j;
        }
    }
}
