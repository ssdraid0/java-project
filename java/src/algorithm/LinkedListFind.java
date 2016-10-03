package algorithm;

import algorithm.LinkedListQ.Node;

/**
* 1.输入一个单链表的头结点和一个int类型k，找到单链表中倒数第k 个结点。<br>
* {@link #getLastNode(Node, int)}。<br>
*/
public class LinkedListFind
{
    /**
     * 输入一个单链表的头结点和一个int类型k，找到单链表中倒数第k 个结点。<br>
     */
    public static Node getLastNode(Node head, int lastIndex)
    {
        if (head == null || lastIndex <= 0)
            return null;
        Node slow = head;
        int fastMove = 1;
        for (; head != null; head = head.next)
        {
            if (fastMove <= lastIndex)
            {
                fastMove++;
                continue;
            }
            slow = slow.next;
        }
        return slow;
    }
    
    @SuppressWarnings("unused")
    private static void getLastNodeTest()
    {
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        node1.value = 1;
        node2.value = 2;
        node3.value = 3;
        node1.next = node2;
        node2.next = node3;
        System.out.println(getLastNode(node1, 3).value);
    }
}
