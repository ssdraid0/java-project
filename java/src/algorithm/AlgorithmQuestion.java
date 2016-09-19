package algorithm;

/**
 * 1.输入一个数组，这个数组是另一个递增排序的数组的一个旋转数组，通过二分法输出最小元素。<br>
 * {@link AlgorithmQuestion#findSmall(int[])}。<br>
 * 2.输入一个整数，输出该数二进制表示中 1 的个数。<br>
 * {@link AlgorithmQuestion#numberOf1(int)}。<br>
 */
public class AlgorithmQuestion
{
    public static void main(String[] args)
    {
        // MathQuestion.powTest();
        // MathQuestion.fibonacciTest();
        AlgorithmQuestion.findSmallTest();
    }

    /**
     * 输入一个数组，这个数组是另一个递增排序的数组的一个旋转数组，通过二分法输出最小元素。<br>
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，数组{3,4,5,1,2}的最小值为 1。<br>
     */
    public static int findSmall(int[] a)
    {
        return findSmall(a, 0, a.length - 1);
    }

    private static int findSmall(int[] a, int first, int last)
    {
        if (first + 1 == last || first == last)
            return a[last] < a[first] ? a[last] : a[first];
        int index = (first + last) / 2;
        if (a[first] == a[index] && a[last] == a[index])
        {// 此时两边中间都一样，考虑到特殊情况，我们两遍均遍历一次，进行最后的比较大小。
            int find1 = findSmall(a, first, index);
            int find2 = findSmall(a, index + 1, last);
            return find1 < find2 ? find1 : find2;
        } else if (a[index] >= a[first] && a[index] > a[last])
            return findSmall(a, index + 1, last);
        else
            return findSmall(a, first, index);
    }

    public static void findSmallTest()
    {
        int[] a = { 3, 4, 5, 1, 2 };
        int[] a2 = { 2, 2, 1, 1 };
        int[] a3 = { 3, 3, 1, 2 };
        int[] a4 = { 2, 3, 1, 1 };
        System.out.println(findSmall(a));
        System.out.println(findSmall(a2));
        System.out.println(findSmall(a3));
        System.out.println(findSmall(a4));
    }

