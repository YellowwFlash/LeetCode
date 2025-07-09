import java.util.Stack;

public class Collisions {

    // Approach-1 -> Using stack
    public static int[] aestroidCollisions(int[] aestroids) {

        // Find length
        int n = aestroids.length;

        // Return if there are not aestroids
        if (n == 0)
            return new int[0];

        // Stack to keep track of the previous aestroids
        Stack<Integer> stack = new Stack<>();

        // Traverse the aestroids
        for (int aestroid : aestroids) {

            // if the aestroid is negative, collide it
            if (aestroid < 0) {

                int abs = Math.abs(aestroid);

                // Collide the aestroids until there is a greater one
                while (!stack.isEmpty() && stack.peek() > 0 && abs > stack.peek())
                    stack.pop();

                // If the stack is empty or the asteroid moves leftwards, add it
                if (stack.isEmpty() || stack.peek() < 0)
                    stack.push(aestroid);

                // If both aestroids are equal, destroy both of them
                if (stack.peek() == abs)
                    stack.pop();

            }

            else
                stack.push(aestroid);
        }

        // Result array
        int[] result = new int[stack.size()];

        for (int i = 0; i < stack.size(); i++)
            result[i] = stack.get(i);

        return result;
    }
}
