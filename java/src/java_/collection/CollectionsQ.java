package java_.collection;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

/**
 *  ⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽<br/>
 * 1.继承了哪些类，实现了哪些接口？ </br>
 * </br>
 * 2.{@link List}，{@link Map}，{@link Set}的区别？</br>
 * ⑴.哪些能存储重复的元素？</br>
 * {@link List}的元素能重复。{@link Set}的元素不能重复，{@link Map}的键不能重复。</br>
 * ⑵.哪些能保证顺序？（添加元素的顺序和遍历元素的顺序相同）</br>
 * {@link List}：保证顺序。</br>
 * {@link Map}：{@link LinkedHashMap}保证顺序，{@link HashMap}，{@link TreeMap}不保证顺序。</br>
 * {@link Set}：{@link LinkedHashSet}保证顺序，{@link HashSet}，{@link TreeSet}不保证顺序。</br>
 * ⑶.哪些能按下标操作元素？</br>
 * {@link List}能按下标操作元素，{@link Map}和{@link Set}不能。</br>
 * ⑷.哪些能存储null？</br>
 * {@link List}：能存储null。</br>
 * {@link Map}：{@link HashMap}，{@link LinkedHashMap}的键能为null，{@link TreeMap}不能。</br>
 * {@link Set}：{@link HashSet}，{@link LinkedHashSet}能存储null，{@link TreeSet}不能。</br>
 * </br>
 * 3.{@link Vector}和{@link Collections#synchronizedList(List)}是如何实现线程安全的？</br>
 * {@link Vector}：sychronized修饰方法。</br>
 * {@link Collections#synchronizedList(List)}：sychronized修饰代码块。</br>
 * http://www.hollischuang.com/archives/498</br>
 */
public class CollectionsQ
{

}