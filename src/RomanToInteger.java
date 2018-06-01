/*Given a roman numeral, convert it to an integer.
  Input is guaranteed to be within the range from 1 to 3999.

  I - 1
  V - 5
  X - 10
  L - 50
  C - 100
  D - 500
  M - 1000
 * If I comes before V or X, subtract 1 eg: IV = 4 and IX = 9
 * If X comes before L or C, subtract 10 eg: XL = 40 and XC = 90
 * If C comes before D or M, subtract 100 eg: CD = 400 and CM = 900
 * Note that we should ask to verify the rule before implementing it
 * */


import java.util.Arrays;
import java.util.Scanner;
public class RomanToInteger {

    public static void main(String[] args){
        System.out.print("Enter a Roman number: ");
        Scanner scanner = new Scanner(System.in);
        String roman = scanner.nextLine();

        System.out.println("Result: " + romanToInt(roman));
    }

    public static int romanToInt(String roman){

        int result = 0;
        char pre_char =  ' ';

        for (char c: roman.toCharArray()){
            switch (Character.toUpperCase(c)){
                case 'M':
                    if (pre_char =='C')
                        result += (-100+1000-100);
                    else
                        result += 1000;
                    break;
                case 'D':
                    if (pre_char =='C')
                        result += (-100+500-100);
                    else
                        result +=500;
                    break;
                case 'C':
                    if (pre_char =='X')
                        result += (-10+100-10);
                    else
                        result +=100;
                    break;
                case 'L':
                    if (pre_char =='X')
                        result += (-10+50-10);
                    else
                        result +=50;
                    break;
                case 'X':
                    if (pre_char =='I')
                        result += (-1+10-1);
                    else
                        result +=10;
                    break;
                case 'V':
                    if (pre_char =='I')
                        result += (-1+5-1);
                    else
                        result +=5;
                    break;
                case 'I':
                    result +=1;
                    break;
                default:
                    System.out.println("Invalid character: " + c);
                    break;
            }

            pre_char = c;
        }

        return result;

    }

    //TODO: thinking of looping backward -> use hash map like ('I', 1), ('V', 5)
    //not saying it would improve the efficiency, but the codes may look nicer
}
