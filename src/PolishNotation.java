//Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//Valid operators are +, -, *, /. Each operand may be an integer or another expression.
//For example, the infix expression “8 – ((1 + 2) * 2)” in RPN is:
//8 1 2 + 2 * –

import java.util.*;

public class PolishNotation {

    interface Operator{
        int eval(int x, int y);
    }

    //Be careful and make sure that you understand the below code (it creates a new class that inherits from HashMap).
    //Therefore, you should read more here: http://www.c2.com/cgi/wiki?DoubleBraceInitialization
    private static final Map<Character,Operator> operatorMap = new HashMap<Character,Operator>(){{

        put('+', new Operator(){
            @Override
            public int eval(int x, int y){
                return x+y;
            }
        });

        put('-', new Operator(){
            @Override
            public int eval(int x, int y){
                return y-x;
            }
        });

        put('*', new Operator(){
            @Override
            public int eval(int x, int y){
                return x*y;
            }
        });

        put('/', new Operator(){
            @Override
            public int eval(int x, int y){
                return y/x;
            }
        });


    }};

    public static void main(String[] args){

        String expression = "8 1 2 + 2 * -";
        expression.replaceAll("\\s","");
        System.out.println("Expression: " + expression + ", result: " + calculatePN(expression));
    }

    //Time complexity: O(n) for the loop
    //Space complexity: O(n) for the stack
    public static int calculatePN(String expression){
        if (expression == null || expression.isEmpty()){
            System.out.println("The expression is empty!");
            return 0;
        }

        expression = expression.replaceAll("\\s","").trim();


        Stack<Integer> stack = new Stack<Integer>();
        int result =0;

        for (Character c: expression.toCharArray()){
            if (operatorMap.containsKey(c)){
                //here we assume that the expression is always valid otherwise this would not work
                int x = stack.pop(); //first
                int y = stack.pop(); //second

                stack.push(operatorMap.get(c).eval(x,y));
            }
            else
                stack.push(Integer.parseInt(c+""));
        }

        //the last element in the stack is the final result
        return stack.pop();
    }

    public static int evaluation(int x, int y, char op){
        switch (op){
            case '+':
                return x+y;
            case '-':
                return y-x;
            case '*':
                return x*y;
            case '/':
                return y/x;
            default:
                System.out.println("Invalid operator!");
                return 0;
        }
    }

}
