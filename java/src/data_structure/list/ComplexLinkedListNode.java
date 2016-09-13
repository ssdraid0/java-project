package data_structure.list;

/**
 * 复杂链表，每个结点除了有一个 next 指针指向下一个结点外，还有一个sibling指针指向链表中任意结点或 null。
 */
public class ComplexLinkedListNode
{
    public int data;
    public ComplexLinkedListNode next;
    public ComplexLinkedListNode sibling;

    @Override
    public String toString()
    {
        String s = Integer.toString(data);
        return s;
    }
}
