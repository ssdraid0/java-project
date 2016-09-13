package algorithm.fibonacci;

public class Array
{
    public static void main(String[] args)
    {
        int arr[] = new int[20];
        arr[0] = arr[1] = 1;
        for (int i = 2; i < arr.length; i++)
        {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + ",");
        }
    }
}
