package algorithm.剑指offer;

public class Q47
{
    public static void main(String[] args)
    {
        System.out.print(add(8, 16));
    }

    public static int add(int num1, int num2)
    {
        int sum, carray;
        do
        {
            sum = num1 ^ num2;
            carray = (num1 & num2) << 1;
            num1 = sum;
            num2 = carray;
        } while (num2 != 0);
        return num1;
    }
}
