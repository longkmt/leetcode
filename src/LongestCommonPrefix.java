/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string ""

Example:
Input: ["flower","flow","flight"]
Output: "fl"

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

 */


import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args){
        String[] testArray = {"flower","flow", "flight"};
        String[] testArray1 = {"aa","a"};
        System.out.println("Test array is: " + Arrays.toString(testArray));
        System.out.println("The LCP is: " + commonPrefixDivideAndConquer(testArray));
    }

    public static String commonPrefixHorizontalScanning(String[] arrays){
        if (arrays == null || arrays.length == 0){
            System.out.println("Array is either empty or has 1 element!");
            return new String();
        }

        String prefix = arrays[0];
        //the initial approach is to realize that: LCP{S1,S2,S3...,Sn) = LCP(LCP(LCP(S1,S2),S3),...)
        //this is also called horizontal scanning
        //time complexity: O(S) where S is the sum of all characters in all strings
        for (int i =1; i < arrays.length; i++){
            while (arrays[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length() -1); //reduce the prefix until we have a match

                if (prefix.length() == 0) //while reducing the prefix, if it is empty that means there is no common prefix
                    return new String();
            }
        }

        return prefix;
    }

    //the above approach can be improved by scanning each character in each string one by one vertically
    public static String commonPrefixVerticalScanning(String[] arrays){
        if (arrays == null || arrays.length == 0){
            System.out.println("Array is either empty or has 1 element!");
            return new String();
        }

        String prefix = arrays[0];

        //scan each character in each string vertically
        //the condition arrays[j].length() == i is to check the case where the subsequent string is shorter than the
        //1st string.
        //Time complexity: O(S) where S is the total characters in all strings

        for (int i=0; i<arrays[0].length(); i++){
            char c = arrays[0].charAt(i);

            for (int j = 1; j<arrays.length; j++){

                if(arrays[j].length() == i || arrays[j].charAt(i) != c){
                    return arrays[j].substring(0,i);
                }
            }

        }

        return arrays[0];
    }

    //We can have an even better solution with divide and conquer approach
    //Algorithm: LCP(S1,...,Sn) = LCP( LCP(S1,...,Sk), LCP(Sk+1,Sn) )
    //We keep splitting the array into 2 equal parts and find the LCP of each part
    //then we compare the results of 2 part and find return the best LCP

    public static String commonPrefixDivideAndConquer(String[] arrays){

        if (arrays == null || arrays.length == 0){
            return new String();
        }

        String result = longestCommonPrefixInEachPart(arrays,0,arrays.length -1);

        return result;
    }

    public static String longestCommonPrefixInEachPart(String[] arrays, int left, int right){

        if (left == right){
            return arrays[left];
        }

        int mid = (left + right)/2;
        String leftLCP = longestCommonPrefixInEachPart(arrays,left, mid);
        String rightLCP = longestCommonPrefixInEachPart(arrays,mid +1, right);
        String result = bestCommonPrefix(leftLCP, rightLCP);

        return result;
    }

    public static String bestCommonPrefix(String leftLCP, String rightLCP){
        String result = new String();
        int min = Math.min(leftLCP.length(),rightLCP.length());

        for (int i=0; i< min; i++){
            if (leftLCP.charAt(i) != rightLCP.charAt(i)){
                result = leftLCP.substring(0,i);
                return result;
            }
        }

        result = leftLCP.substring(0,min);

        return result;
    }

}
