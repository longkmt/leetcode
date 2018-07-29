//Validate if a given string is numeric.
//        Some examples:
//        "0"  true
//        "0.1"  true
//        "abc"  false
//note that "2e10" is also a valid number since it is 2^10

public class ValidateNumber {

    public static void main(String[] args){
        String input = "12323e12";

        System.out.println("Is input " + input + " a valid digit: " + isValidNumber(input));
    }

    //The approach is pretty straight forward: we remove the leading and trailing space first
    //The we check each character if it is a digit
    //When we see special chars like . and e we mark it, if they occur multiple times then we return false
    //Time complexity: O(n) for the loop
    //Space complexity: O(1) since no extra space is used
    public static boolean isValidNumber(String input){

        if (input == null || input.isEmpty()){
            System.out.println("The input is null or empty");
            return false;
        }

        boolean isSpecialChar = false;

        input = input.trim();

        for (int i=0; i< input.length(); i++){
            if(input.charAt(i) == '.' || input.charAt(i) == 'e' || input.charAt(i) == 'E'){
                if (isSpecialChar) {
                    System.out.println("The special char occurs twice.");
                    return false; //the special char occurs twice.
                }
                else
                    isSpecialChar = true;
            }
            else if(!Character.isDigit(input.charAt(i))) {
                System.out.println("Character at index " + i + ", " + input.charAt(i) + " is not a valid digit.");
                return false;
            }
        }

        return true;
    }
}
