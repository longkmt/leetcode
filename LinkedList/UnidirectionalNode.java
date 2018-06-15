import com.sun.deploy.util.StringUtils;

public class UnidirectionalNode implements Comparable {

    private UnidirectionalNode nextNode;

    private int value;

    UnidirectionalNode(int _value){
        this.value = _value;
    }

    public UnidirectionalNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(UnidirectionalNode nextNode) {
        this.nextNode = nextNode;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString(){
        if (this.getNextNode()== null)
            return String.valueOf(value);
        else
            return String.valueOf(value) + "-->";
    }

    @Override
    public int compareTo(Object o) {
        UnidirectionalNode node = (UnidirectionalNode) o;
        return Integer.compare(this.value,node.getValue());
    }
}
