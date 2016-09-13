package algorithm.剑指offer;

import data_structure.list.SinglyLinkedListNode;
import data_structure.list.LinkedListUtil;

/**
 * 面试题 15：链表中倒数第 k 个结点。<br>
 * 题目：输入一个链表，输出该链表中倒数第 k 个结点。为了符合大多数人的习惯， 本题从 1
 * 开始计数，即链表的尾结点是倒数第一个结点。例如一个有 6 个结点的 链表，从头结点依次是 1,2,3,4,5,6。倒数第三个结点就是值为 4 的结点。
 */
public class Q15
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
        System.out.println(LinkedListUtil.getLastNode(node1,0).data);
        }
}
