package algorithm.剑指offer;

import java.util.Arrays;

/**
 * 面试题 44：扑克牌的顺子
 * <p>
 * 题目：从扑克牌中随机抽 5 张牌，判断是不是顺子，即这 5 张牌是不是连续的。 2-10 为数字本身， A 为 1， J 为 11， Q 为 12， K
 * 为 13，而大小王可以看成任意的 数字。
 */
public class Q44
{
    public static void main(String[] args)
    {
        int[] array =
        { 0, 4, 6, 8, 0 };
        Q44 test = new Q44();
        System.out.println(test.isContinuous(array));
    }

    public boolean isContinuous(int[] number)
    {
        if (number == null)
        {
            return false;
        }
        Arrays.sort(number);
        int numberZero = 0;
        int numberGap = 0;
        for (int i = 0; i < number.length && number[i] == 0; i++)
        {
            numberZero++;
        }
        int small = numberZero;
        int big = small + 1;
        while (big < number.length)
        {
            if (number[small] == number[big])
                return false;
            numberGap += number[big] - number[small] - 1;
            small = big;
            big++;
        }
        return (numberGap > numberZero) ? false : true;
    }
}
