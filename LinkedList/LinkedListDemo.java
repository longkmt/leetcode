import java.util.ArrayList;
import java.util.List;

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

        SinglyLinkedList list3 = new SinglyLinkedList(8);

        System.out.println("Singly linked list 1: " +list1.toString());

        System.out.println("Singly linked list 2: " +list2.toString());

        System.out.println("Singly linked list 3: " +list3.toString());

        List<SinglyLinkedList> lists = new ArrayList<SinglyLinkedList>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);

        SinglyLinkedList mergedList1 = SinglyLinkedList.mergeKSortedLinkedListBruteForce(lists);
        SinglyLinkedList mergedList2 = SinglyLinkedList.mergeKSortedLinkedListUsingHeap(lists);
        SinglyLinkedList mergedList3 = SinglyLinkedList.mergeKSortedLinkedListDivideNConquer(lists);


        System.out.println("List 1 merges list 2 merges list 3 brute force: " + mergedList1.toString());
        System.out.println("List 1 merges list 2 merges list 3 using heap: " + mergedList2.toString());
        System.out.println("List 1 merges list 2 merges list 3 using divide-n-conquer: " + mergedList3.toString());
    }
}
