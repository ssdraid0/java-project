package data_structure.list;

import java.util.Stack;

public class LinkedListUtil
{
    /**
     * 输入一个单向链表的头结点，从尾到头反过来打印出每个结点的值。
     * 
     * @param linkedList
     */
    public static void printReverse(SinglyLinkedListNode head)
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
     * 给定单向链表的头指针和一个结点指针，在 O(1)时间删除该结点。
     */
    public static void deleteNode(SinglyLinkedListNode head, SinglyLinkedListNode del)
    {
        if (del == null || head == null)
        {
            return;
        }
        if (head == del)
        {// 删除头结点
            head = null;
        } else
        {
            if (del.next == null)
            {// 删除尾结点
                SinglyLinkedListNode pointListNode = head;
                while (pointListNode.next.next != null)
                {
                    pointListNode = pointListNode.next;
                }
                pointListNode.next = null;
            } else
            {
                del.data = del.next.data;
                del.next = del.next.next;
            }
        }
    }

    /**
     * 找到单向链表中倒数第 k 个结点
     * 
     * @param head
     * @param lastIndex
     * @return
     */
    public static SinglyLinkedListNode getLastNode(SinglyLinkedListNode head, int lastIndex)
    {
        if (lastIndex <= 0)
            return null;
        SinglyLinkedListNode node1 = head;
        SinglyLinkedListNode node2 = head;
        int i = 0;
        while (node2 != null)
        {
            node2 = node2.next;
            i++;
            if (i >= lastIndex)
            {
                if (node2 == null)
                {
                    return node1;
                }
                node1 = node1.next;
            }
        }
        return null;
    }

    /**
     * 输入一个单链表的头结点，反转单链表，返回反转后的头结点。
     * 
     * @param head
     *            头结点
     * @return 头结点
     */
    public static SinglyLinkedListNode reverse(SinglyLinkedListNode head)
    {
        SinglyLinkedListNode prev = null;
        SinglyLinkedListNode next = null;
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
     * 输入两个有序的单链表的头结点，合并后仍然是有序的，返回合并后的头结点
     */
    public static SinglyLinkedListNode merge(SinglyLinkedListNode head1, SinglyLinkedListNode head2)
    {
        if (head1 == null)
        {
            return head2;
        } else if (head2 == null)
        {
            return head1;
        }
        SinglyLinkedListNode mergeHead = null;
        if (head1.data < head2.data)
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
     * 复制复杂链表，返回复制后的头结点
     * 
     * @param head
     * @return
     */
    public static ComplexLinkedListNode clone(ComplexLinkedListNode head)
    {
        if (head == null)
            return null;
        cloneNodes(head);
        connectSiblingNodes(head);
        return reconnectNodes(head);
    }

    private static void cloneNodes(ComplexLinkedListNode head)
    {
        ComplexLinkedListNode node = head;
        while (node != null)
        {
            ComplexLinkedListNode cloneNode = new ComplexLinkedListNode();
            cloneNode.data = node.data;
            cloneNode.next = node.next;
            cloneNode.sibling = null;
            node.next = cloneNode;
            node = cloneNode.next;
        }
    }

    private static void connectSiblingNodes(ComplexLinkedListNode head)
    {
        ComplexLinkedListNode node = head;
        while (node != null)
        {
            ComplexLinkedListNode clonedNode = node.next;
            if (node.sibling != null)
            {
                // 复制的结点的sibling指向原结点的sibling的下一个结点，建议画张图观察。
                clonedNode.sibling = node.sibling.next;
            }
            node = clonedNode.next;
        }
    }

    private static ComplexLinkedListNode reconnectNodes(ComplexLinkedListNode head)
    {
        ComplexLinkedListNode node = head;
        ComplexLinkedListNode clonedHead = node.next;
        ComplexLinkedListNode clonedNode = clonedHead;
        node.next = clonedNode.next;
        node = node.next;
        while (node != null)
        {
            clonedNode.next = node.next;
            clonedNode = clonedNode.next;
            node.next = clonedNode.next;
            node = node.next;
        }
        return clonedHead;
    }

    /**
     * 输入两个单链表的头结点，返回它们的第一个相同结点（说明之后的每个结点也相同）。
     */
    public static SinglyLinkedListNode findFirstCommonNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2)
    {
        int len1 = getLength(head1);
        int len2 = getLength(head2);
        SinglyLinkedListNode longListNode = null;
        SinglyLinkedListNode shortListNode = null;
        int dif = 0;
        if (len1 > len2)
        {
            longListNode = head1;
            shortListNode = head2;
            dif = len1 - len2;
        } else
        {
            longListNode = head2;
            shortListNode = head1;
            dif = len2 - len1;
        }
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

    private static int getLength(SinglyLinkedListNode head)
    {
        int result = 0;
        for (SinglyLinkedListNode point = head; point != null; point = point.next)
        {
            result++;
        }
        return result;
    }
}
