package data_structure.list;

public class Test
{
    public static void main(String[] args)
    {
        DoublyLinkedList<Integer> myLinkedList = new DoublyLinkedList<>();
        myLinkedList.add(0, 1);
        myLinkedList.add(0, 2);
        System.out.println(myLinkedList.get(0));
        System.out.println(myLinkedList.get(1));
        myLinkedList.reverse();
        System.out.println(myLinkedList.get(0));
        System.out.println(myLinkedList.get(1));
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add(0, 1);
        singlyLinkedList.add(0, 2);
        System.out.println(singlyLinkedList.get(0));
        System.out.println(singlyLinkedList.get(1));
        singlyLinkedList.reverse();
        System.out.println(singlyLinkedList.get(0));
        System.out.println(singlyLinkedList.get(1));
    }
}
