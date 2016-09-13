package data_structure.list;

public class SinglyLinkedList<E>
{
    int size = 0;
    Node<E> first;

    public void add(int index, E element)
    {
        linkBefore(element, node(index), node(index - 1));
    }

    private Node<E> node(int index)
    {
        if (index < 0 || index >= size)
        {
            return null;
        }
        Node<E> x = first;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x;
    }

    public E get(int index)
    {
        return node(index).item;
    }

    /**
     * 
     * @param e
     * @param succ
     *            插入位置前面的结点
     * @param prev
     *            插入位置的结点
     */
    private void linkBefore(E e, Node<E> succ, Node<E> prev)
    {
        final Node<E> newNode = new Node<>(e, succ);
        if (prev == null)
            first = newNode;
        else
            prev.next = newNode;
        size++;
    }

    public void reverse()
    {
        Node<E> prev = null;
        Node<E> next = null;
        while (first != null)
        {
            next = first.next;
            first.next = prev;
            prev = first;
            first = next;
        }
        first = prev;
    }
}

class Node<E>
{
    E item;
    Node<E> next;

    Node(E element, Node<E> next)
    {
        this.item = element;
        this.next = next;
    }
}
