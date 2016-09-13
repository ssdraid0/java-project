package algorithm.fibonacci;

public class Recursion
{
    private static int f(int i)
    {
        if (i == 1 || i == 2)
            return 1;
        else
            return f(i - 1) + f(i - 2);
    }

    public static void main(String[] args)
    {
        for (int j = 1; j <= 20; j++)
        {
            System.out.print(f(j) + ",");
        }
    }
}
