package algorithm;

import java.util.Stack;

/**
 * 1.给定单链表的头结点和一个结点，删除该结点，返回删除后的单链表的头结点。 <br>
 * {@link #remove(Node, Node)}。<br>
 * 2.给定单链表的头结点和一个结点的值，删除该结点，返回删除后的单链表的头结点。 <br>
 * {@link #remove(Node, int)}。<br>
 * 3.输入一个单链表的头结点，从尾到头反过来打印出单链表每个结点的值，用递归实现。<br>
 * {@link #printReverse(Node)}。<br>
 * 4.输入一个单链表的头结点，反转单链表，返回反转后的头结点。<br>
 * {@link #reverse(Node)}。<br>
 * 5.输入一个单链表的头结点和一个int类型k，找到单链表中倒数第k 个结点。<br>
 * {@link #getLastNode(Node, int)}。<br>
 * 6.输入两个有序的单链表的头结点，合并后仍然是有序的，返回合并后的头结点。<br>
 * {@link #mergeSort(Node, Node)}。<br>
 * 7.输入一个复杂单链表的头结点，其结点除了有一个next指向下一个结点外，<br>
 * 还有一个other指向链表中的任一结点或者null。 复制这个单链表并返回头结点。<br>
 * {@link #clone(ComplexNode)}。<br>
 */
public class LinkedListQuestion
{
    public static void main(String[] args)
    {
        deleteNodeTest();
    }

    private static class Node
    {
        public int value;
        public Node next;

        @Override
        public String toString()
        {
            return Integer.toString(value);
        }
    }

    private static class ComplexNode
    {
        public int value;
        public ComplexNode next;
        public ComplexNode other;

        @Override
        public String toString()
        {
            return Integer.toString(value);
        }
    }

    /**
     * 给定单链表的头结点和一个结点，删除该结点，返回删除后的单链表的头结点。
     */
    public static Node remove(Node head, Node del)
    {
        if (head == null || head.next == null)
            return null;
        if (head == del)
            return head.next;
        Node point = head;
        while (point.next != del)
        {
            point = point.next;
        }
        point.next = point.next.next;
        return head;
    }

    /**
     * 给定单链表的头结点和一个结点的值，删除该结点，返回删除后的单链表的头结点。
     */
    public static Node remove(Node head, int data)
    {
        if (head == null || head.next == null)
            return null;
        if (head.value == data)
            return head.next;
        Node point = head;
        while (point.next.value != data)
        {
            point = point.next;
        }
        point.next = point.next.next;
        return head;
    }

    /**
     * 输入一个单链表的头结点，反转单链表，返回反转后的头结点。<br>
     */
    public static Node reverse(Node head)
    {
        if (head == null || head.next == null)
            return head;
        Node prev = null;
        Node next = null;
        while (head != null)
        {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    /**
     * 输入一个单链表的头结点，从尾到头反过来打印出单链表每个结点的值，用递归实现。<br>
     */
    public static void printReverse(Node head)
    {
        if (head == null)
            return;
        printReverse(head.next);
        System.out.print(head.value);
    }

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

    /**
     * 输入两个有序的单链表的头结点，合并后仍然是有序的，返回合并后的头结点。<br>
     */
    public static Node mergeSort(Node head1, Node head2)
    {
        if (head1 == null)
        {
            return head2;
        }
        if (head2 == null)
        {
            return head1;
        }
        Node mergeHead = null;
        if (head1.value <= head2.value)
        {
            mergeHead = head1;
            mergeHead.next = mergeSort(head1.next, head2);
        } else
        {
            mergeHead = head2;
            mergeHead.next = mergeSort(head1, head2.next);
        }
        return mergeHead;
    }

    /**
     * 输入两个单链表的头结点，返回它们的第一个相同结点（说明之后的每个结点也相同）。<br>
     */
    public static Node findFirstCommon(Node head1, Node head2)
    {
        int len1 = getLength(head1), len2 = getLength(head2);
        Node longNode = null, shortNode = null;
        int dif = len1 - len2;
        if (dif >= 0)
        {
            longNode = head1;
            shortNode = head2;
        } else
        {
            longNode = head2;
            shortNode = head1;
        }
        dif = Math.abs(dif);
        for (int i = 0; i < dif; i++)
        {
            longNode = longNode.next;
        }
        while (longNode != null && shortNode != null && longNode != shortNode)
        {
            longNode = longNode.next;
            shortNode = shortNode.next;
        }
        return longNode;
    }

    /**
     * 输入一个复杂单链表的头结点。<br>
     * 其结点除了有一个next指向下一个结点外，还有一个other指向链表中的任一结点或者null。<br>
     * 复制这个复杂单链表并返回头结点。<br>
     * http://zhedahht.blog.163.com/blog/static/254111742010819104710337/<br>
     */
    public static ComplexNode clone(ComplexNode head)
    {
        if (head == null)
            return null;
        cloneNodes(head);
        connectOtherNodes(head);
        return reconnectNodes(head);
    }

    private static void cloneNodes(ComplexNode head)
    {
        while (head != null)
        {
            ComplexNode cloneNode = new ComplexNode();
            cloneNode.value = head.value;
            cloneNode.next = head.next;
            cloneNode.other = null;
            head.next = cloneNode;
            head = cloneNode.next;
        }
    }

    private static void connectOtherNodes(ComplexNode head)
    {
        while (head != null)
        {
            ComplexNode cloneNode = head.next;
            if (head.other != null)
            {
                // 复制的结点的other指向原结点的other的下一个结点，建议画张图观察。
                cloneNode.other = head.other.next;
            }
            head = cloneNode.next;
        }
    }

    private static ComplexNode reconnectNodes(ComplexNode head)
    {
        ComplexNode cloneHead = head.next;
        ComplexNode cloneNode = cloneHead;
        while (head != null)
        {
            head.next = cloneNode.next;
            head = head.next;
            if (head != null)
            {
                cloneNode.next = head.next;
                cloneNode = cloneNode.next;
            }
        }
        return cloneHead;
    }

    /**
     * 输入一个单链表的头结点，从尾到头反过来打印出单链表每个结点的值，用栈实现。<br>
     */
    public static void printReverseUseStack(Node head)
    {
        if (head == null)
            return;
        Stack<Integer> stack = new Stack<>();
        while (head != null)
        {
            stack.push(head.value);
            head = head.next;
        }
        while (!stack.isEmpty())
        {
            System.out.println(stack.pop());
        }
    }

    private static int getLength(Node head)
    {
        int result = 0;
        for (Node point = head; point != null; point = point.next)
        {
            result++;
        }
        return result;
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

    private static void deleteNodeTest()
    {
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        node1.value = 1;
        node2.value = 2;
        node3.value = 3;
        node1.next = node2;
        node2.next = node3;
        Node node = remove(node1, node3);
        print(node);
        Node head2 = remove(node1, 2);
        print(head2);
    }

    private static void print(Node node)
    {
        while (node != null)
        {
            System.out.print(node.value + ",");
            node = node.next;
        }
        System.out.println();
    }
}
