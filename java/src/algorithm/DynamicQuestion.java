package algorithm;

/**
 * 
 * 
 */
public class DynamicQuestion
{
    public static void main(String[] args)
    {
        int[] a = { 1, 5, 3, 7, 2, 6 };
        System.out.println("3 transaction maxProfit：" + maxProfit(a, 2)); // 10
        int[] a2 = { 1, 4, 6, 8, 5, 7 };
        System.out.println("3 transaction maxProfit：" + maxProfit(a2, 2)); // 9
        int[] a3 = { 1, 2, 5 };
        coinChange(a3, 10);
    }

    /**
     * 输入一个int类型数组代表硬币种类，一个int类型代表钱。<br>
     * 最少需要多少硬币？输出这个数量和所需硬币。<br>
     * https://leetcode.com/problems/coin-change/<br>
     */
    public static void coinChange(int[] coins, int amount)
    {
        int[] coinNum = new int[amount + 1]; // 表示金额i至少需要coinNum[i]个硬币。
        int[] coinValue = new int[amount + 1]; // 表示金额i至少需要的硬币中最后一个硬币。
        int min = Integer.MAX_VALUE;
        int usedMoney = 0;
        for (int i = 1; i <= amount; i++)
        {
            min = Integer.MAX_VALUE;
            usedMoney = 0;
            for (int j = 0; j < coins.length; j++)
            {
                if (i >= coins[j] && coinNum[i - coins[j]] + 1 <= min)
                {
                    min = coinNum[i - coins[j]] + 1;
                    if (i == coins[j] || coinValue[i - coins[j]] != 0)
                        usedMoney = coins[j];
                }
            }
            coinNum[i] = min;
            coinValue[i] = usedMoney;
        }
        if (coinNum[amount] == Integer.MAX_VALUE) // 找不开
            return;
        System.out.println("最少需要硬币个数：" + coinNum[amount]);
        System.out.print("需要硬币：");
        int money = amount;
        while (money > 0)
        {
            System.out.print(coinValue[money] + ",");
            money -= coinValue[money];
        }
    }

    public static void findMin(int money, int[] coin)
    {
        int[] coinNum = new int[money + 1];// 存储1...money找零最少需要的硬币的个数
        int[] coinValue = new int[money + 1];// 最后加入的硬币，方便后面输出是哪几个硬币
        coinNum[0] = 0;

        for (int i = 1; i <= money; i++)
        {
            int minNum = i;// i面值钱，需要最少硬币个数
            int usedMoney = 0;// 这次找零，在原来的基础上需要面值为usedMoney的硬币
            for (int j = 0; j < coin.length; j++)
            {
                if (i >= coin[j])// 找零的钱大于这个硬币的面值
                {
                    /*
                     * i == coin[j]说明当期的i块钱和1个价值coin[j]的硬币价值相同。 coinValue[i - coin[j]] !=
                     * 0说明当期i块钱减掉1个价值coin[j]的硬币后的钱仍然能找开。 如果找不开，不需要更新。
                     */
                    if (coinNum[i - coin[j]] + 1 <= minNum && (i == coin[j] || coinValue[i - coin[j]] != 0))// 所需硬币个数减少了
                    {
                        minNum = coinNum[i - coin[j]] + 1;// 更新
                        usedMoney = coin[j];// 更新
                    }
                }
            }
            coinNum[i] = minNum;
            coinValue[i] = usedMoney;
        }

        // 输出结果
        if (coinValue[money] == 0)
            System.out.println("找不开零钱");
        else
        {
            System.out.println("需要最少硬币个数为：" + coinNum[money]);
            System.out.print("硬币分别为:");
            while (money > 0)
            {
                System.out.print(coinValue[money] + ",");
                money -= coinValue[money];
            }
        }
    }

    /**
     * 输入一个数组和一个整数n，分别代表股票每天的价格和最多只能进行n次交易。<br>
     * 买股票前必须卖出股票，手里最多能持有1个股票，股票在某天买了，不能在那天卖。<br>
     * 返回最大收益。<br>
     * 例如：输入{ 1, 5, 3, 7, 2, 6 }，返回最大收益7-1=6。<br>
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/<br>
     * https://discuss.leetcode.com/topic/8984/a-concise-dp-solution-in-java/4<br>
     */
    public static int maxProfit(int[] prices, int n)
    {
        if (prices == null || prices.length <= 1)
            return 0;
        if (n >= prices.length / 2)
            return buyMax(prices);
        int[][] profits = new int[n + 1][prices.length];
        for (int i = 1; i <= n; i++)
        {
            int tmpMax = -prices[0];
            for (int j = 1; j < prices.length; j++)
            {
                profits[i][j] = Math.max(profits[i][j - 1], prices[j] + tmpMax);
                tmpMax = Math.max(tmpMax, profits[i - 1][j - 1] - prices[j]);
            }
        }
        return profits[n][prices.length - 1];
    }

    private static int buyMax(int[] prices)
    {
        int profit = 0;
        for (int i = 1; i < prices.length; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1])
                profit += prices[i] - prices[i - 1];
        return profit;
    }

    /**
     * http://liangjiabin.com/blog/2015/04/leetcode-best-time-to-buy-and-sell-stock.html
     */
    public static int maxProfit2(int[] prices, int k)
    {
        if (prices == null || prices.length <= 1)
            return 0;
        if (k >= prices.length)
            return maxProfit2(prices);

        int[] local = new int[k + 1];
        int[] global = new int[k + 1];

        for (int i = 1; i < prices.length; i++)
        {
            int diff = prices[i] - prices[i - 1];

            for (int j = k; j > 0; j--)
            {
                local[j] = Math.max(global[j - 1], local[j] + diff);
                global[j] = Math.max(global[j], local[j]);
            }
        }

        return global[k];
    }

    public static int maxProfit2(int[] prices)
    {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++)
        {
            if (prices[i] > prices[i - 1])
            {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}