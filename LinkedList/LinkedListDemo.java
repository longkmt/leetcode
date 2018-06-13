public class LinkedListDemo {

    public static void main(String[] args){
        SinglyLinkedList singlyList = new SinglyLinkedList(1);
        singlyList.addNode(2);
        singlyList.addNode(3);
        singlyList.addNode(4);
        singlyList.addNode(5);


        SinglyLinkedList list1 = new SinglyLinkedList(0);
        list1.addNode(3);
        list1.addNode(10);
        list1.addNode(12);
        list1.addNode(99);

        SinglyLinkedList list2 = new SinglyLinkedList(1);
        list2.addNode(2);
        list2.addNode(20);
        list2.addNode(99);
        list2.addNode(100);
        list2.addNode(200);
        list2.addNode(500);

        SinglyLinkedList mergedList = SinglyLinkedList.mergeTwoSortedList(list1,list2);

        System.out.println("Singly linked list 1: " +list1.toString());

        System.out.println("Singly linked list 2: " +list2.toString());

        System.out.println("List 1 merges list 2: " + mergedList.toString());
    }
}
