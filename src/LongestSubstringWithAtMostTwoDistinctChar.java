public class LongestSubstringWithAtMostTwoDistinctChar {

    public static void main(String[] args){

        String text = "abaac";

        System.out.println("Text: " + text);

        System.out.println("Longest substring with at most two distinct chacracters is: " + longestSubstringWithAtMostTwoRepeatingChar(text));
    }

    //Approach:
    //1. Loop through the text with 2 pointers i,j with j=i+1. Check if A[i] = A[j]. If true then j++ (the chars are identical)
    //If this is not true then we have distinct char, count it. Continue count <2
    //2. If count = 2 (at most 2 distinct chars), we then check if the length of the substring is max or not
    //3. Continue this process until we reach the end
    //Time complexity: O(n) with n is the number of chars in the text
    //Space complexity: O(1) no extra space is used.


    public static String longestSubstringWithAtMostTwoRepeatingChar(String text){
        if (text == null || text.isEmpty()){
            System.out.println("The text is null or empty");
            return new String();
        }

        String result = new String();
        int count=0;
        int maxLen =0;

        for (int i=0,j=i+1; i< text.length() -1 && j< text.length(); j++){
            if (text.charAt(i) == text.charAt(j) || text.charAt(j) == text.charAt(j-1)){
                continue; //j++
            }
            else{
                count++;
            }

            if (count == 2){
                if (text.substring(i,j).length() > maxLen) {
                    result = text.substring(i, j);
                    maxLen = result.length();
                }
                //reset
                count =0;
                i++;
                j=i;
            }
        }

        return result;

    }
}
