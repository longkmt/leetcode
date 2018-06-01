public class Node implements Comparable {

    private Node leftNode;

    private Node rightNode;

    private Node parentNode;

    private int key;

    Node(int _key){
        this.key = _key;
    }

    Node(){
        this.key = 0;
    }

    public Node getLeftNode(){
        return leftNode;
    }

    public Node getRightNode(){
        return rightNode;
    }

    public Node getParentNode() {return parentNode;}

    public int getKey(){
        return key;
    }

    public void setLeftNode(Node node){
        leftNode = node;
    }

    public void setRightNode(Node node){
        rightNode = node;
    }

    public void setParentNode(Node node) {parentNode = node;}

    public void setKey(int _key){
        this.key = _key;
    }

    @Override
    public boolean equals(Object o) {
        Node _node = (Node)o;
        return this.getKey() == _node.getKey();
    }

    @Override
    public int compareTo(Object o) {
        Node _node = (Node)o;
        return Integer.compare(this.getKey(),_node.getKey());
    }
}
