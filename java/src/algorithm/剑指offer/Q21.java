package algorithm.剑指offer;

import java.util.Stack;

/**
 * 面试题 21：包含 min 函数的栈 题目：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min 函数。在该栈中，调用min、
 * push及pop德尔时间复杂度都是O(1)
 */
public class Q21
{
    private Stack<Integer> minStack = new Stack<>();
    private Stack<Integer> dataStack = new Stack<>();

    public void push(Integer item)
    {
        dataStack.push(item);
        if (minStack.size() == 0 || item <= minStack.peek())
        {
            minStack.push(item);
        } else
        {
            minStack.push(minStack.peek());
        }
    }

    public Integer pop()
    {
        if (dataStack.size() == 0 || minStack.size() == 0)
        {
            return null;
        }
        minStack.pop();
        return dataStack.pop();
    }

    public Integer min()
    {
        if (minStack.size() == 0)
            return null;
        return minStack.peek();
    }

    public static void main(String[] args)
    {
        Q21 q21 = new Q21();
        q21.push(5);
        System.out.print(q21.min());
        q21.push(3);
        System.out.print(q21.min());
        q21.push(1);
        System.out.print(q21.min());
        q21.push(2);
        System.out.print(q21.min());
        q21.push(4);
        System.out.print(q21.min());
    }
}
