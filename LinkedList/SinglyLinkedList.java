import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SinglyLinkedList {

    private UnidirectionalNode head;

    public SinglyLinkedList(int initial){
        head = new UnidirectionalNode(initial);
    }

    public SinglyLinkedList(UnidirectionalNode _head){
        this.head = _head;
    }

    public static SinglyLinkedList mergeTwoSortedList(SinglyLinkedList list1, SinglyLinkedList list2){
        SinglyLinkedList mergedList = new SinglyLinkedList(Integer.MIN_VALUE);;
        if (list1 == null && list2 == null){
            System.out.println("Both of the lists are null.");
            return mergedList;
        }

        //all the merge operations would have some checking to make sure the lists are sorted before-hand.
        //However in case this method gets called by itself so it will need its own internal checking.

        if (list1 == null){
            if (list2.isSorted()) {
                System.out.println("The first list is null. The second list is sorted. Returning the second list.");
                return list2;
            }
            else{
                System.out.println("The first list is null. The second list is not sorted. Returning default list.");
                return mergedList;
            }
        }

        if (list2 == null){
            if (list1.isSorted()) {
                System.out.println("The second list is null. The first list is sorted. Returning the first list.");
                return list1;
            }
            else{
                System.out.println("The second list is null. The first list is not sorted. Returning default list.");
                return mergedList;
            }
        }

        /*if(!list1.isSorted() || !list2.isSorted()){
            System.out.println("One of the list is not sorted.");
            return mergedList;
        }*/

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

    //the first approach would be utilizing the merger 2 sorted linked list to merge the lists one by one
    //the running time for this brute force method would be n+2n+3n+4n+...+kn where k is the number of lists
    //and n is the number of nodes in each list.
    public static SinglyLinkedList mergeKSortedLinkedListBruteForce(List<SinglyLinkedList> lists){

        SinglyLinkedList mergeList = new SinglyLinkedList(Integer.MIN_VALUE); //a initial list

        if (lists == null || lists.isEmpty()){
            System.out.println("The lists is null or empty!");
            return mergeList;
        }

        for(SinglyLinkedList sl: lists){
            if(!sl.isSorted()){
                System.out.println("One of the list is not sorted. Returning the current merged list.");
                return new SinglyLinkedList(Integer.MIN_VALUE); //in case this happens while we merging
            }

            mergeList = mergeTwoSortedList(mergeList,sl);
        }

        //remove the dummy head
        mergeList.setHead(mergeList.getHead().getNextNode());

        return mergeList;
    }

    //the merge operation can be improved if we use the lib PriorityQueue from JDK
    //the idea is to have a heap (implemented as priority queue) which store the smallest node in each list
    //whenever we pop a node from the queue, we add the next node of it back to the queue.
    //the process keeps going until the queue is empty
    //Time complexity: O(logn) is the time it takes to insert a node to the queue, and we have total nk nodes -> total: nk(logk)
    //Space complexity: O(k) since we need to use the heap with size k.
    public static SinglyLinkedList mergeKSortedLinkedListUsingHeap(List<SinglyLinkedList> lists){

        SinglyLinkedList mergeList = new SinglyLinkedList(Integer.MIN_VALUE);

        if (lists == null || lists.isEmpty()){
            System.out.println("The lists is null or empty!");
            return mergeList;
        }

        for(SinglyLinkedList sl: lists){
            if(!sl.isSorted()){
                System.out.println("One of the list is not sorted. Returning the current merged list.");
                return mergeList;
            }
        }

        PriorityQueue<UnidirectionalNode> queue = new PriorityQueue<UnidirectionalNode>(lists.size(), new Comparator<UnidirectionalNode>() {
            @Override
            public int compare(UnidirectionalNode o1, UnidirectionalNode o2) {
                return o1.compareTo(o2);
            }
        });

        for (SinglyLinkedList list : lists){
            queue.add(list.getHead());
        }

        while (!queue.isEmpty()){
            UnidirectionalNode node = queue.poll();
            mergeList.addNode(node.getValue());

            if (node.getNextNode() !=null){
                node = node.getNextNode();
                queue.add(node);
            }
        }

        //remove dummy head
        mergeList.setHead(mergeList.getHead().getNextNode());

        return mergeList;
    }

    //The next approach for merging K sorted linked list is to use divide-n-conquer
    //We use similar algorithm as merge sort where we keep splitting the lists into smaller lists
    //The sub lists will be further split into even smaller sub lists until we cannot split them further (this is when the sub list has only 1 list)
    //We then perform the merge on the sub lists by reusing the mergeTwoSortedList method.
    //Time complexity: split the list with K lists will take logK, merge the sub lists would take nK -> total nKlogK
    //With n is the average number of nodes per linked list.
    //Space complexity: another array of K lists is created for the sack of this algorithm. So K is all, no extra space is used YEAH!
    public static SinglyLinkedList mergeKSortedLinkedListDivideNConquer(List<SinglyLinkedList> lists){

        SinglyLinkedList mergeList = new SinglyLinkedList(Integer.MIN_VALUE);

        if (lists == null || lists.isEmpty()){
            System.out.println("The lists is null or empty!");
            return mergeList;
        }

        for(SinglyLinkedList sl: lists) {
            if (!sl.isSorted()) {
                System.out.println("One of the list is not sorted. Returning the current merged list.");
                return mergeList;
            }
        }
        SinglyLinkedList[] arrayList = lists.toArray(new SinglyLinkedList[0]); //JVM does not know how to cast Object[] to SinglyLinkedList so we need to tell it

        int start = 0;
        int end = arrayList.length-1;

        mergeList = mergeKSortedLinkedListDivideNConquer(arrayList,start,end);

        return mergeList;

    }

    public static SinglyLinkedList mergeKSortedLinkedListDivideNConquer(SinglyLinkedList[] arrayList, int start, int end){
        SinglyLinkedList mergeList;

        if (start == end){ //base case
            return arrayList[start];
        }

        int mid = (start+end)/2;

        SinglyLinkedList mergeList1 = mergeKSortedLinkedListDivideNConquer(arrayList,start,mid);
        SinglyLinkedList mergeList2 = mergeKSortedLinkedListDivideNConquer(arrayList,mid+1,end);
        mergeList = mergeTwoSortedList(mergeList1,mergeList2);

        return mergeList;
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

    //To merge 2 lists L1 (n nodes) and L2 (m nodes), we first loop through each list and compare the node as we move
    //We add the smaller node to the new list and increase the pointer for the lesser list
    //In the end, we check to see which list still have nodes to add, then we keep adding the rest of that list
    //to the new list.
    //Time complexity: (n+m) or n on average, as we loop through 2 lists, plus the isSorted() method would take another (n+m) -> 2(n+m) in total
    //Space complexity: n+m or n on average
    //A good follow up could be merging K sorted linked lists

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
