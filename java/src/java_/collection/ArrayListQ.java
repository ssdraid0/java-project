package java_.collection;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.RandomAccess;

/**
 * ⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽</br>
 * 1.{@link ArrayList}继承了什么类?实现了哪些接口?</br>
 * 继承了{@link AbstractList}，实现了{@link List}, {@link RandomAccess}接口。</br>
 * </br>
 * 2.{@link ArrayList}的默认容量是多少？最大容量是多少？每次扩容多少？</br>
 * 默认容量是10。最大容量是是2的31次方减1。每次扩容为原来的1.5倍。</br>
 * </br>
 * 3. 分析代码
 * 
 * <pre>
 * List<Integer> list1 = new ArrayList<>(20);
 * for (int i = 0; i < 20; i++)
 *     list1.add(0);
 * List<Integer> list2 = new ArrayList<>();
 * for (int i = 0; i < 20; i++)
 *     list2.add(0);
 * </pre>
 * 
 * 其中list1和list2扩容了几次？是在添加第几个元素时扩容？</br>
 * list1：扩容0次，在构造方法中就已经分配了长度为20的数组。</br>
 * list2：扩容3次，添加第1个元素时扩容为10，第11个元素时扩容为10的1.5倍15，第16个元素扩容为15的1.5倍22。</br>
 * </br>
 * 4.为什么{@link ArrayList}中实际存储元素的elementData数组要设计成transient？</br>
 * 因为{@link ArrayList}实际存储的元素数量比elementData数组的长度小。</br>
 * elementData数组不需要全部序列化,在writeObject方法中手动序列化实际存储的元素。</br>
 * </br>
 * 5.{@link ArrayList}和{@link LinkedList}的区别？</br>
 * a.{@link ArrayList}是用数组实现的，{@link LinkedList}是用双向链表实现的。</br>
 * b.按下标获取元素({@link List#get(int)})，修改元素({@link List#set(int, Object)})，</br>
 * {@link ArrayList}比{@link LinkedList}快。 </br>
 * c.插入元素({@link List#add(int, Object)} )，删除元素({@link List#remove(int)})，</br>
 * {@link LinkedList}比{@link ArrayList}快，因为{@link ArrayList}可能需要把后面的元素全部向前或向后移动。</br>
 * </br>
 * 6.{@link ArrayList#Itr}中的expectedModCount的作用是什么？</br>
 * </br>
 */
public class ArrayListQ
{
    public static void test1()
    {
        List<Integer> list1 = new ArrayList<>(20);
        for (int i = 0; i < 20; i++)
            list1.add(0);
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < 20; i++)
            list2.add(0);
    }
}
