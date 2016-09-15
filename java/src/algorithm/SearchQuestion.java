package algorithm;

/**
 * @author ssdraid0
 */
public class SearchQuestion
{
    public static void main(String[] args)
    {
        int []a= {1,3,5,7,9};
        System.out.println(binarySearch(a,1));
        System.out.println(binarySearch(a,3));
        System.out.println(binarySearch(a,5));
        System.out.println(binarySearch(a,7));
        System.out.println(binarySearch(a,9));
        System.out.println(binarySearch(a,10));

    }
    
    public static int binarySearch(int[] a, int key)
    {
        int low = 0;
        int high = a.length - 1;
        while (low <= high)
        {
            int mid = (low + high) >>> 1;
            if (a[mid] < key)
                low = mid + 1;
            else if (a[mid] > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -1;  // key not found
    }
}
