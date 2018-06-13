import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    private SinglyLinkedList singlyList;

    @BeforeEach
    void setup(){
        singlyList = new SinglyLinkedList(1);
        singlyList.addNode(2);
        singlyList.addNode(3);
        singlyList.addNode(4);
        singlyList.addNode(5);
    }

    @Test
    void testGetTail() {
        assertEquals(5,singlyList.getTail(singlyList.getHead()).getValue());
    }

    @Test
    void testGetHead(){
        assertEquals(1,singlyList.getHead().getValue());
    }

    @Test
    void testAddNode() {
        singlyList.addNode(6);
        assertEquals(6,singlyList.getTail(singlyList.getHead()).getValue());
    }

    @Test
    void testReverse() {
        singlyList.reverse();
        //head should be 5 now if the reversion works correctly
        assertEquals(5,singlyList.getHead().getValue());
    }

    @Test
    void testToString() {
    }

    @Test
    void isSorted() {
    }

    @Test
    void mergeTwoSortedList() {
    }

}