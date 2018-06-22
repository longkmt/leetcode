import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClimbingStairsTest {

    private static int n,m;
    private static List<Integer> L;
    private static final long EXPECTED_RESULT_1 = 20365011074L;
    private static final long EXPECTED_RESULT_2 = 14;

    @BeforeAll
    static void setup(){
        n = 50;
        m = 10;
        L = new ArrayList<Integer>();
        L.add(2);
        L.add(3);
        L.add(6);
        L.add(7);
        L.add(8);
    }

    @Test
    void testClimbingStairsRecursive() {
        assertEquals(ClimbingStairs.climbingStairsRecursive(n),EXPECTED_RESULT_1);
    }

    @Test
    void testClimbingStairsDP() {
        assertEquals(ClimbingStairs.climbingStairsDP(n,null),EXPECTED_RESULT_1);
    }

    @Test
    void testGenericClimbingStairsDP() {
        assertEquals(ClimbingStairs.genericClimbingStairsDP(m,null,L),EXPECTED_RESULT_2);
    }
}