package algorithm;

import java.util.Arrays;

/**
 * 1.输入一个int类型n，不使用递归，返回斐波那契数列的第n项。<br>
 * 0，1，1，2，3，5<br>
 * {@link #fibonacci(int)}。<br>
 * 2.输入一个double类型x和一个int类型n，返回x的n次方。<br>
 * {@link #power(double, int)}。<br>
 * 3.输入一个int类型n，n代表台阶层数，可以一次上1步，2步或3步，返回上法的数量。<br>
 * {@link #step(int)}。<br>
 * 4.输入一个int类型n，输出所有1到n以内的完美数。<br>
 * 完美数： 一个数除了自身以外的约数的和等于它本身。<br>
 * {@link #perfectNum(int)}。<br>
 * 5.输入一个int类型n，输出从1到最大的n位数。。<br>
 * {@link #printFromZeroTo(int[], int)}。<br>
 * 6.输入两个int类型n，不使用+、0 -、 *、 /，返回加法结果。<br>
 * {@link #add(int, int)}。<br>
 * 7.输入一个int类型n，打印出所有和为n连续正数序列。<br>
 * 例如：输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以输出3个连续序列1-5、4-6和7-8<br>
 * {@link #sum(int)}。<br>
 * 8.输入一个int数组，判断是不是能排序成一个顺子，<br>
 * A为1，J为11，Q为12，K为13，<br>
 * 大小王可以看成任意数字，并且可能有多个大小王。<br>
 * {@link #cards(int[])}
 */
public class MathQuestion
{
    public static void main(String[] args)
    {
        System.out.print("perfectNumber：");
        perfectNum(1000);
        System.out.println();
        System.out.print("step：" + step(10));
        System.out.println();
        System.out.println(countK(20, 1));
    }

    /**
     * 输入一个整数，输出该数二进制表示中 1 的个数。<br>
     * http://zhedahht.blog.163.com/blog/static/2541117420073118945734/<br>
     */
    public static int numberOf1(int i)
    {
        int count = 0;
        while (i != 0)
        {
            count++;
            i = (i - 1) & i;
        }
        return count;
    }

    /**
     * 输入一个int类型n，不使用递归，返回斐波那契数列的第n项。<br>
     * http://zhedahht.blog.163.com/blog/static/25411174200722991933440/<br>
     */
    public static int fibonacci(int n)
    {
        int preOne = 0;
        int preTwo = 1;
        if (n == 0)
        {
            return preOne;
        }
        if (n == 1)
        {
            return preTwo;
        }
        int result = 1;
        for (int i = 2; i <= n; i++)
        {
            result = preOne + preTwo;
            preOne = preTwo;
            preTwo = result;
        }
        return result;
    }

