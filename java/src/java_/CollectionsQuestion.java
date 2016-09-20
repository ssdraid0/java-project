package java_;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 1.继承了哪些类，实现了哪些接口？ <br>
 * 2.{@link List}，{@link Map}，{@link Set}的区别？<br>
 * a.哪些能存储重复的元素？<br>
 * {@link List}的元素能重复。{@link Set}的元素不能重复，{@link Map}的键不能重复。<br>
 * b.哪些能保证顺序？（添加元素的顺序和遍历元素的顺序相同）<br>
 * {@link List}：保证顺序。<br>
 * {@link Map}：{@link LinkedHashMap}保证顺序，{@link HashMap}，{@link TreeMap}不保证顺序。<br>
 * {@link Set}：{@link LinkedHashSet}保证顺序，{@link HashSet}，{@link TreeSet}不保证顺序。<br>
 * c.哪些能按下标操作元素？<br>
 * {@link List}能按下标操作元素，{@link Map}和{@link Set}不能。<br>
 * d.哪些能存储null？<br>
 * {@link List}：能存储null。<br>
 * {@link Map}：{@link HashMap}，{@link LinkedHashMap}的键能为null，{@link TreeMap}不能。<br>
 * {@link Set}：{@link HashSet}，{@link LinkedHashSet}能存储null，{@link TreeSet}不能。<br>
 */
public class CollectionsQuestion
{

}



/**
 * 1.{@link ArrayList}的默认容量是多少？最大容量是多少？每次扩容多少？<br>
 * 默认容量是10。最大容量是是2的31次方减1。每次扩容为原来的1.5倍。<br>
 * <br>
 * 2.{@link ArrayList}继承了什么类?实现了哪些接口?<br>
 * 继承了{@link AbstractList}，实现了{@link List}, {@link RandomAccess}, {@link Cloneable}, {@link Serializable}接口。<br>
 * <br>
 * 3.分析代码{@link ArrayListQuestion#test1()}，其中{@link ArrayListQuestion#list1}和{@link ArrayListQuestion#list2}
 * 扩容了几次?是在添加第几个元素时扩容?<br>
 * {@link ArrayListQuestion#list1}：扩容0次。<br>
 * {@link ArrayListQuestion#list2}：扩容3次，添加第1个元素时扩容为10，第11个元素时扩容为10的1.5倍15，第16个元素扩容为15的1.5倍22。<br>
 * <br>
 * 4.为什么{@link ArrayList}中实际存储元素的elementData数组要设计成transient？<br>
 * 因为{@link ArrayList}实际存储的元素数量比elementData数组的长度小。elementData数组不需要全部序列化,在writeObject方法中手动序列化实际存储的元素。<br>
 * <br>
 * 5.{@link ArrayList}和{@link LinkedList}的区别？<br>
 * a.{@link ArrayList}是用数组实现的，{@link LinkedList}是用双向链表实现的。<br>
 * b.按下标获取({@link List#get(int)})元素，修改({@link List#set(int, Object)})元素<br>
 * {@link ArrayList}比{@link LinkedList}快。 <br>
 * c.插入({@link List#add(int, Object)} )，删除({@link List#remove(int)})元素<br>
 * 在通常情况下{@link LinkedList}比{@link ArrayList}快，因为{@link ArrayList}可能需要把后面的元素全部向前或向后移动。<br>
 * <br>
 * 6.
 */
class ArrayListQuestion
{
    public static List<Integer> list1;
    public static List<Integer> list2;

    public static void test1()
    {
        list1 = new ArrayList<>(20);
        for (int i = 0; i < 20; i++)
        {
            list1.add(0);
        }
        list2 = new ArrayList<>();
        for (int i = 0; i < 20; i++)
        {
            list2.add(0);
        }
    }
}

/**
 * 1.{@link LinkedList}继承了什么类?实现了哪些接口？<br>
 * 继承了{@link AbstractSequentialList}， 实现了{@link List}, {@link Deque}, {@link Cloneable}, {@link Serializable}
 * 接口。<br>
 */
class LinkedListQuestion
{

}

/**
 * 1.{@link HashMap}的默认容量是多少？最大容量是多少？每次扩容多少？<br>
 * 默认容量是16。最大容量是2的30次方。扩容为原来的2倍。<br>
 * 2.分析代码{@link HashMapQuestion#test1()}，其中{@link HashMapQuestion#map}是在什么时候扩容？<br>
 * {@link HashMap}的默认负载因子为0.75，阈值=容量*负载因子=12，当HashMap存储到第12个键值对时扩容。<br>
 * 3.实现{@link HashMap}的数据结构是什么？<br>
 * 数组，数组的每个位置存储一个链表或红黑树的头结点。<br>
 * 4.什么是hash碰撞？{@link HashMap}如何解决hash碰撞？<br>
 * hash碰撞：两个键值对存储到数组的同一个位置。<br>
 * 添加到数组那个位置的链表的末尾，如果链表长度大于8，转换为红黑树。<br>
 * 5.{@link HashMap}计算键的hash值的过程是怎样的？<br>
 * 如果键是null，hash值是0。<br>
 * 如果键不是null，调用键的hashCode()方法计算出键的hash值，然后将hash值向右移动16位后和hash值进行与运算。<br>
 * 6.为什么{@link HashMap}的容量必须是2的n次幂?<br>
 * 因为一个键值对的存储位置是通过hash对数组长度取模计算出来的。容量是2的n次幂时，hash对数组长度取模等价于哈希码&(数组长度-1)，加快计算速度。<br>
 * 7.{@link HashMap}的扩容过程？<br>
 * 如果原容量超过2的30次方，直接把阈值设置为int的最大值，不扩容。否则扩容为原来的2倍。<br>
 * 然后顺序判断数组每个元素，是否有下一个结点，如果没有，计算在新的数组上的位置，然后移动过去。<br>
 * 如果有下一个结点，判断头结点类型，<br>
 * 如果是红黑树结点，。。。，如果是链表结点，将链表结点和原容量相与，如果结果是0，说明在存储位置不变，否则存储位置为原位置加原容量。<br>
 */
class HashMapQuestion
{
    public static Map<String, String> map;

    public static void test1()
    {
        map = new HashMap<>();
        for (int i = 0; i < 20; i++)
        {
            map.put("", "");
        }
    }

}
