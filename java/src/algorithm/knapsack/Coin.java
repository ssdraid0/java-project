package algorithm.knapsack;

public class Coin
{
    public static void FindMin(int money, int[] coin)
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
                     * i == coin[j]说明当期的i块钱和1个价值coin[j]的硬币价值相同。
                     * coinValue[i - coin[j]] != 0说明当期i块钱减掉1个价值coin[j]的硬币后的钱仍然能找开。
                     * 如果找不开，不需要更新。
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

    public static void main(String[] args)
    {
        int Money = 10;
        int coin[] =
        { 2, 3, 5 };
        FindMin(Money, coin);
    }
}