    /**
     * 输入一个整数，输出该数二进制表示中 1 的个数。
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
}

/**
 * 1.输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。<br>
 * {@link MatrixQuestion#printMatrix(int[][])}。<br>
 */
class MatrixQuestion
{
    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。<br>
     * {@link http://blog.csdn.net/yanxiaolx/article/details/52254590}。<br>
     */
    public static void printMatrix(int[][] numbers)
    {
        if (numbers == null)
        {
            return;
        }
        int width = numbers[0].length;
        int depth = numbers.length;
        int start = 0;
        while (width > start * 2 && depth > start * 2)
        {
            printOneCircle(numbers, width, depth, start);
            start++;
        }
    }

    // 在圆圈中打印矩阵，打印一圈分4种情况:一步，二步，三步，四步
    private static void printOneCircle(int[][] numbers, int width, int depth, int start)
    {
        int endX = width - 1 - start;
        int endY = depth - 1 - start;
        // 从左到右打印一行
        for (int i = start; i <= endX; i++)
        {
            int number = numbers[start][i];
            System.out.print(number + " ");
        }
        // 从上到下打印一列
        if (start < endY)
        {
            for (int i = start + 1; i <= endY; i++)
            {
                int number = numbers[i][endX];
                System.out.print(number + " ");
            }
        }
        // 从右到左打印一行
        if (start < endX && start < endY)
        {
            for (int i = endX - 1; i >= start; i--)
            {
                int number = numbers[endY][i];
                System.out.print(number + " ");
            }
        }
        // 从下到上打印一行
        if (start < endX && start < endY - 1)
        {
            for (int i = endY - 1; i >= start + 1; i--)
            {
                int number = numbers[i][start];
                System.out.print(number + " ");
            }
        }
    }

    public static void printMatrixTest()
    {
        int a1[][] = { { 1, 2, 3, 4 } };
        MatrixQuestion.printMatrix(a1);
        System.out.println();
        int a2[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };
        MatrixQuestion.printMatrix(a2);
        System.out.println();
        int a3[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        MatrixQuestion.printMatrix(a3);
        System.out.println();
        int a4[][] = { { 1 }, { 2 }, { 3 }, { 4 } };
        MatrixQuestion.printMatrix(a4);
        System.out.println();
        int a5[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        MatrixQuestion.printMatrix(a5);
        System.out.println();
    }

    /**
     * 输出长宽为n的旋转矩阵。<br>
     * 例如，当n=3时，输出<br>
     * 1 2 3<br>
     * 8 9 4<br>
     * 7 6 5<br>
     */
    public static void printMatrix2(int n)
    {

    }

    /**
     * 输入一个二维数组和一个整数，这个二维数组每一行从左到右递增，每一列从上到下递增。<br>
     * 判断数组中是否含有该整数。
     */
    public static boolean find(int[][] array, int number)
    {
        if (array == null || array.length == 0)
        {
            return false;
        }
        int width = array[0].length - 1;
        int depth = 0;
        while (depth < array.length && width >= 0)
        {
            if (array[depth][width] == number)
            {
                return true;
            }
            if (array[depth][width] > number)
            {
                width--;
            } else
            {
                depth++;
            }
        }
        return false;
    }

    public static void findTest()
    {
        int[][] testarray = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
        System.out.println(find(testarray, 1));
    }
}

/**
 * 1.输入一个整数n，求斐波那契数列的第n项。<br>
 * {@link MathQuestion#fibonacci(int)}。<br>
 * 2.输入两个整数x和n，求x的n次方。<br>
 * {@link MathQuestion#pow(int, int)}。<br>
 */
class MathQuestion
{
    public static long fibonacci(int n)
    {
        long preOne = 0;
        long preTwo = 1;
        if (n == 0)
        {
            return preOne;
        }
        if (n == 1)
        {
            return preTwo;
        }
        long result = 1;
        for (int i = 2; i <= n; i++)
        {
            result = preOne + preTwo;
            preOne = preTwo;
            preTwo = result;
        }
        return result;
    }

    public static void fibonacciTest()
    {
        for (int i = 0; i < 10; i++)
        {
            System.out.print(fibonacci(i) + ",");
        }
    }
    
    /**
     * 输入1个double类型x和一个int类型n，求x的n次方。<br>
     */
    public double power(double x, int n) throws Exception
    {
        double result = 0;
        if (equal(x, 0.0) && n < 0)
        {
            throw new Exception("0的负数次幂没有意义");
        }
        if (n < 0)
        {
            result = 1.0 / powerWithExpoment(x, -n);
        } else
        {
            result = powerWithExpoment(x, n);
        }
        return result;
    }

    private double powerWithExpoment(double base, int exponent)
    {
        if (exponent == 0)
        {
            return 1;
        }
        double result = 1.0;
        for (int i = 1; i <= exponent; i++)
        {
            result = result * base;
        }
        return result;
    }

    private boolean equal(double num1, double num2)
    {
        if ((num1 - num2 > -0.0000001) && num1 - num2 < 0.0000001)
        {
            return true;
        } else
        {
            return false;
        }
    }

    /**
     * 输入两个整数x和n，求x的n次方。<br>
     */
    public static int pow(int x, int n)
    {
        if (n == 0)
        {
            return 1;
        }
        while ((n & 1) == 0)
        {
            x *= x;
            n >>= 1;
        }
        int result = x;
        n >>= 1;
        while (n != 0)
        {
            x *= x;
            if ((n & 1) != 0)
                result *= x;
            n >>= 1;
        }
        return result;
    }

    public static void powTest()
    {
        Math.pow(2, 10);
        System.out.println(pow(2, 10));
    }
}