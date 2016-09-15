package data_structure.list;

public class LinkedListUtil
{
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
