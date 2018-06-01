/*
 * Created by longtran on 09/26/17.
 * Given a string, find the length of the longest substring without repeating characters.

    Examples:

    Given "abcabcbb", the answer is "abc", which the length is 3.

    Given "bbbbb", the answer is "b", with the length of 1.

    Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */


import java.util.*;

public class LongestSubstringWithoutRepeatingChar {

    public static void main(String[] args){

        //read the string from user and put the chars to an array
        System.out.print("Enter a string: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] charArray = input.toCharArray();

        // use a hash map to store pairs of (index, length) so that later on we know which index produces the longest substring
        //this solution produces O(n^2) which is slow
        HashMap indexLengthMap = new HashMap<Integer,Integer>();

        for (int i = 0; i < charArray.length; i++){
            ArrayList<Character> charArrayList  = new ArrayList<Character>();
            charArrayList.add(new Character(charArray[i]));
            //for each char in the array, check if the next char is a repeating one, if not then add it to an array list
            int j = i;
            while (j+1 < charArray.length && !charArrayList.contains(new Character(charArray[j+1]))){
                charArrayList.add(charArray[j+1]);
                j++;
            }
            //in the end of the while loop, we should have the longest substring that each char produces
            //we then add the (index, length) to the hash map.
            indexLengthMap.put(new Integer(i), new Integer(charArrayList.size()));
        }

        //check to see which index has the greatest substring without repeating char
        Object maxIndex = Collections.max(indexLengthMap.entrySet(), Map.Entry.comparingByValue()).getKey();

        //for debugging
        System.out.println("Max index is: " + maxIndex);
        int index = (Integer) maxIndex;
        int length = (Integer) indexLengthMap.get(maxIndex);

        System.out.println("The longest substring is: " + input.substring(index, index + length));
    }


    //TODO consider the sliding window solution.

}
