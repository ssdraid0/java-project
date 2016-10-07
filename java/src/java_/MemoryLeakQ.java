package java_;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MemoryLeakQ
{
    public static void main(String[] args)
    {
        test2();
    }

    public static void test1()
    {
        Integer i = 100;
        List<Integer> list = new ArrayList<>();
        list.add(i);
        i = null;
        System.out.println(list.size());
    }

    private static class Student
    {
        public int id;

        public Student(int id)
        {
            this.id = id;
        }

        @Override
        public int hashCode()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + id;
            return result;
        }

        @Override
        public boolean equals(Object obj)
        {
            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;
            Student other = (Student) obj;
            if (id != other.id) return false;
            return true;
        }

        @Override
        public String toString()
        {
            return Integer.toString(id);
        }
    }

    public static void test2()
    {
        Set<Student> set = new HashSet<Student>();
        Student s1 = new Student(0);
        set.add(s1);
        System.out.println("总共:" + set.size()); // 1
        s1.id = 1; // 对应的hashcode值发生改变
        set.remove(s1); // 此时remove不掉，造成内存泄漏
        set.add(s1); // 重新添加，添加成功
        System.out.println("总共:" + set.size()); // 2
        set.remove(s1);
        //set.clear();
        System.out.println("总共:" + set.size()); // 1
    }
}
