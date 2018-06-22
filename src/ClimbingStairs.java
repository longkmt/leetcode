import java.util.ArrayList;
import java.util.List;

public class ClimbingStairs {

    //This is a classic problem that can be solved either by recursion or DP: given the fact that we can take 1 step or 2 steps to climb up a stairs of n steps.
    //How many ways do we have to climb up the stairs?

    public static void main(String[] args){

        int n=50;
        //System.out.println("To climb up stairs with " + n + " steps, there will be " + climbingStairsRecursive(n) + " ways.");
        System.out.println("To climb up stairs with " + n + " steps, there will be " + climbingStairsDP(n,null) + " ways.");

        int m=10;
        List<Integer> L = new ArrayList<Integer>();
        L.add(2);
        L.add(3);
        L.add(6);
        L.add(7);
        L.add(8);
        System.out.println("To score " + m + " points, there will be " + genericClimbingStairsDP(m,null,L) + " ways.");

    }

    //The first initial approach is to use recursion.
    //Let's call f(n) is the number of ways to reach n stairs.
    //We can see that: f(n) = f(n-1) + f(n-2) since it would take 1 step to reach step nth when we are at step (n-1)th
    //Likewise, it would take only 2 steps to reach step nth when we are at step (n-2)th.
    //At the base case: n=1 -> it would take only 1 step -> f(1) = 1
    //When n=2 -> it would take 1 step followed by 1 step (1-1), or take 2 steps
    //When n=3 -> 1-1-1 or 1-2 or 2-1 -> we can see that f(3) = f(1) + f(2)
    //Running time: O(2^n) -> this is a huge performance hit (try with n=20)
    //Space: O(1) as no extra space is used.

    public static long climbingStairsRecursive(int n){

        long result =0;

        if(n<1){
            System.out.println("Invalid argument since n=" +n);
            return result;
        }

        if (n==1){
            return 1;
        }
        else if (n==2){
            return 2;
        }

        result = climbingStairsRecursive(n-1) + climbingStairsRecursive(n-2);

        return result;
    }

    //The above approach works perfectly, but it is not optimal since we have to repeat the calculation
    //of f(k) where k=1,2,3.. <n. A better way to do this is to use memoization which is a technique to cache
    //the results of f(k) in memory and return the cached results when the same inputs occur again.
    //In this case we will use
    public static long climbingStairsDP(int n, long[] A){

        long result =0;

        if(n<1){
            System.out.println("Invalid argument since n=" +n);
            return result;
        }

        if (A == null){
            //initialize the array to store the calculated values, we ignore the index 0 make it easier to visualize.
            A = new long[n+1];
        }

        if (A[n] !=0){
            //we already store the result of this input before, just return it.
            return A[n];
        }

        //initialize base cases
        A[1] = 1; //n=1 -> 1 way to climb
        A[2] = 2; //n=2 -> 2 ways to climb

        result = climbingStairsDP(n-1,A) + climbingStairsDP(n-2,A);
        A[n] = result; //store the value

        return result;

    }

    //Because this type of problem is so popular, we can come up with a generic method to solve this type of problem.
    //Generic problem: give an integer n as a goal to achieve and a series of i,j,k... as distances from n-i, n-j, n-k... to n respectively
    //Find number of ways to get to n.

    public static long genericClimbingStairsDP(int n,long[] A, List<Integer> L){

        long result =0;

        if(n<1){
            System.out.println("Invalid argument since n=" +n);
            return result;
        }

        //User can initialize the base cases to fit their purpose if they want to
        //However it is not a requirement. We initialize A if users do not provide it.
        if (A == null){
            A = new long[n+1];
        }

        if (A[n] >0){
            //we already store the result of this input before, just return it.
            return A[n];
        }


        for(Integer i:L){
            if (n-i < 0) {
                //result =0 -> it is not possible -> continue with a different i; however if L is sorted then we can break the loop here.
                break;
            }

            if (n-i == 0){
                result+=1; //there is only 1 way to reach n from (n-i), at this point we do not need to advance i further.
                break;
            }

            result+=genericClimbingStairsDP(n-i,A,L);
        }
        //store the results
        A[n] = result;

        return result;
    }


}
