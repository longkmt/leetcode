//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input
//string is valid.
//The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and
//"([)]" are not.


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public static final Map<Character,Character> bracketMap = new HashMap<Character,Character>(){
        {
          put('{','}');
          put('(',')');
          put('[',']');
        }
    };

    public static void main(String[] args){

        String expression = "()[}{}";
        System.out.println("Expression: " + expression + ", result: " + validateParentheses(expression));
    }

    //Time complexity: O(n) for the loop
    //Space complexity: O(n) for the stack
    public static boolean validateParentheses(String expression){

        if (expression ==null){
            System.out.println("The expression is null!");
            return false;
        }

        if (expression.isEmpty()){
            System.out.println("The expression is empty!");
            return true;
        }

        Stack<Character> stack = new Stack<Character>();

        for (Character c: expression.toCharArray()){
            if (bracketMap.containsKey(c)){
                stack.push(c);
            }
            else if (!stack.isEmpty() && !bracketMap.get(stack.pop()).equals(c))
                return false;
        }

        return true;

    }

}
