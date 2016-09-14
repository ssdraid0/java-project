package algorithm;

public class AlgorithmQuestion
{
    public static void main(String[] args)
    {
        // int a[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        // MatrixQuestion.printMatrix(a);
        MathQuestion.testPow();
    }
}

/**
 * 
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
        int cols = numbers[0].length; // 列数
        int rows = numbers.length; // 行数
        int start = 0;
        while (cols > start * 2 && rows > start * 2)
        {
            printOneCircle(numbers, cols, rows, start);
            start++;
        }
    }

    // 在圆圈中打印矩阵，打印一圈分4种情况:一步，二步，三步，四步
    private static void printOneCircle(int[][] numbers, int cols, int rows, int start)
    {
        int endX = cols - 1 - start;
        int endY = rows - 1 - start;
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
}

class MathQuestion
{
    public static void testPow()
    {
        System.out.println(pow(2, 10));
    }

    public static int pow(int x, int n)
    {
        if (n == 0)
        {
            return 1;
        }
        while ((n & 1) == 0)
        { 
            n >>= 1;
            x *= x;
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
}