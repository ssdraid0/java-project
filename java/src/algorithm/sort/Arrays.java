package algorithm.sort;

import java.util.Comparator;

public class Arrays<E>
{
    public static void sort(Object[] a)
    {
//        if (LegacyMergeSort.userRequested)
//            legacyMergeSort(a);
//        else
//            ComparableTimSort.sort(a, 0, a.length, null, 0, 0);
    }

    public static <T> void sort(T[] a, Comparator<? super T> c)
    {
        if (c == null)
        {
            sort(a);
        } else
        {
//            if (LegacyMergeSort.userRequested)
//                legacyMergeSort(a, c);
//            else
            
                TimSort.sort(a, 0, a.length, c, null, 0, 0);
        }
    }
    
}
