package algorithm.剑指offer;

public class Q28
{
    public static void main(String[] args)
    {
        permutation("123456");
    }

    public static void permutation(String str)
    {
        int count = 0;
        if (str == null)
            return;
        char[] chs = str.toCharArray();
        int point = 0;
        System.out.println(chs);
        count++;
        char temp1 = chs[point];
        chs[point] = chs[++point];
        chs[point] = temp1;
        while (!String.valueOf(chs).equals(str))
        {
            System.out.println(chs);
            count++;
            if (point == chs.length - 1)
            {
                char temp = chs[point];
                chs[point] = chs[0];
                chs[0] = temp;
                point = 0;
            } else
            {
                char temp = chs[point];
                chs[point] = chs[++point];
                chs[point] = temp;
            }
        }
        System.out.println(count);
    }
}
