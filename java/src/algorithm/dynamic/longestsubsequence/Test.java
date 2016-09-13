package algorithm.dynamic.longestsubsequence;

public class Test
{
    public static int lis(int[] array)
    {
        int[] lis = new int[array.length];
        for (int i = 0; i < array.length; i++)
        {
            lis[i] = 1;
            for (int j = 0; j < i; j++)
            {
                if (array[j] < array[i] && (lis[j] + 1 > lis[i]))
                    lis[i] = lis[j] + 1;
            }
        }
        int max = 0;
        for (int k = 0; k < lis.length; k++)
        {
            if (lis[k] > max)
                max = lis[k];
        }
        return max;
    }

    public static void main(String[] args)
    {
        int[] is = { 1, 2, 1, 3, 2, 3, 7, 6, 8, 0 };
        System.out.println(lis(is));
    }

}
