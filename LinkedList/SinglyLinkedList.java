public class SinglyLinkedList {

    private UnidirectionalNode head;

    public SinglyLinkedList(int initial){
        head = new UnidirectionalNode(initial);
    }

    public SinglyLinkedList(UnidirectionalNode _head){
        this.head = _head;
    }

    public UnidirectionalNode getTail(UnidirectionalNode head){
        if (head ==null){
            System.out.println("Cannot get tail because head is null.");
            return null;
        }

        UnidirectionalNode current = head;

        while(current.getNextNode()!=null){
            current = current.getNextNode();
        }

        return current;
    }

    public UnidirectionalNode getHead(){
        return head;
    }

    //this method should not be called from outside of this class
    private UnidirectionalNode setHead(UnidirectionalNode node) {
        this.head = node;
        return head;
    }

    public void addNode(int value){
        UnidirectionalNode newNode = new UnidirectionalNode(value);
        addNode(newNode);
    }

    public void addNode(UnidirectionalNode node){
        if(head ==null){
            System.out.println("Cannot add node because head is null.");
            return;
        }

        UnidirectionalNode tail = getTail(head);
        tail.setNextNode(node);

    }

    public boolean isSorted(){
        if (head == null){
            System.out.println("The list is empty.");
            return true;
        }

        if (head.getNextNode() == null){
            System.out.println("The list has only 1 node.");
            return true;
        }

        boolean result = true;
        UnidirectionalNode current = head;

        while (current.getNextNode()!= null){
            if (current.getValue() > current.getNextNode().getValue()){
                result = false;
                break; //the current node cannot be greater than its successor
            }
            else
                current = current.getNextNode();
        }

        return result;

    }

    public static SinglyLinkedList mergeTwoSortedList(SinglyLinkedList list1, SinglyLinkedList list2){
        SinglyLinkedList mergedList = new SinglyLinkedList(0);;
        if (list1 == null || list2 == null){
            System.out.println("One of the list is null.");
            return mergedList;
        }

        if(!list1.isSorted() || !list2.isSorted()){
            System.out.println("One of the list is not sorted.");
            return mergedList;
        }

        UnidirectionalNode head1 = list1.getHead();
        UnidirectionalNode head2 = list2.getHead();

        while (head1!=null && head2!=null){
            if (head1.getValue() <= head2.getValue()){
                mergedList.addNode(head1.getValue());
                head1 = head1.getNextNode();
            }
            else{
                mergedList.addNode(head2.getValue());
                head2 = head2.getNextNode();
            }

        }

        if (head1!=null){
            while(head1!=null) {
                mergedList.addNode(head1.getValue());
                head1 = head1.getNextNode();
            }
        }

        if (head2!=null){
            while(head2!=null) {
                mergedList.addNode(head2.getValue());
                head2 = head2.getNextNode();
            }
        }

        //get rid of the first dummy node
        mergedList.setHead(mergedList.getHead().getNextNode());

        return mergedList;


    }

    //Reverse the direction in-place as we move along the
    public UnidirectionalNode reverse(){
        if (head == null){
            System.out.println("The list is empty.");
            return null;
        }

        if (head.getNextNode() == null){
            System.out.println("The list has only 1 node.");
            return head;
        }

        UnidirectionalNode current = head;
        UnidirectionalNode prev = null;

        while(current.getNextNode()!=null){
            head = current.getNextNode();
            current.setNextNode(prev);
            prev = current;
            current = head;
        }

        //the last node now will be the head
        head.setNextNode(prev);

        return head;
    }
    @Override
    public String toString(){
        if (head == null){
            System.out.println("Head is null -> empty list");
            return new String();
        }
        //list has only 1 node then just print the head
        if (head.getNextNode()==null){
            return head.toString();
        }

        StringBuilder sb = new StringBuilder();
        UnidirectionalNode current = head;

        while (current.getNextNode()!=null){
            sb.append(current);
            current = current.getNextNode();
        }
        //print the tail
        sb.append(current);

        return sb.toString();

    }

}
