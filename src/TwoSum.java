import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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

        int B[] = {1, 2, 3, 4, 5, 6};
        int C[] = {1, 4, 6, 5, 0, -2, 7, 10};

        List<Pair<Integer,Integer>> result = twoSumImproved(C,target);

        System.out.println("The answer is: ");
        result.forEach(p->System.out.println(p.toString()));
    }
    //Brute force approach: loop through each pair of integers in the array
    //check if the sum of those pairs equals to the target
    //return the indices of those integers in pair
    //Time complexity: O(n^2) since we have to use two loop.
    public static List<Pair<Integer,Integer>> twoSum(int[] A, int target){
        List<Pair<Integer,Integer>> pairs = new ArrayList<Pair<Integer,Integer>>();
        if(A==null){
            System.out.println("Array is null!");
            return pairs;
        }
        for (int i = 0; i < A.length -1; i++)
            for (int j = i + 1; j < A.length; j++)
                if (A[i] + A[j] == target)
                    pairs.add(new Pair<Integer, Integer>(i, j));


        return pairs;
    }

    //The next approach is to construct a hash map to store pairs (A[i],i) with i is the index of each integer in A
    //As we construct the hash map, we also check if A[j] = target - A[j] exist in the map or not
    //If A[j] does exist then we store (i,j) as one of the answers, if not then we move on.
    //Time complexity: O(n) since we only use 1 single loop
    //Space complexity: O(n) to construct the hash map
    public static List<Pair<Integer,Integer>> twoSumImproved(int[]A, int target){
        List<Pair<Integer,Integer>> pairs = new ArrayList<Pair<Integer,Integer>>();

        if(A==null){
            System.out.println("Array is null!");
            return pairs;
        }

        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

        for (int i=0; i< A.length; i++){
            int delta = target - A[i]; //delta is what A[j] need to be
            if (map.containsKey(delta)){ //found A[j] in the map
                System.out.println("Found i=" +i +',' +"A[i]=" + A[i] + " ; j="+ map.get(delta) + ',' + "A[j]=" + delta);
                pairs.add(new Pair(i,map.get(delta)));
            }
            else{
                map.put(A[i],i);
            }

        }

        return pairs;
    }
}
