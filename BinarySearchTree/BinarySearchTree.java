public class BinarySearchTree {

    private Node root;

    BinarySearchTree(Node _root){
        this.root = _root;
    }

    BinarySearchTree(){
        root = new Node(0);
    }

    public Node getRoot(){
        return root;
    }

    public Node search(int key){
        return search(root,key);
    }

    //this is just an overload method of the original search method
    //for the convenience of passing a node instead of a key
    private Node search(Node currentNode, Node node){
        return search(currentNode, node.getKey());
    }

    //to search for a node, we first check if the node is at root -> return the root
    //otherwise we check if the node > root -> recursively search the right sub tree
    //if the node < root -> recursively search the left sub tree
    private Node search(Node currentNode, int key){

        if (currentNode == null){
            System.out.println("Reach the end of the tree");
            return null;
        }

        if (key == currentNode.getKey()){
            return currentNode;
        }

        if (key < currentNode.getKey()){
            return search(currentNode.getLeftNode(), key);
        }
        else{
            return search(currentNode.getRightNode(),key);
        }

    }

    public void insert(int key){
        Node newNode = new Node(key);
        insert(root,newNode);
    }

    //to insert a node to bst, we first determine if the node is greater or less than the root
    private void insert(Node currentNode, Node node){
        if (node == null){
            System.out.println("Cannot insert null!");
            return;
        }

        if (currentNode == null){
            System.out.println("The current node is null");
            return;
        }

        if (node.equals(currentNode)){
            System.out.println("This node " + node.getKey() + " is already in the tree!");
            return;
        }
        //the inserting node is less than current node
        else if (node.compareTo(currentNode) == -1){
            if (currentNode.getLeftNode() != null)
                insert(currentNode.getLeftNode(),node);
            else {
                currentNode.setLeftNode(node);
                node.setParentNode(currentNode);
            }
        }
        //the inserting node is greater than current node
        else if (node.compareTo(currentNode) == 1){
            if (currentNode.getRightNode() != null)
                insert(currentNode.getRightNode(),node);
            else {
                currentNode.setRightNode(node);
                node.setParentNode(currentNode);
            }
        }

    }


    public Node delete(Node currentNode, Node node){
        //When deleting a node, there are 3 possible scenarios
        //1. The node is the leaf -> simply remove it from the tree
        //2. The node has 1 child node -> move the child node to the position of the deleting node
        //3. The node has 2 child nodes -> this is the most complicated scenario
        //      We will need to find the min node in the right subtree
        //      Replace the deleting node with the min node
        //      Now the tree has duplicate min nodes -> delete the min node for the right sub tree

        if (currentNode == null){
            System.out.println("Current node is null, cannot proceed further!");
            return null;
        }

        if (node == null){
            System.out.println("The deleting node is null, cannot proceed further");
            return null;
        }

        //search for the deleting node
        Node deletingNode = search(currentNode, node);

        if (deletingNode == null) {
            System.out.println("The deleting node " + node.getKey() + " does not exist in the tree.");
        }

        //scenario 1: the deleting node is the leaf
        if (deletingNode.getLeftNode() == null && deletingNode.getRightNode() == null){
            if (deletingNode.getParentNode().getLeftNode().equals(deletingNode))
               deletingNode.getParentNode().setLeftNode(null);
            else if (deletingNode.getParentNode().getRightNode().equals(deletingNode))
                deletingNode.getParentNode().setRightNode(null);
        }
        //scenario 3: the deleting node has two child nodes.
        else if (deletingNode.getLeftNode() !=null && deletingNode.getRightNode() != null){
            Node minNode = findMinNode(deletingNode.getRightNode());

            if (minNode == null){
                System.out.println("Cannot find min node-> Cannot proceed further.");
                return null;
            }

            Node parentNode = deletingNode.getParentNode();
            Node leftNode = deletingNode.getLeftNode();
            Node rightNode = deletingNode.getRightNode();
            //set the correct hierarchy for the new node
            if (parentNode !=null && parentNode.getLeftNode().equals(deletingNode))
                parentNode.setLeftNode(minNode);
            else if (parentNode != null && parentNode.getRightNode().equals(deletingNode))
                parentNode.setRightNode(minNode);

            if (leftNode !=null) leftNode.setParentNode(minNode);
            if (rightNode != null) rightNode.setParentNode(minNode);

            minNode.setLeftNode(leftNode);
            minNode.setRightNode(rightNode);

            deletingNode = null;

            //delete the duplicate on the right subtree since now we have 2 min nodes
            delete(rightNode, minNode);
            
        }
        //scenario 2: the deleting node has 1 child node
        else{

            if (deletingNode.getLeftNode() != null) {
                Node leftNode = deletingNode.getLeftNode();
                leftNode.setParentNode(deletingNode.getParentNode());
            }

            else{
                Node rightNode = deletingNode.getRightNode();
                rightNode.setParentNode(deletingNode.getParentNode());
            }

            if (deletingNode.getParentNode().getLeftNode().equals(deletingNode)) {
                if (deletingNode.getLeftNode()!=null)
                    deletingNode.getParentNode().setLeftNode(deletingNode.getLeftNode());
                else
                    deletingNode.getParentNode().setLeftNode(deletingNode.getRightNode());
            }
            else if (deletingNode.getParentNode().getRightNode().equals(deletingNode)) {
                if (deletingNode.getLeftNode()!=null)
                    deletingNode.getParentNode().setRightNode(deletingNode.getLeftNode());
                else
                    deletingNode.getParentNode().setRightNode(deletingNode.getRightNode());
            }

        }


        return deletingNode;
    }

    //this is a helper method to help find the min node in a tree
    public Node findMinNode(Node node) {

        if (node == null){
            System.out.println("\nWe have reach the end of the tree.");
        }

        if (node.getLeftNode() == null){
            return node;
        }
        else
            return findMinNode(node.getLeftNode());

    }


    private void inOrderTraversal(Node currentNode){
        if(currentNode!=null){
            inOrderTraversal(currentNode.getLeftNode());
            System.out.print(currentNode.getKey() + "-->");
            inOrderTraversal(currentNode.getRightNode());
        }
    }

    private void preOrderTraversal(Node currentNode){
        if (currentNode!=null){
            System.out.print(currentNode.getKey() + "-->");
            preOrderTraversal(currentNode.getLeftNode());
            preOrderTraversal(currentNode.getRightNode());
        }
    }

    private void postOrderTraversal(Node currentNode){
        if (currentNode!=null){
            postOrderTraversal(currentNode.getLeftNode());
            postOrderTraversal(currentNode.getRightNode());
            System.out.print(currentNode.getKey() + "-->");
        }
    }

    //we use in-order traversal to print the tree
    public void printTreeInOrder(){
        if (root == null){
            System.out.println("Root is null -> tree does not exist");
        }

        inOrderTraversal(root);

    }

    public void printTreePreOrder(){
        if (root == null){
            System.out.println("Root is null -> tree does not exist");
        }

        preOrderTraversal(root);

    }

    public void printTreePostOrder(){
        if (root == null){
            System.out.println("Root is null -> tree does not exist");
        }

        postOrderTraversal(root);

    }
}
