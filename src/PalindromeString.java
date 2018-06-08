public class PalindromeString {

    public static void main(String[] args){
        String sample = "";

        System.out.println(sample + " is " + (isPalindrome(sample)?"palindrome":"not palindrome") );
    }

    //Approach: we use 2 pointers i and j, one at the beginning and one at the end of the string
    //As we check str[i]=?str[j], if they are not equal then we conclude the str is not palindrome
    //if they are equal then we move i toward j.
    //Time complexity: O(n) with n is the length of the string
    //Space complexity: O(1) since no extra memory is used.

    public static boolean isPalindrome(String text){

        if(text==null){
            System.out.println("Text is null");
            return false;
        }
        else{
            text = text.replaceAll("\\s","").toLowerCase();
        }

        boolean result = true;
        int i=0;
        int j=text.length()-1;

        while(i<j){
            if (text.charAt(i) == text.charAt(j)) {
                i++;
                j--;
                continue;
            }
            else
                return false;
        }

        return result;
    }
}
