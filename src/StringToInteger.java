/*
 * Created by longtran on 10/02/17.
 * Implement atoi to convert a string to an integer.
   Requirements:
   1. Check for overflow (this is always a case for integer related problems)
   2. How's about sign?
   3. How about the string contains white spaces and non-digit chars?

 */

import java.util.Scanner;

public class StringToInteger {

    public static void main(String[] args){

        System.out.print("Enter an integer as a string: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        System.out.println("The integer value is: " + myatoi(input));

    }

    public static int myatoi(String input){

        int ans =0;
        int sign =1;

        input = input.trim();

        if (input.length() == 0 ){
            System.out.println("Input is empty!");
            return ans;
        }

        if (input.charAt(0) == '-' || input.charAt(0) == '+'){

            if (input.length() == 1){ // '+/-' is the only char
                System.out.println("Cannot perform conversion because there is not enough digit. ");
                return ans;
            }
            switch (input.charAt(0)){
                case '+':
                    sign = 1;
                    break;
                case '-':
                    sign = -1;
                    break;
                default:
                    System.out.println("For debugging, the sign is neither + nor -");
                    sign =1;
                    break;
            }

            //let's remove the sign for simplification
            input = input.substring(1);

        }

        //process the input so that we only get the numeric part

        for (int i=0; i< input.length(); i++){
            if (!Character.isDigit(input.charAt(i))){
                input = input.substring(0,i);
            }
        }

        for (int i = 0; i< input.length(); i++){

            //check for overflow
            long check = ans;
            check = check + (input.charAt(i) - '0')* (int)Math.pow(10,input.length() - i -1);
            if (check*sign > Integer.MAX_VALUE) {
                System.out.println("Overflow detected!");
                return Integer.MAX_VALUE;
            }

            if (check*sign < Integer.MIN_VALUE){
                System.out.println("Overflow detected!");
                return Integer.MIN_VALUE;
            }
            ans = ans + (input.charAt(i) - '0')* (int)Math.pow(10,input.length() - i -1);
        }

        return ans*sign;
    }
}
