import java.util.Scanner;

public class PalindromeNumber {

    public static void main(String[] args){
        System.out.print("Enter a 32-bit integer: ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        if (isPalindromeNumber(input))
            System.out.println("It is a palindrome number!");
        else
            System.out.println("It is not a palindrome number!");
    }

    public static boolean isPalindromeNumber(int in){
        //check to see if the reversion of the integer produces the same number
        int rev = ReverseInteger.reverseInt(in);
        return (in == rev);
    }
}
