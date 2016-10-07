package algorithm;

import java.util.Stack;

/**
 * 1.写一个类实现栈。<br>
 * 有两个方法：<br>
 * {@link MyStack#push(int)}，{@link MyStack#pop()}。<br>
 * 2.输入两个int数组，一个表示入栈序列，一个表示出栈序列，如果出栈序列正确，返回true。 <br>
 * {@link #isPopOrder(int[], int[])}。<br>
 * 3.写一个类{@link QueueUseStack}，用两个栈实现队列，有两个方法：<br>
 * {@link QueueUseStack#append(Object)}，{@link QueueUseStack#remove()}。<br>
 */
@SuppressWarnings("unused")
public class StackQueueQ
{
    public static void main(String[] args)
    {

    }

    public static class MyStack
    {
        private int[] value = new int[10];
        private int length = 0;

        public void push(int x)
        {
            if (length == value.length) return;
            value[length++] = x;
        }

        public int pop() throws Exception
        {
            if (length == 0) throw new Exception();
            int i = value[length - 1];
            length--;
            return i;
        }
    }

    /**
     * 写一个类，用两个栈实现队列，在尾部添加元素方法和在头部移出元素方法。<br>
     * {@link QueueUseStack} <br>
     * https://leetcode.com/problems/implement-stack-using-queues/<br>
     * http://zhedahht.blog.163.com/blog/static/2541117420073293950662/<br>
     */
    public static class QueueUseStack<E>
    {
        private Stack<E> stack1 = new Stack<E>();
        private Stack<E> stack2 = new Stack<E>();

        public void append(E e)
        {
            stack1.push(e);
        }

        public E remove()
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
                return null;
            }
            return stack2.pop();
        }
    }

    /**
     * 输入两个int数组，一个表示入栈序列，一个表示出栈序列，栈的所有数字都不相等。<br>
     * 如果出栈序列正确，返回true。<br>
     * http://zhedahht.blog.163.com/blog/static/25411174200732102055385/<br>
     * http://blog.csdn.net/wuya814070935/article/details/48972495<br>
     */
    public static boolean isPopOrder(int[] push, int[] pop)
    {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0, j = 0; i < push.length; i++)
        {
            stack.push(push[i]);
            while (stack.size() > 0 && stack.peek() == pop[j])
            {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 写一个类，用两个栈实现，具有三种方法：<br>
     * {@link MyStack#push(int)}：入栈。<br>
     * {@link MyStack#pop()}：出栈。<br>
     * {@link MyStack#min()}：获取最小元素。<br>
     * http://zhedahht.blog.163.com/blog/static/25411174200712895228171/<br>
     * https://leetcode.com/problems/min-stack<br>
     * https://discuss.leetcode.com/topic/41486/short-simple-java-solution-12-line<br>
     */
    public static class MinStack
    {
        private int[] value = new int[10];
        private int length = 0;
        private int min = Integer.MAX_VALUE;

        public void push(int x) throws Exception
        {
            if (length == value.length) throw new Exception();
            if (x <= min)
            {
                value[length++] = min;
                min = x;
            }
            value[length++] = x;
        }

        public int pop() throws Exception
        {
            if (length == 0) throw new Exception();
            int i = value[length - 1];
            if (value[length - 1] == min)
            {
                length--;
                min = value[length--];
            } else length--;
            return i;
        }

        public int min()
        {
            return min;
        }
    }

    
    private static void isPopOrderTest()
    {
        int[] push = { 1, 2, 3, 4, 5 };
        int[] pop1 = { 1, 2, 3, 4, 5 };
        int[] pop2 = { 1, 4, 3, 2, 5 };
        System.out.print(isPopOrder(push, pop1) + ",");
        System.out.print(isPopOrder(push, pop2) + ",");
    }
}