    /**
     * 输入一个int类型n，使用递归，返回斐波那契数列的第n项。<br>
     * http://zhedahht.blog.163.com/blog/static/25411174200722991933440/<br>
     */
    public static int fibonacciRecursive(int n)
    {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        else return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    /**
     * 输入1个double类型x和一个int类型n，求x的n次方。<br>
     */
    public static double power(double x, int n) throws Exception
    {
        double result = 0;
        if (Math.abs(x - 0) < 0.0000001)
        {
            if (n < 0) throw new Exception();
            else return 0;
        }
        if (n < 0) result = 1.0 / powerWithExp(x, -n);
        else result = powerWithExp(x, n);
        return result;
    }

    private static double powerWithExp(double x, int n)
    {
        double result = 1.0;
        for (int i = 0; i < n; i++)
            result = result * x;
        return result;
    }

    /**
     * 输入一个int类型n，n代表台阶层数，可以一次上1步，2步或3步，返回上法的数量。 分析：<br>
     * 上1层台阶，有1种上法。<br>
     * 上2层台阶，有2种上法。<br>
     * 上3层台阶，有4种上法。<br>
     * 上4层台阶，<br>
     * 第一步上1层台阶，后面的3层台阶有4种上法。<br>
     * 第一步上2层台阶，后面的2层台阶有2种上法。<br>
     * 第一步上3层台阶，后面的1层台阶有1种上法。<br>
     * 所以上4层台阶共有4+2+1种上法。<br>
     * 所以上n层台阶共有f(n-3)+f(n-2)+f(n-1)种上法。<br>
     * http://zhedahht.blog.163.com/blog/static/25411174200731844235261/<br>
     */
    public static int step(int n)
    {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        int a = 1;
        int b = 2;
        int c = 4;
        int sum = a + b + c;
        for (int i = 4; i < n; i++)
        {
            a = b;
            b = c;
            c = sum;
            sum = a + b + c;
        }
        return sum;
    }

    /**
     * 输入一个大于1的int类型n，输出所有1到n以内的完美数。<br>
     * 完美数： 一个数除了自身以外的约数的和等于它本身。<br>
     */
    public static void perfectNum(int n)
    {
        for (int i = 1; i <= n; i++)
        {
            int factorSum = 0;
            for (int j = 1; j < (i >> 1) + 1; j++)
            {
                if (i % j == 0) factorSum += j;// 能被整除的除数则被加到temp中
            }
            if (factorSum == i) System.out.print(i + ",");
        }
    }

    /**
     * 丑数：只包含因子2，3和 5 。<br>
     * 例如 1，2，3，4，5 ，6，8都是丑数，但7，14 不是，因为它包含因子 7。习惯上把 1 当做第一个丑数。<br>
     * 输入一个n，返回这个按从小到大的顺序的第 n 个丑数。<br>
     * http://zhedahht.blog.163.com/blog/static/2541117420094245366965/<br>
     */
    public static int uglyNum(int n)
    {
        if (n <= 0) return 0;
        int[] ugly = new int[n];
        ugly[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < ugly.length; i++)
        {
            int min = Math.min(ugly[p2] * 2, Math.min(ugly[p3] * 3, ugly[p5] * 5));
            ugly[i] = min;
            while (ugly[p2] * 2 <= min)
                p2++;
            while (ugly[p3] * 3 <= min)
                p3++;
            while (ugly[p5] * 5 <= min)
                p5++;
        }
        return ugly[n - 1];
    }

    /**
     * 输入一个int类型，输出从1到最大的n位数。<br>
     * http://zhedahht.blog.163.com/blog/static/2541117420094279426862/<br>
     * 调用：printFromZeroTo(new int[n], 0);
     */
    public static void printFromZeroTo(int[] a, int n)
    {
        for (int i = 0; i < 10; i++)
        {
            if (n != a.length)
            {
                a[n] = i;
                printFromZeroTo(a, n + 1);
            } else
            {
                boolean firstIsNotZero = false;
                for (int j = 0; j < a.length; j++)
                {
                    if (a[j] != 0)
                    {
                        System.out.print(a[j]);
                        firstIsNotZero = true;
                    } else
                    {
                        if (firstIsNotZero) System.out.print(a[j]);
                    }
                }
                System.out.print(",");
                return;
            }
        }
    }

    /**
     * 输入两个int类型n，不使用+、 -、 *、 /，返回加法结果。<br>
     * http://zhedahht.blog.163.com/blog/static/254111742011125100605/<br>
     */
    public static int add(int a, int b)
    {
        int sum = 0, carry = 0;
        while (b != 0)
        {
            sum = a ^ b; // 不考虑进位的加法
            carry = (a & b) << 1; // 如果有进位，carry就不为0
            a = sum;
            b = carry;
        }
        return a;
    }

    /**
     * 输入一个int类型n，输出所有和为n连续正数序列。<br>
     * 例如：输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以输出3个连续序列12345、456和78<br>
     * http://zhedahht.blog.163.com/blog/static/25411174200732711051101/<br>
     */
    public static void sum(int n)
    {
        if (n < 3) return;
        int small = 1, big = 2, sum = small + big;
        int mid = (1 + n) / 2;
        while (small < mid)
        {
            if (sum == n) printContinuousSeq(small, big);
            while (sum > n)
            {
                sum -= small;
                small++;
                if (sum == n) printContinuousSeq(small, big);
            }
            big++;
            sum += big;
        }
    }

    /**
     * 输入两个int类型n和k，输出0到n（包括边界）的所有数字中k出现的次数。<br>
     * 例如30143：<br>
     * 由于3>1，则个位上出现1的次数为(3014+1)*1。<br>
     * 由于4>1，则十位上出现1的次数为(301+1)*10。<br>
     * 由于1=1，则百位上出现1次数为(30+0)*100+(43+1)。<br>
     * 由于0<1，则千位上出现1次数为(3+0)*1000。<br>
     * http://zhedahht.blog.163.com/blog/static/25411174200732494452636/<br>
     * https://leetcode.com/problems/number-of-digit-one/<br>
     * https://discuss.leetcode.com/topic/27404/my-simple-and-understandable-java-solution/3<br>
     */
    public static int countK(int n, int k)
    {
        int baseScale = 1;
        int passed = 0;
        int times = 0;
        while (n > 0)
        {
            int current = n % 10;
            n = n / 10;
            if (k < current) times += (n + 1) * baseScale;
            else if (k == current) times += n * baseScale + passed + 1;
            else times += n * baseScale;
            passed += current * baseScale;
            baseScale *= 10;
        }
        return times;
    }

    /**
     * 输入一个int数组，判断是不是能排序成一个顺子，<br>
     * A为1，J为11，Q为12，K为13，<br>
     * 大小王可以看成任意数字，并且可能有多个大小王。<br>
     * http://zhedahht.blog.163.com/blog/static/25411174200951262930831/<br>
     */
    public static boolean cards(int[] a)
    {
        if (a == null || a.length <= 1) return false;
        Arrays.sort(a);
        int zero = 0; // 统计大小王个数
        for (int i = 0; i < a.length && a[i] == 0; i++)
            zero++;
        int gap = 0;
        for (int i = zero; i < a.length - 1; i++)
        {
            if (a[i] == a[i + 1]) return false;
            gap += a[i + 1] - a[i] - 1;
        }
        return (zero >= gap) ? true : false;
    }

    /**
     * 输入一个int类型n，表示骰子的个数，所有骰子朝上一面的点数之和为s，<br>
     * 打印出s的所有可能的值出现的概率。<br>
     */
    public static void dice(int n)
    {

    }

    /**
     * 输入一个int类型，输出反转的结果。<br>
     * https://leetcode.com/problems/reverse-integer/<br>
     * https://discuss.leetcode.com/topic/6104/my-accepted-15-lines-of-code-for-java/2<br>
     */
    public static void reverse(int i)
    {
        int result = 0;
        while (i != 0)
        {
            int tail = i % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result)
            {
                System.out.print(0);
                return;
            }
            result = newResult;
            i = i / 10;
        }
        System.out.print(result);
    }

