/*
* Implement regular expression matching with support for '.' and '*'.
*   '.' Matches any single character.
    '*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
* */

import java.util.Scanner;

public class RegularExpressionMatching {

        public static void main(String[] args){
            System.out.print("Enter an input as a string: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            System.out.print("Enter a regrex as a string: ");
            String regrex = scanner.nextLine();

            System.out.print("The result is: " + isMatch(input,regrex));
        }

        //This method is based on DP with bottom-up approach
        //Run time analysis: O(n*m) with n is the length of the input string, and m is the length of the regrex
        public static boolean isMatch(String input,String regrex){
            boolean result = false;

            boolean T[][] = new boolean[input.length() + 1] [regrex.length() +1];

            //base case: case either the regrex or the text (or both) is empty, then it is a match
            T[0][0] = true;

            //take care of the scenario when the regrex is like a*, a*b*, a*b*c*
            //in this scenario, it does not matter what the text is, it is always a match
            for (int i=1; i< regrex.length() + 1; i++){
                if (regrex.charAt(i-1) == '*'){
                    T[0][i] = T[0][i-2];
                }
            }

            for (int i = 1; i< T.length; i++){
                for (int j = 1; j< T[0].length; j++){
                    //case 1: if the letters match at text[i] and regrex[j] or regrex[j] == '.'
                    //then we can "remove" the letter and check at [i-1][j-1]
                    if (input.charAt(i-1) == regrex.charAt(j-1) || regrex.charAt(j-1) == '.'){
                        T[i][j] = T[i-1][j-1];
                    }
                    //case 2: if we hit a '*', ie [ab][ab*]
                    //we have 2 sub cases:
                    //first we check for 0 occurrence of the letter preceding the '*'
                    //then we check for 1 or more occurrence of the letter preceding the '*'
                    else if (regrex.charAt(j-1) == '*'){
                        //if we remove the letter and the * and it still match -> 0 occurrence
                        if (T[i][j-2]) {
                            T[i][j] = T[i][j - 2];
                        }
                        else if (regrex.charAt(j-2) == input.charAt(i-1) || regrex.charAt(j-2) == '.'){//check for 1 or more occurrence
                            T[i][j] = T[i-1][j];
                        }
                    }

                    else {
                        //if the letters at i, j do not match then it is false
                        T[i][j] = false;
                    }
                }
            }

            result = T[input.length()][regrex.length()];

            return result;
        }
}

//TODO: consider the recursive method