package algorithm.剑指offer;

import data_structure.list.SinglyLinkedListNode;
import data_structure.list.LinkedListUtil;

/**
 * 面试题 13：在 O(1)时间删除链表结点。<br>
 * 题目：给定单向链表的头指针和一个结点指针，定义一个函数在 O(1)时间删除该结点。
 */
public class Q13
{
    public static void main(String[] args)
    {
        SinglyLinkedListNode node1 = new SinglyLinkedListNode();
        SinglyLinkedListNode node2 = new SinglyLinkedListNode();
        SinglyLinkedListNode node3 = new SinglyLinkedListNode();
        node1.next = node2;
        node2.next = node3;
        node1.data = 1;
        node2.data = 2;
        node3.data = 3;
        LinkedListUtil.deleteNode(node1, node2);
    }
}
