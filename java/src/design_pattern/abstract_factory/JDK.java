package design_pattern.abstract_factory;

import java.util.ArrayList;
import java.util.LinkedList;

public class JDK
{
    public static void main(String[] args)
    {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        arrayList.addAll(linkedList);
    }
}
