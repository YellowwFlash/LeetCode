import java.util.Stack;

public class OnlineStockSpan {

    // Define a stack to keep track of stock prices and their spans
    private Stack<int[]> stack;

    // Constructor initializes the stack
    public OnlineStockSpan() {
        stack = new Stack<>();
    }

    // Method to calculate the stock span for a given price
    public int next(int price) {
        int span = 1; // Start with a span of 1 for the current price

        // While there are prices in the stack and the current price is greater than or
        // equal to the price at the top of the stack
        while (!stack.isEmpty() && stack.peek()[0] <= price) 
            span += stack.pop()[1]; // Add the span of the popped price to the current span
        

        // Push the current price and its calculated span onto the stack
        stack.push(new int[] { price, span });

        return span; // Return the calculated span
    }
}
