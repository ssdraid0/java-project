package data_structure.list;

public class DoublyLinkedList<E>
{
    private static class Node<E>
    {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next)
        {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
    
    int size = 0;
    Node<E> first;
    Node<E> last;

    public void add(int index, E element)
    {
        if (index == size)
            linkLast(element);
        else
        linkBefore(element, node(index));
    }

    public E remove(int index)
    {
        return unlink(node(index));
    }

    public E get(int index)
    {
        return node(index).item;
    }

    public void reverse()
    {
        Node<E> a = first;
        Node<E> b = last;
        for (int i = 0, mid = size >> 1; i < mid; i++)
        {
            E e = a.item;
            a.item = b.item;
            b.item = e;
            a = a.next;
            b = b.prev;
        }
    }

    private Node<E> node(int index)
    {
        if (index < (size >> 1))
        {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else
        {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    private E unlink(Node<E> x)
    {
        // assert x != null;
        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null)
        {
            first = next;
        } else
        {
            prev.next = next;
            x.prev = null;
        }

        if (next == null)
        {
            last = prev;
        } else
        {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }

    private void linkBefore(E e, Node<E> succ)
    {
        final Node<E> pred = succ.prev;
        final Node<E> newNode = new Node<>(pred, e, succ);
        succ.prev = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
    }

    void linkLast(E e)
    {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }


}
