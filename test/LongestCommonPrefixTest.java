import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestCommonPrefixTest {

    String[] array1 = new String[] {"leet", "le", "leetcode", "leetchar"};
    String[] array2 = new String[] {};
    String[] array3 = new String[] {"leet"};
    String[] array4 = new String[] {"aa", "a"};
    String[] array5 = new String[] {"leet", "le", "aa", "a"};

    String[][] testArrays = new String[][] {array1,array2,array3,array4,array5};


    @Test
    void testCommonPrefixHorizontalScanning() {
        String[] array  = new String[] {"leet", "le", "leetcode", "leetchar"};
        assertEquals(LongestCommonPrefix.commonPrefixHorizontalScanning(array),"le");
    }

    @Test
    void testCommonPrefixVerticalScanning() {
        String[] array  = new String[] {"leet", "le", "leetcode", "leetchar"};
        assertEquals(LongestCommonPrefix.commonPrefixVerticalScanning(array),"le");
    }

    @Test
    void testCommonPrefixDivideAndConquer() {
        String[] array  = new String[] {"leet", "le", "leetcode", "leetchar"};
        assertEquals(LongestCommonPrefix.commonPrefixDivideAndConquer(array),"le");
    }

    @Test
    void testLongestCommonPrefixInEachPart() {
    }

    @Test
    void testBestCommonPrefix() {
    }

    @Test
    void testHorizontalAndVerticalReturnSameResult(){
        for (String[] array : testArrays){
            assertEquals(LongestCommonPrefix.commonPrefixHorizontalScanning(array),LongestCommonPrefix.commonPrefixVerticalScanning(array));
        }
    }

    void testHorizontalAndDivideConquerReturnSameResult(){
        for (String[] array : testArrays){
            assertEquals(LongestCommonPrefix.commonPrefixHorizontalScanning(array),LongestCommonPrefix.commonPrefixDivideAndConquer(array));
        }
    }
}