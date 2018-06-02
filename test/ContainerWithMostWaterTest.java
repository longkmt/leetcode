import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerWithMostWaterTest {

    private int[] heights1 = new int[] {}; //empty array
    private int[] heights2 = new int[] {1}; //array with only 1 value
    private int[] heights3 = new int[] {3,5,1,4,2,8,1,0,3,0,1}; //array with varied values
    private int[] heights4 = new int[] {3,3,3,3,3,3,3,3,3,3,3}; //array with identical values
    private int[] heights5 = new int[] {3,5,1,4,2,-8,-1,0,3,0,1}; //array with negative number, this is just for fun
    private int[] heights6 = new int[] {3,5}; //array with only 2 values
    private int[] heights7 = new int[] {3,0,5}; //array with 3 values
    private int[][] heights = new int[][] {heights1, heights2, heights3, heights4, heights5, heights6, heights7};

    @Test
    void testMaxAreaMethodsReturnSameResult() {

        for (int[] h : heights){
            assertEquals(ContainerWithMostWater.maxArea(h), ContainerWithMostWater.maxArea2(h),"Test if the unoptimized maxArea method" +
                    " returns the same result with the optimized one!");
        }

    }

}