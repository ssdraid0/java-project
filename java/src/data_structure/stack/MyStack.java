package data_structure.stack;

public class MyStack<E>
{
    private Object[] elementData;
    private int elementCount;

    public MyStack (int initialCapacity)
    {
        elementData = new Object[initialCapacity];

    }
    
    public E push(E item)
    {
        if (elementCount == elementData.length)
        {
            return null;
        }
        elementData[elementCount++] = item;
        return item;
    }

    @SuppressWarnings("unchecked")
    public E pop()
    {
        if (empty())
        {
            return null;
        }
        E obj = (E) elementData[elementCount--];
        return obj;
    }

    @SuppressWarnings("unchecked")
    public E peek()
    {
        if (empty())
        {
            return null;
        }
        return (E) elementData[elementCount-1];
    }

    public boolean empty()
    {
        return elementCount == 0;
    }
}
