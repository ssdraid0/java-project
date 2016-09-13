package algorithm.剑指offer;

import data_structure.list.SinglyLinkedListNode;
import data_structure.list.LinkedListUtil;

/**
 * 面试题 16：反转链表 <br>
 * 题目：定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的 头结点。<br>
 */
public class Q16
{
    public static void main(String[] args)
    {
        SinglyLinkedListNode node1=new SinglyLinkedListNode();
        SinglyLinkedListNode node2=new SinglyLinkedListNode();
        SinglyLinkedListNode node3=new SinglyLinkedListNode();
        SinglyLinkedListNode node4=new SinglyLinkedListNode();
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node1.data=1;
        node2.data=2;
        node3.data=3;
        node4.data=4;
        System.out.println(LinkedListUtil.reverse(node1).data);
    }
}
