package algorithm.剑指offer;

import data_structure.list.SinglyLinkedListNode;
import data_structure.list.LinkedListUtil;

/**
 * 面试题 5： 从尾到头打印链表<br>
 * 题目：输入一个单链表的头结点，从尾到头打印出每个结点的值。<br>
 */
public class Q05
{

    public static void main(String[] args)
    {
        SinglyLinkedListNode node1=new SinglyLinkedListNode();
        SinglyLinkedListNode node2=new SinglyLinkedListNode();
        SinglyLinkedListNode node3=new SinglyLinkedListNode();
        node1.data=1;
        node2.data=2;
        node3.data=3;
        node1.next=node2;
        node2.next=node3;
        LinkedListUtil.printReverse(node1);
    }
}
