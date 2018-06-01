import java.io.IOException;
import java.util.Scanner;

public class ReverseInteger {

    public static void main(String[] args){
        System.out.print("Enter a 32-bit integer: ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        System.out.println("The reverse of the integer is: " + reverseInt(input));
    }

    public static int reverseInt(int in){
        int ans = 0;

        int sign = (in < 0 )?-1:1;

        if (in < 0 ) in = in * -1;

        while (in > 0 ){
            //check for overflow
            if (ans > Integer.MAX_VALUE / 10 || (ans * 10 + in%10) > Integer.MAX_VALUE){
                System.out.println("Overflow detected!");
                return 0;
            }
            ans = ans*10 + in%10;
            in = in /10;
        }

        return ans * sign ;
    }
}
