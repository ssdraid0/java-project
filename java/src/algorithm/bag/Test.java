package algorithm.bag;

public class Test
{
    public static void main(String[] args)
    {
        Knapsack[] bags = new Knapsack[]
        { new Knapsack(2, 13), new Knapsack(1, 10), new Knapsack(3, 24), new Knapsack(2, 15), new Knapsack(4, 28), new Knapsack(5, 33),
                new Knapsack(3, 20), new Knapsack(1, 8) };
        int totalWeight = 12;
        KnapsackProblem kp = new KnapsackProblem(bags, totalWeight);

        kp.solve();
        System.out.println(" -------- 该背包问题实例的解: --------- ");
        System.out.println("最优值：" + kp.getBestValue());
        System.out.println("最优解【选取的背包】: ");
        System.out.println(kp.getBestSolution());
        System.out.println("最优值矩阵：横轴：箱子容量，纵轴：能选取从第0个到第n-1个背包（n的含义：当前是第n-1行）");
        int[][] bestValues = kp.getBestValues();
//        for (int i = 0; i < bestValues[0].length; i++)
//        {
//            System.out.printf("%-5d", i);
//        }
//        System.out.println();
//        System.out.println("====================================");
        for (int i = 0; i < bestValues.length; i++)
        {
            for (int j = 0; j < bestValues[i].length; j++)
            {
                System.out.printf("%-5d", bestValues[i][j]);
            }
            System.out.println();
        }

    }
}
