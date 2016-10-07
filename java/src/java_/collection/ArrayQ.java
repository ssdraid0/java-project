package java_.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

/**
 * ⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽</br>
 * 1.Java中数组是否能为null？是否能长度为0，但又不为null。</br>
 * 能。能。</br>
 * {@link #testNull()}。</br>
 * </br>
 * 2.{@link Arrays#sort(int[])}的原理？</br>
 * ⑴.如果元素个数小于47个，插入排序。</br>
 * ⑵.如果元素个数大于等于47个，小于等于286个，快速排序。</br>
 * ⑶.如果元素个数大于286个，归并排序。</br>
 * </br>
 * 2.{@link Arrays#sort(Object[], Comparator)}的原理？<br/>
 * ⑴.如果元素个数小于2个，不排序。</br>
 * ⑵.如果元素个数大于等于2个，小于32个，折半插入排序。</br>
 * ⑶.如果元素个数大于等于32个，经过优化的归并排序。</br>
 * </br>
 * 3.{@link Collections#sort(List)}的原理？</br>
 * ⑴.先把{@link List}转换为{@link Object}数组。</br>
 * ⑵.调用{@link Arrays#sort(Object[], Comparator)}排序。</br>
 * ⑶.用{@link ListIterator}修改原{@link List}的每个值。</br>
 * </br>
 * 4.{@link Arrays#sort(Object[], Comparator)}对归并排序做了哪些优化？</br>
 * </br>
 */
public class ArrayQ
{
    public static void main(String[] args)
    {
        Random random = new Random();
        int[] a = new int[286];
        for (int i = 0; i < a.length; i++)
        {
            a[i] = random.nextInt(100);
        }
        Arrays.sort(a);
        for (int i : a)
        {
            System.out.print(i + ",");
        }
    }

    public static void testNull()
    {
        int[] a1 = null;
        int[] a2 = new int[0];
        int[] a3 = {};
        int[][] a4 = {};
        int[][] a5 = { {} };
        System.out.println(a1 == null); // true
        System.out.println(a2.length == 0); // true
        System.out.println(a2 == null); // false
        System.out.println(a3.length == 0); // true
        System.out.println(a3 == null); // false
        System.out.println(a4.length == 0); // true
        System.out.println(a5.length == 0); // false
        System.out.println(a5[0].length == 0); // true
    }
}
