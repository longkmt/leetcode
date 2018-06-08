public class DemoLinkedList {

    public static void main(String[] args){
        SinglyLinkedList singlyList = new SinglyLinkedList(1);
        singlyList.addNode(2);
        singlyList.addNode(3);
        singlyList.addNode(4);
        singlyList.addNode(5);

        System.out.println("Singly linked list: " +singlyList.toString());

        singlyList.reverse();

        System.out.println("Singly linked list reversed: " +singlyList.toString());
    }
}
