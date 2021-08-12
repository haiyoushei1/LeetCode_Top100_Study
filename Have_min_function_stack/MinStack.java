package Have_min_function_stack;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> masterStack;
    private Stack<Integer> affiliateStack;

    public MinStack() {
        masterStack = new Stack<>();
        affiliateStack = new Stack<>();
    }

    public void push(int x) {
        if(affiliateStack.isEmpty() || affiliateStack.peek() >= x){
            affiliateStack.push(x);
        }
        masterStack.push(x);
    }

    public void pop() {
        if(masterStack.peek().equals(affiliateStack.peek())){
            affiliateStack.pop();
        }
        masterStack.pop();
    }

    public int top() {
        return masterStack.peek();
    }

    public int min() {
        return affiliateStack.peek();
    }
}
