public class ReverseWordsInString {

    public static void main(String[] args){

        String text = "     the sky   is blue    ";
        System.out.println("Text: " + text + ", and the 2-pass reverse is: " + reverseWordTwoPass(text));
        System.out.println("Text: " + text + ", and the 1-pass reverse is: " + reverseWordOnePass(text));
    }

    //In the first approach, we are going to split the text into list of words separated by whitespace, then reverse the list
    //Time complexity: O(n)
    //Space complexity: O(n) for the extra array
    public static String reverseWordTwoPass(String text){
        StringBuilder result = new StringBuilder();
        if (text == null || text.isEmpty()){
            System.out.println("Text is null or empty!");
            return result.toString();
        }

        String[] wordList = text.trim().replaceAll("\\s+"," ").split(" ");

        for (int i=wordList.length-1; i>=0; i--){
            result.append(wordList[i]).append(" ");
        }

        return result.toString();

    }

    //The second approach we use 2 pointers i and j start at the end of the text
    //We move i backward, whenever we hit a whitespace, we do substring of text between i and j
    //then we move j up to i and continue. This approach only works when there is only 1 whitespace between each word.
    //Time complexity: O(n) for one loop
    //Space complexity: O(n) for the extra space
    public static String reverseWordOnePass(String text){
        StringBuilder result = new StringBuilder();
        if (text == null || text.isEmpty()){
            System.out.println("Text is null or empty!");
            return result.toString();
        }

        //StringBuilder tempBuilder = new StringBuilder();
        text = text.trim().replaceAll("\\s+"," ");

        for (int i=text.length()-1, j=i; i>=0; i--){
            if (text.charAt(i) == ' '){
                result.append(text.substring(i+1,j+1)).append(" ");
                j=i-1;
            }
            else if (i==0){
                result.append(text.substring(i,j+1)).append(" ");
            }

        }

        return result.toString();
    }


}