    /**
     * https://leetcode.com/problems/palindrome-number/<br>
     * https://discuss.leetcode.com/topic/40845/9-ms-java-beats-99-5-java-solutions-easy-to-understand<br>
     */
    public static boolean isPalindrome(int i)
    {
        if (i < 0) return false;
        if (i < 10) return true;
        if (i % 10 == 0) return false;
        if (i < 100 && i % 11 == 0) return true;
        if (i < 1000 && ((i / 100) * 10 + i % 10) % 11 == 0) return true;
        int v = i % 10;
        i = i / 10;
        while (i - v > 0)
        {
            v = v * 10 + i % 10;
            i /= 10;
        }
        if (v > i) v /= 10;
        return v == i ? true : false;
    }

    private static void printContinuousSeq(int small, int big)
    {
        for (int i = small; i <= big; ++i)
            System.out.print(i);
        System.out.println();
    }

    /**
     * 输入一个char数组，转换成int类型，返回转换结果。<br>
     * <br>
     * https://leetcode.com/problems/string-to-integer-atoi/<br>
     * https://discuss.leetcode.com/topic/2666/my-simple-solution/14<br>
     */
    public static int parseInt(char[] c)
    {
        if (c == null || c.length == 0) throw new NumberFormatException();
        int sign = 1, base = 0, i = 0;
        while (c[i] == ' ')
            i++;
        if (c[i] == '+' || c[i] == '-') sign = (c[i++] == '+') ? 1 : -1;
        while (i < c.length && c[i] >= '0' && c[i] <= '9')
        {
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && c[i] - '0' > 7))
            {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            base = 10 * base + (c[i++] - '0');
        }
        return base * sign;
    }

    @SuppressWarnings("unused")
    private static void fibonacciTest()
    {
        for (int i = 0; i < 10; i++)
        {
            System.out.print(fibonacci(i) + ",");
        }
    }

    @SuppressWarnings("unused")
    private static void cardsTest()
    {
        int[] a1 = { 1, 2, 3, 4, 10, 0, 0 };
        int[] a2 = { 1, 2, 3, 4, 0, 5, 7 };
        System.out.print(cards(a1));
        System.out.print(cards(a2));
    }
}