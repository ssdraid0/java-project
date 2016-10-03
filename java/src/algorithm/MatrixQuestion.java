package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1.输入一个int类型矩阵和一个int类型k，矩阵每一行从左到右递增，每一列从上到下递增，<br>
 * 如果矩阵中含有k，返回true。<br>
 * {@link #find(int[][], int)}。<br>
 * 2.输入一个int类型矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。<br>
 * {@link #spiralOrder(int[][])}。<br>
 * 3.输入一个int类型矩阵，返回从左上角到右下角的路径数量。<br>
 * {@link #uniquePaths(int[][])}。<br>
 * 4.输入一个int类型矩阵，矩阵的每个位置的值为0或1，为1的位置不能通行，返回从左上角到右下角的不同路径数量。<br>
 * {@link #uniquePathsObstacles(int[][])}。<br>
 * 5. 输入一个int类型矩阵，从左上角移动到右下角，只能向右或向下移动。<br>
 * 找出一个路径，这个路径经过的值的和最小，返回这个值。<br>
 * {@link #minPathSum(int[][])}。<br>
 */
public class MatrixQuestion
{
    public static void main(String[] args)
    {
        int[][] a = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
        System.out.println(find(a, 1)); // true
        System.out.println("uniquePaths:" + uniquePaths(a));// 20
        int[][] a2 = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        System.out.println("uniquePathsWithObstacles:" + uniquePathsObstacles(a2));
        System.out.println("minPathSum:" + minPathSum(a));
        queenTest();
    }

    /**
     * 输入一个矩阵和一个整数，这个矩阵每一行从左到右递增，每一列从上到下递增，<br>
     * 如果矩阵中含有该整数，返回true。<br>
     */
    public static boolean find(int[][] a, int k)
    {
        if (a == null || a.length == 0)
            return false;
        int width = a[0].length - 1;
        int depth = 0;
        while (depth <= a.length - 1 && width >= 0)
        {
            if (a[depth][width] == k)
                return true;
            else if (a[depth][width] > k)
                width--;
            else
                depth++;
        }
        return false;
    }

    /**
     * 输入一个矩阵，返回从左上角到右下角的不同路径数量。<br>
     * https://leetcode.com/problems/unique-paths/<br>
     */
    public static int uniquePaths(int[][] a)
    {
        if (a == null || a.length == 0 || a[0].length == 0)
            return 0;
        int[] paths = new int[a[0].length];
        paths[0] = 1;
        for (int d = 0; d < a.length; d++)
        {
            for (int w = 0; w < a[0].length; w++)
            {
                if (w > 0)
                    paths[w] += paths[w - 1];
            }
        }
        return paths[paths.length - 1];
    }

    /**
     * 输入一个矩阵，矩阵的每个位置的值为0或1，为1的位置不能通行，返回从左上角到右下角的不同路径数量。<br>
     * https://leetcode.com/problems/unique-paths-ii/<br>
     */
    public static int uniquePathsObstacles(int[][] a)
    {
        if (a == null || a.length == 0 || a[0].length == 0)
            return 0;
        int[] paths = new int[a[0].length];
        paths[0] = 1;
        for (int d = 0; d < a.length; d++)
        {
            for (int w = 0; w < a[0].length; w++)
            {
                if (a[d][w] == 1)
                    paths[w] = 0;
                else if (w > 0)
                    paths[w] += paths[w - 1];
            }
        }
        return paths[paths.length - 1];
    }

    /**
     * 输入一个矩阵，从左上角移动到右下角，只能向右或向下移动。<br>
     * 找出一个路径，这个路径经过的值的和最小，返回这个值。<br>
     * https://leetcode.com/problems/minimum-path-sum/<br>
     */
    public static int minPathSum(int[][] a)
    {
        if (a == null || a.length == 0 || a[0].length == 0)
            return 0;
        int[] sums = new int[a[0].length];
        for (int d = 0; d < a.length; d++)
        {
            for (int w = 0; w < a[0].length; w++)
            {
                if (d == 0 && w == 0)
                {
                    sums[w] = a[d][w];
                } else if (d == 0 && w != 0)
                {
                    sums[w] = a[d][w] + sums[w - 1];
                } else if (d != 0 && w == 0)
                {
                    sums[w] = a[d][w] + sums[w];
                } else
                {
                    sums[w] = Math.min(sums[w - 1], sums[w]) + a[d][w];
                }
            }
        }
        return sums[sums.length - 1];
    }

    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。<br>
     * http://blog.csdn.net/yanxiaolx/article/details/52254590<br>
     * https://leetcode.com/problems/spiral-matrix/<br>
     */
    public static void spiralOrder(int[][] a)
    {
        if (a == null || a.length == 0 || a[0].length == 0)
            return;
        int start = 0;
        while (start * 2 < a.length && start * 2 < a[0].length)
        {
            printOneCircle(a, start);
            start++;
        }
    }

    // 在圆圈中打印矩阵，打印一圈分4种情况:一步，二步，三步，四步
    private static void printOneCircle(int[][] a, int start)
    {
        int endX = a[0].length - 1 - start;
        int endY = a.length - 1 - start;
        // 从左到右打印一行
        for (int i = start; i <= endX; i++)
        {
            int number = a[start][i];
            System.out.print(number + " ");
        }
        // 从上到下打印一列
        if (start < endY)
        {
            for (int i = start + 1; i <= endY; i++)
            {
                int number = a[i][endX];
                System.out.print(number + " ");
            }
        }
        // 从右到左打印一行
        if (start < endX && start < endY)
        {
            for (int i = endX - 1; i >= start; i--)
            {
                int number = a[endY][i];
                System.out.print(number + " ");
            }
        }
        // 从下到上打印一行
        if (start < endX && start < endY - 1)
        {
            for (int i = endY - 1; i >= start + 1; i--)
            {
                int number = a[i][start];
                System.out.print(number + " ");
            }
        }
    }

    /**
     * 输入一个n，输出长宽为n的旋转矩阵。<br>
     * 例如，当n=3时，输出<br>
     * 1 2 3<br>
     * 8 9 4<br>
     * 7 6 5<br>
     */
    public static void printMatrix(int n)
    {

    }

    /**
     * n皇后问题：在一个有nxn格的棋盘上，任意两个皇后都不能处于同一行、同一列或同一斜线上。<br>
     * 输入一个int类型n，返回n皇后问题的方案数。<br>
     * http://zhedahht.blog.163.com/blog/static/2541117420114331616329/<br>
     * https://leetcode.com/problems/n-queens/<br>
     */
    public static List<String[]> queen(int n)
    {
        List<String[]> result = new ArrayList<>();
        queen(0, new boolean[n], new boolean[2 * n], new boolean[2 * n], new String[n], result);
        return result;
    }

    private static void queen(int r, boolean[] w, boolean[] d1, boolean[] d2, String[] board, List<String[]> result)
    {
        if (r == board.length)
            result.add(board.clone());
        else
        {
            for (int c = 0; c < board.length; c++)
            {
                int id1 = r - c + board.length, id2 = 2 * board.length - r - c - 1;
                if (!w[c] && !d1[id1] && !d2[id2])
                {
                    char[] width = new char[board.length];
                    Arrays.fill(width, '+');
                    width[c] = 'Q';
                    board[r] = new String(width);
                    w[c] = true;
                    d1[id1] = true;
                    d2[id2] = true;
                    queen(r + 1, w, d1, d2, board, result);
                    w[c] = false;
                    d1[id1] = false;
                    d2[id2] = false;
                }
            }
        }
    }

    private static void queenTest()
    {
        List<String[]> list = queen(5);
        for (String[] s : list)
        {
            for (String string : s)
            {
                System.out.println(string);
            }
            System.out.println();
        }
    }

    @SuppressWarnings("unused")
    private static void printMatrixTest()
    {
        int a1[][] = { { 1, 2, 3, 4 } };
        MatrixQuestion.spiralOrder(a1);
        System.out.println();
        int a2[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };
        MatrixQuestion.spiralOrder(a2);
        System.out.println();
        int a3[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        MatrixQuestion.spiralOrder(a3);
        System.out.println();
        int a4[][] = { { 1 }, { 2 }, { 3 }, { 4 } };
        MatrixQuestion.spiralOrder(a4);
        System.out.println();
        int a5[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        MatrixQuestion.spiralOrder(a5);
        System.out.println();
    }

    @SuppressWarnings("unused")
    private static void findTest()
    {
        int[][] a = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
        System.out.println(find(a, 1));
    }
}
