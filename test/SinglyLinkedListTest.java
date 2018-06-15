import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    private SinglyLinkedList singlyList1;
    private SinglyLinkedList singlyList2;

    @BeforeEach
    void setup(){
        singlyList1 = new SinglyLinkedList(1);
        singlyList1.addNode(2);
        singlyList1.addNode(3);
        singlyList1.addNode(4);
        singlyList1.addNode(5);

        singlyList2 = new SinglyLinkedList(10);
        singlyList2.addNode(9);
        singlyList2.addNode(8);
        singlyList2.addNode(7);
        singlyList2.addNode(6);
    }

    @Test
    void testGetTail() {
        assertEquals(5, singlyList1.getTail(singlyList1.getHead()).getValue());
    }

    @Test
    void testGetHead(){
        assertEquals(1, singlyList1.getHead().getValue());
    }

    @Test
    void testAddNode() {
        singlyList1.addNode(6);
        assertEquals(6, singlyList1.getTail(singlyList1.getHead()).getValue());
    }

    @Test
    void testReverse() {
        singlyList1.reverse();
        //head should be 5 now if the reversion works correctly
        assertEquals(5, singlyList1.getHead().getValue());
    }

    @Test
    void testToString() {
    }

    @Test
    void isSortedTrue() {

        assertTrue(singlyList1.isSorted());
    }

    @Test
    void isSortedFalse(){

        assertFalse(singlyList2.isSorted());
    }

    @Test
    void mergeTwoSortedList() {
    }

    @Test
    void mergeTwoSortedList1() {
    }

    @Test
    void mergeKSortedLinkedListBruteForce() {
    }

    @Test
    void mergeKSortedLinkedListUsingHeap() {
    }

    @Test
    void mergeKSortedLinkedListDivideNConquer() {
    }

    @Test
    void mergeKSortedLinkedListDivideNConquer1() {
    }
}