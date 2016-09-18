package algorithm;

import java.util.Stack;

/**
 * 1..输入一个单链表的头结点和另一个结点，在 O(1)时间删除该结点。<br>
 * {@link LinkedListQuestion#deleteNode(SinglyNode, SinglyNode)}。<br>
 * 2.输入一个单链表的头结点，反转单链表，返回反转后的头结点。<br>
 * {@link LinkedListQuestion#reverse(SinglyNode)}。<br>
 * 3.输入一个单链表的头结点，从尾到头反过来打印出单链表每个结点的值。<br>
 * {@link LinkedListQuestion#printReverse(SinglyNode)}。<br>
 */
public class LinkedListQuestion
{
    public static void main(String[] args)
    {
        getLastNodeTest();
    }

    private static class SinglyNode
    {
        public int data;
        public SinglyNode next;
    }

    /**
     * 给定单向链表的头指针和一个结点指针，在 O(1)时间删除该结点。
     */
    public static void deleteNode(SinglyNode head, SinglyNode del)
    {
        if (del == null || head == null)
        {
            return;
        }
        if (head == del)
        {
            head = null;
            return;
        }
        if (del.next == null)
        {
            SinglyNode point = head;
            while (point.next.next != null)
            {
                point = point.next;
            }
            point.next = null;
            return;
        }
        del.data = del.next.data;
        del.next = del.next.next;
    }

    /**
     * 输入一个单链表的头结点，反转单链表，返回反转后的头结点。<br>
     */
    public static SinglyNode reverse(SinglyNode head)
    {
        SinglyNode prev = null;
        SinglyNode next = null;
        while (head != null)
        {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        head = prev;
        return head;
    }

    /**
     * 从尾到头反过来打印出单链表每个结点的值，用栈实现。<br>
     */
    public static void printReverse(SinglyNode head)
    {
        Stack<Integer> stack = new Stack<>();
        while (head != null)
        {
            stack.push(head.data);
            head = head.next;
        }
        while (!stack.isEmpty())
        {
            System.out.println(stack.pop());
        }
    }

    /**
     * 从尾到头反过来打印出单链表每个结点的值，用递归实现。<br>
     */
    public static void printReverse2(SinglyNode head)
    {
        if (head == null)
            return;
        printReverse2(head.next);
        System.out.print(head.data);
    }

    /**
     * 找到单链表中倒数第 k 个结点。<br>
     */
    public static SinglyNode getLastNode(SinglyNode head, int lastIndex)
    {
        if (lastIndex <= 0)
            return null;
        SinglyNode node2 = head;
        int node1Move = 1;
        for (SinglyNode node1 = head; node1 != null; node1 = node1.next)
        {
            if (node1Move <= lastIndex)
            {
                node1Move++;
                continue;
            }
            node2 = node2.next;
        }
        return node2;
    }

    public static void getLastNodeTest()
    {
        SinglyNode node1 = new SinglyNode();
        SinglyNode node2 = new SinglyNode();
        SinglyNode node3 = new SinglyNode();
        node1.data = 1;
        node2.data = 2;
        node3.data = 3;
        node1.next = node2;
        node2.next = node3;
        System.out.println(getLastNode(node1, 3).data);
    }

    /**
     * 输入两个有序的单链表的头结点，合并后仍然是有序的，返回合并后的头结点。<br>
     */
    public static SinglyNode merge(SinglyNode head1, SinglyNode head2)
    {
        if (head1 == null)
        {
            return head2;
        } else if (head2 == null)
        {
            return head1;
        }
        SinglyNode mergeHead = null;
        if (head1.data <= head2.data)
        {
            mergeHead = head1;
            mergeHead.next = merge(head1.next, head2);
        } else
        {
            mergeHead = head2;
            mergeHead.next = merge(head1, head2.next);
        }
        return mergeHead;
    }

    /**
     * 输入两个单链表的头结点，返回它们的第一个相同结点（说明之后的每个结点也相同）。
     */
    public static SinglyNode findFirstCommonNode(SinglyNode head1, SinglyNode head2)
    {
        int len1 = getLength(head1), len2 = getLength(head2);
        SinglyNode longListNode = null, shortListNode = null;
        int dif = len1 - len2;
        if (dif >= 0)
        {
            longListNode = head1;
            shortListNode = head2;
        } else
        {
            longListNode = head2;
            shortListNode = head1;
        }
        dif = Math.abs(dif);
        for (int i = 0; i < dif; i++)
        {
            longListNode = longListNode.next;
        }
        while (longListNode != null && shortListNode != null && longListNode != shortListNode)
        {
            longListNode = longListNode.next;
            shortListNode = shortListNode.next;
        }
        return longListNode;
    }

    private static int getLength(SinglyNode head)
    {
        int result = 0;
        for (SinglyNode point = head; point != null; point = point.next)
        {
            result++;
        }
        return result;
    }
}
