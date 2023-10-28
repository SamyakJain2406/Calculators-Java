import java.util.Stack;

public class StackPush {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1); 
        stack.push(2); 
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);

        System.out.println("Top element: " + stack.peek());

        int poppedElement = stack.pop();
        System.out.println("Popped element: " + poppedElement); // Corrected from "Popped element:+poppedElement"
    }
}
