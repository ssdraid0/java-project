package algorithm.test;

import static algorithm.SearchQuestion.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class SearchQTest
{

    @Test
    public void testFindFirst()
    {
        int[] a4 = { 1, 1, 1, 1, 1 };
        System.out.println(binarySearchFirst(a4, 2));
        System.out.println(binarySearchLast(a4, 2));
    }

    @Test
    public void findSmallTest()
    {
        System.out.println("findSmallTest start");
        int[] a1 = { 3, 4, 1, 2 };
        int[] a2 = { 2, 2, 1, 1 };
        int[] a3 = { 3, 3, 1, 2 };
        int[] a4 = { 2, 3, 1, 1 };
        assertEquals(binarySearchMin(a1, 0, a1.length - 1), 1);
        assertEquals(binarySearchMin(a1, 0, a2.length - 1), 1);
        assertEquals(binarySearchMin(a1, 0, a3.length - 1), 1);
        assertEquals(binarySearchMin(a1, 0, a4.length - 1), 1);
        System.out.println("findSmallTest end");
    }

}
