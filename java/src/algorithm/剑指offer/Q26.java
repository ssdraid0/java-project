package algorithm.剑指offer;

import data_structure.list.ComplexLinkedListNode;
import data_structure.list.LinkedListUtil;

/**
 * 面试题 26：复杂链表的复制 <br>
 * 题目：实现函数复制一个复杂链表。在复杂链表中，每个结点除了有一个 next 指针指向下一个结点外，还有一个指向链表中任意结点或 null。<br>
 */
public class Q26
{
    public static void main(String[] args)
    {
        ComplexLinkedListNode root = new ComplexLinkedListNode();
        ComplexLinkedListNode node1 = new ComplexLinkedListNode();
        ComplexLinkedListNode node2 = new ComplexLinkedListNode();
        ComplexLinkedListNode node3 = new ComplexLinkedListNode();
        ComplexLinkedListNode node4 = new ComplexLinkedListNode();
        root.data = 1;
        root.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        root.data = 1;
        node1.data = 2;
        node2.data = 3;
        node3.data = 4;
        node4.data = 5;
        root.sibling = node1;
        node1.sibling = root;
        node3.sibling = node1;
        ComplexLinkedListNode result = LinkedListUtil.clone(root);
        System.out.println(result.data);
    }
}
