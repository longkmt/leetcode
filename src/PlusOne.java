import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args){
        int[] A = new int[]{9,9,9,9,9};
        System.out.println("Added 1 to the array. Result: " + Arrays.toString(plusOne(A)));
    }

    public static int[] plusOne(int[] A){

        if (A == null){
            System.out.println("Array is null.");
            return A;
        }
        if (A.length ==0){
            System.out.println("Array is empty.");
            return A;
        }

        int len = A.length;

        if (A[len-1] +1 <10){
            A[len-1] = A[len-1]+1;
            return A;
        }

        int j=1;
        while (A[len-j] +1 >= 10){
            if (len ==j){ //edge case when it overflows
                System.out.println("Overflow detected! Stop processing");
                return A;
            }

            A[len-j] = 0;
            j++;
        }

        A[len-j] = A[len-j]+1;

        return A;
    }

}
