import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindIndexOfStringTest {

    private final String str1 ="";
    private final String str2 = null;
    private final String str3 = "aaaba";
    private final String str4 ="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaba";
    private final String target = "ba";

    @Test
    void testIndexOfEmptyStrings() {
        assertEquals(FindIndexOfString.indexOf(str1,target),-1);
    }

    @Test
    void testIndexOfNull(){
        assertEquals(FindIndexOfString.indexOf(str2,target),-1);
    }

    @Test
    void testIndexOfNormalStrings(){
        assertEquals(FindIndexOfString.indexOf(str3,target),3);
    }

    @Test
    void testIndexOfVeryLongString(){
        assertEquals(FindIndexOfString.indexOf(str4,target), 56);
    }
}