//Rotate an array to the right by k steps in-place without allocating extra space. For
//        instance, with k = 3, the array [0, 1, 2, 3, 4, 5, 6] is rotated to [4, 5, 6, 0, 1, 2, 3].

import java.util.Arrays;

public class RotateAnArray {


    public static void main(String[] args){

        int[] A = new int[]{0,1,2,3,4,5,6,7,8,9,10};
        int[] B = new int[]{1,2,3,4};
        int k = 3;

        System.out.println("Array: " + Arrays.toString(B));
        System.out.println("Rotated array by " + k + ": " + Arrays.toString(rotateArrayByKStepInPlace(B,k)));

    }

    //the algorithm is straight forward: for each count, save the last number in temp
    //shift the array to the right
    //put the number in temp back to A[0]
    //Time complexity: k*n since we loop k time for the outer loop and n time for the inner loop
    //Space complexity: O(1) as no extra space is used

    public static int[] rotateArrayByKStepInPlace(int[] A, int k){
            if (A == null || A.length ==0){
                System.out.println("The array is null or empty");
                return A;
            }

            int n = A.length -1;
            int count =0;

            while (count < k){
                int temp = A[n];

                for (int i= n; i >0; i--){
                    A[i] = A[i-1]; //shift the array to the right one by one
                }

                A[0] = temp; //put the last element to the start of the array
                count++;
            }

            return A;
    }

}
