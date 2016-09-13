package algorithm.剑指offer;

import java.util.Stack;

public class Q07<T>
{
    private Stack<T> stack1 = new Stack<T>();
    private Stack<T> stack2 = new Stack<T>();

    public void appendTail(T t)
    {
        stack1.push(t);
    }

    public T deleteHead() throws Exception
    {
        if (stack2.isEmpty())
        {
            while (!stack1.isEmpty())
            {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty())
        {
            throw new Exception("队列为空，不能删除");
        }
        return stack2.pop();
    }

    public static void main(String args[]) throws Exception
    {
        Q07<String> q7 = new Q07<>();
        q7.appendTail("1");
        q7.appendTail("2");
        q7.appendTail("3");
        q7. deleteHead();
        System.out.println("");
    }
}
