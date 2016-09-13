package algorithm.剑指offer;

import data_structure.list.LinkedListUtil;
import data_structure.list.SinglyLinkedListNode;

/**
 * 面试题 37：两个链表的第一个公共结点 题目：输入两个链表，找出它们的第一个公共结点。
 * 从链表的定义可以看出，这两个链表是单链表，如果两个链表有公共节点，那么这两个链表从某一节点开始，它们的下一结点都指向同一个节点，
 * 之后它们所有的节点都是重合的，不可能再出现分叉。所以拓扑形状看起来是Y型。
 */

public class Q37
{
    public static void main(String[] args)
    {
        SinglyLinkedListNode head1 = new SinglyLinkedListNode();
        SinglyLinkedListNode second1 = new SinglyLinkedListNode();
        SinglyLinkedListNode third1 = new SinglyLinkedListNode();
        SinglyLinkedListNode forth1 = new SinglyLinkedListNode();
        SinglyLinkedListNode fifth1 = new SinglyLinkedListNode();
        SinglyLinkedListNode head2 = new SinglyLinkedListNode();
        SinglyLinkedListNode second2 = new SinglyLinkedListNode();
        SinglyLinkedListNode third2 = new SinglyLinkedListNode();
        SinglyLinkedListNode forth2 = new SinglyLinkedListNode();
        head1.next = second1;
        second1.next = third1;
        third1.next = forth1;
        forth1.next = fifth1;
        head2.next = second2;
        second2.next = forth1;
        third2.next = fifth1;
        head1.data = 1;
        second1.data = 2;
        third1.data = 3;
        forth1.data = 6;
        fifth1.data = 7;
        head2.data = 4;
        second2.data = 5;
        third2.data = 6;
        forth2.data = 7;
        System.out.println(LinkedListUtil.findFirstCommonNode(head1, head2));
    }

}
