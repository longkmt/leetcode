import java.util.Stack;

public class MinStack {

    private Stack<Integer> mainStack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();

    //Whenever we push a number of the main stack, we push a number to the min stack as well
    //that way we can always keep track of the smallest number
    public void push(int x){
        mainStack.push(x);

        if (!minStack.isEmpty() && x > minStack.peek()) {
            minStack.push(minStack.peek());
        }
        else
            minStack.push(x);

    }

    //Same thing, we want to keep the main stack and min stack in sync
    public int pop(){

        minStack.pop();

        return mainStack.pop();
    }

    public int top(){
        return mainStack.peek();
    }

    public int getMin(){
        return minStack.peek();
    }

}
