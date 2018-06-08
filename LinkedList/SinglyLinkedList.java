public class SinglyLinkedList {

    private UnidirectionalNode head;

    public SinglyLinkedList(int initial){
        head = new UnidirectionalNode(initial);
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
