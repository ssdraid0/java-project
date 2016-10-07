package java_.collection;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

/**
 * ⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽</br>
 * 1.{@link HashMap}继承了什么类?实现了哪些接口?</br>
 * 继承了{@link AbstractMap}，实现了{@link Map}接口。</br>
 * </br>
 * 2.{@link HashMap}的默认容量是多少？最大容量是多少？每次扩容多少？</br>
 * 默认容量是16。最大容量是2的30次方。扩容为原来的2倍。</br>
 * </br>
 * 3.分析代码：
 * 
 * <pre>
 * Map<String, String> map = new HashMap<>();
 * for (int i = 0; i < 20; i++)
 *     map.put(Integer.toString(i), "");
 * </pre>
 * 
 * 其中map是在什么时候扩容？</br>
 * {@link HashMap}的默认负载因子为0.75，阈值=容量*负载因子=12，</br>
 * 当HashMap存储到第12个键值对时扩容。</br>
 * </br>
 * 4.实现{@link HashMap}的数据结构是什么？</br>
 * 数组，类型为{@link HashMap.Node}，</br>
 * 数组的每个位置存储一个链表或红黑树{@link HashMap.TreeNode}的头结点。</br>
 * </br>
 * 5.什么是hash碰撞？{@link HashMap}如何解决hash碰撞？</br>
 * hash碰撞：两个键值对存储到数组的同一个位置。</br>
 * 添加到数组那个位置的链表的末尾，如果链表长度大于8，转换为红黑树。</br>
 * </br>
 * 6.{@link HashMap}计算键的hash值的过程是怎样的？</br>
 * ⑴.如果键是null，hash值是0。</br>
 * 如果键不是null，调用键的hashCode()方法计算出键的hash值，</br>
 * ⑵.然后将hash值向右移动16位后和hash值进行与运算。</br>
 * </br>
 * 7.{@link HashMap#put(Object, Object)}的过程？</br>
 * ⑴.计算出键的hash值，通过hash&(数组长度-1)找到存储位置。</br>
 * ⑵.如果存储位置上为null，创建一个结点{@link HashMap.Node}，转⑹。</br>
 * ⑶.如果存储位置上不是null，判断这个键是否存在。</br>
 * 存在的定义：找到一个结点，hash相同并且，引用相同或equals相等。</br>
 * 过程：先判断数组，再判断结点类型，如果是红黑树就到红黑树上去找，如果是链表就到链表上去找。</br>
 * ⑷.如果这个键存在，替换值。</br>
 * ⑸.如果这个键不存在，添加。</br>
 * ⑹.根据实际情况扩容。</br>
 * </br>
 * 8.为什么{@link HashMap}的容量必须是2的n次幂?</br>
 * 因为一个键值对的存储位置是通过hash对数组长度取模计算出来的。</br>
 * 容量是2的n次幂时，hash对数组长度取模等价于hash&(数组长度-1)，加快计算速度。</br>
 * </br>
 * 9.{@link HashMap}的扩容过程？</br>
 * ⑴.如果原容量超过2的30次方，直接把阈值设置为int的最大值，不扩容。否则扩容为原来的2倍。</br>
 * ⑵.然后顺序判断数组每个元素，是否有下一个结点，如果没有，计算在新的数组上的位置，然后移动过去。</br>
 * 如果有下一个结点，先判断头结点类型。</br>
 * 如果是红黑树结点，。。。，</br>
 * 如果是链表结点，将链表结点和原容量相与，如果结果是0，说明在存储位置不变，否则存储位置为原位置加原容量。</br>
 */
public class HashMapQ
{
    public static void main(String[] args)
    {
        test1();
    }

    public static void test1()
    {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 20; i++)
            map.put(Integer.toString(i), "");
        System.out.println(map.size());
    }
}
