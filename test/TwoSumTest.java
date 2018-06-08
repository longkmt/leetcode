import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    int target = 5;

    int[] sample1 = {1, 2, 3, 4, 5, 6};
    int[] sample2 = {};
    int[] sample3 = null;
    int[] sample4 = {1};
    int[] sample5 = {1, 4, 6, 5, 0, -2, 7, 10};

    private int[][] A = {sample1, sample2, sample3, sample4, sample5};

    @Test
    void testBruteForceAndImprovedMethodsReturnSameResult(){
        for (int[] array: A){
            assertTrue(TwoSum.twoSum(array,target).size() == TwoSum.twoSumImproved(array,target).size()
                                && TwoSum.twoSum(array,target).containsAll(TwoSum.twoSum(array,target)),"Check to see if both methods return same result.");
        }
    }

}