package data_structure.binaryheap;

import java.util.Random;

public class MinBinaryHeap
{
    private static int[] getMinBinaryHeap(int[] array)
    {
        int N = array.length;
        int minBinaryHeap[] = new int[N];
        int root;// 根的值
        int heapSize = 0;// 记录插入位置
        for (int num : array)
        {
            minBinaryHeap[heapSize] = num;
            ++heapSize;
            int pointer = heapSize - 1;// 当前指向的数组元素位置
            while (pointer != 0)
            {
                int leafPointer = pointer;// 叶子节点位置
                pointer = (pointer - 1) / 2;// 根节点位置
                root = minBinaryHeap[pointer];// 根节点
                if (num >= root)
                {// 永远把当前数组元素看成叶子与其根比较或者换位
                    break;
                } // 如果根比叶子大 就交换位置
                minBinaryHeap[pointer] = num;
                minBinaryHeap[leafPointer] = root;

            }
        }
        return minBinaryHeap;

    }

    public static void main(String[] args)
    {
        for (int i = 0; i < 10; i++)
        {
            Random rnd = new Random();
            int[] lala = { rnd.nextInt(6), rnd.nextInt(6), rnd.nextInt(6), rnd.nextInt(6), rnd.nextInt(6),
                    rnd.nextInt(6) };
            System.out.print("输入：");
            for (int a : lala)
            {
                System.out.print(a + " ");
            }
            System.out.println();
            int[] array = getMinBinaryHeap(lala);
            System.out.print("输出：");
            for (int a : array)
            {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }

}
