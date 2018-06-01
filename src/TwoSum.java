import java.util.Arrays;

/**
 * Created by longtran on 2/20/17.
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
public class TwoSum {

    public static void main(String[] args){

        int[] A = new int[10];
        int target = 5;

        A[0] = 1;
        A[1] = 4;
        A[2] = 6;
        A[3] = 3;
        A[4] = 8;
        A[5] = -2;
        A[6] = 7;
        A[7] = 0;
        A[8] = 10;
        A[9] = -7;

        for (int i = 0; i < A.length -1; i++){
            for (int j = i+1; j < A.length; j++){
                if (A[i] + A[j] == target)
                    System.out.println("[" + i + "," + j + "]");
            }
        }
    }

}
