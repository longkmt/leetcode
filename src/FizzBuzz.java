import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {


    public static void main(String[] args){

        System.out.println(fizzBuzz(100));

    }


    //This question is very simple but need to be extremely careful because chances are your code is bloating with repeating if statements
    public static String fizzBuzz(int num){

        StringBuilder strBuilder = new StringBuilder();
        if (num <= 0){
            System.out.println("Input has to be greater than 0");
            return strBuilder.toString();
        }



        for (int i=1; i<= num; i++){
            strBuilder.append(i + ". ");
            if (i%3 ==0)
                strBuilder.append("Fizz");
            if (i%5 ==0)
                strBuilder.append("Buzz");

            strBuilder.append("\n");

        }

        return strBuilder.toString();

    }

}
