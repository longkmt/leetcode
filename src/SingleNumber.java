//Given an array of integers, every element appears twice except for one. Find that single one.

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SingleNumber {

    //Questions to ask:
    //1. Can we have negative numbers?
    //2. Can a number appear more than 2? -> this is to use with XOR since we know every number XOR with itself will be 0

    //Naive brute-force approach: use a hash map to keep track of the count of each number
    //Time complexity: O(n) for the loop
    //Space complexity: O(n) for the map
    public static int singleNumberHashMap(int[] A){

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        for (int i: A){
            if (map.containsKey(i)){
                map.put(i,map.get(i) +1);
            }
            else
                map.put(i,1);
        }

        for (int i: A){
            if (map.get(i) == 1)
                return i;
        }

        return 0;

    }

    //Another better approach: since we know that set does not allow duplicate, we use it to keep track of the elements
    //We check if the element is in the set, then we remove it
    //The last element in the set will not have duplicate
    //Time complexity: O(n) for the loop
    //Space complexity: O(n) for the set

    public static int singleNumberUsingSet(int[] A){

        Set<Integer> set = new HashSet<Integer>();

        for (int i: A){
            if (set.contains(i)){ //set does not allow duplicate
                set.remove(i);
            }
            else
                set.add(i);

        }

        return set.iterator().next(); //the only element left in the set is the one without duplicate
    }

    //Even better approach:
    //Since we know that if we xor a number with itself we will get 0
    //If we XOR all number together, all the duplicate will cancel out leaving only the non-duplicate number left.
    //Ie: 0 ^ 2 = 2, 2^2 = 0, 1^2^3^2^1 =3
    //Time complexity: O(n)
    //Space complexity: O(1)

    public static int singleNumberXOR(int[] A){
        int result = 0;

        for (int i: A){
            result ^= i;
        }

        return result;
    }

}
