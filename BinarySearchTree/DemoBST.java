public class DemoBST {

    public static void main(String[] args){
        Node root = new Node(5);
        BinarySearchTree bst = new BinarySearchTree(root);
        bst.insert(3);
        bst.insert(10);
        bst.insert(1);
        bst.insert(4);
        bst.insert(8);
        bst.insert(11);
        bst.insert(9);


        System.out.println("Print tree pre order");
        bst.printTreePreOrder();
        System.out.println("\nPrint tree in order");
        bst.printTreeInOrder();
        System.out.println("\nPrint tree post order");
        bst.printTreePostOrder();

        System.out.println("The min node is " + bst.findMinNode(root).getKey());
        System.out.println("\nDeleting node 8");
        bst.delete(root, new Node(8));
        bst.printTreeInOrder();
    }
}
