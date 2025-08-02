import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Traversals {

    // Reference node class for trees
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Traversal-1 -> Preorder Traversal
    public static void preorderTraversal(Node root, List<Integer> list) {

        // Base case : If the root is null, simply return
        if (root == null)
            return;

        // Follow the order : root -> left -> right

        // Add the root to the list
        list.add(root.data);

        // Go to the left subtree
        preorderTraversal(root.left, list);

        // Go to the right subtree
        preorderTraversal(root.right, list);
    }

    // Variation-1 -> Iterative Preorder Traversal
    public static List<Integer> iterativePreorderTraversal(Node root) {

        // If root is null, simply return
        if (root == null)
            return List.of();

        // Define a list to keep track of preorder
        List<Integer> list = new ArrayList<>();

        // Define a stack to keep track of nodes
        Stack<Node> stack = new Stack<>();

        // Add root node in stack
        stack.push(root);

        // Iterate until the stack is empty
        while (!stack.isEmpty()) {

            // Get the current node from the stack
            Node current = stack.pop();

            // Add the current node to the list
            list.add(current.data);

            // Due to LIFO, add right node first in stack
            if (current.right != null)
                stack.push(current.right);

            // Add the left node in the stack
            if (current.left != null)
                stack.push(current.left);
        }

        // Return the list as the final preorder traversal
        return list;
    }

    // Traversal-2 -> Inorder Traversal
    public static void inorderTraversal(Node root, List<Integer> list) {

        // Base case : If the root is null, simply return
        if (root == null)
            return;

        // Follow the order : left -> root -> right

        // Go to the left subtree
        inorderTraversal(root.left, list);

        // Add the root to the list
        list.add(root.data);

        // Go to the right subtree
        inorderTraversal(root.right, list);
    }

    // Variation-2 -> Iterative Inorder Traversal
    public static List<Integer> iterativeInorderTraversal(Node root) {

        // If root is null, simply return
        if (root == null)
            return List.of();

        // Define a list to keep track of inorder
        List<Integer> list = new ArrayList<>();

        // Define a stack to keep track of nodes
        Stack<Node> stack = new Stack<>();

        // Get the root node
        Node current = root;

        // Traverse until failure
        while (true) {

            // If the current node is non null, add it to stack and go to its left
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                // If the current node is null, pop the stack and add the node to the list
                if (!stack.isEmpty()) {
                    current = stack.pop();
                    list.add(current.data);
                    current = current.right;
                } else
                    break;
            }
        }

        // Return list as the final inorder traversal
        return list;
    }

    // Traversal-3 -> Postorder Traversal
    public static void postorderTraversal(Node root, List<Integer> list) {

        // Base case : If the root is null, simply return
        if (root == null)
            return;

        // Follow the order : left -> right -> root

        // Go to the left subtree
        postorderTraversal(root.left, list);

        // Go to the right subtree
        postorderTraversal(root.right, list);

        // Add the root to the list
        list.add(root.data);
    }

    // Variation-3.1 -> Iterative Postorder Traversal using two stacks
    public static List<Integer> iterativePostorderTraversalTwoStacks(Node root) {

        // If the root node is null, simply return
        if (root == null)
            return List.of();

        // Define two stacks to keep track of the nodes
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        // Define a list to keep track of the postorder
        List<Integer> list = new ArrayList<>();

        // Add the root node to the stack1
        stack1.push(root);

        // Iterate until the stack1 is empty
        while (!stack1.isEmpty()) {

            // Get the current node from the stack1
            Node current = stack1.pop();

            // Add the current node to the stack2
            stack2.push(current);

            // Add the current node's left to stack1
            if (current.left != null)
                stack1.push(current.left);

            // Add the current node's right to stack1
            if (current.right != null)
                stack1.push(current.right);
        }

        // Pop the stack2 and add it to the list
        while (!stack2.isEmpty())
            list.add(stack2.pop().data);

        // Return the list as the final postorder traversal
        return list;
    }

    // Variation-3.2 -> Iterative Postorder Traversal using one stack
    public static List<Integer> iterativePostorderTraversalOneStack(Node root) {

        // If the root node is null, simply return
        if (root == null)
            return List.of();

        // Define a stack to keep track of the nodes
        Stack<Node> stack = new Stack<>();

        // Define a list to keep track of the postorder
        List<Integer> list = new ArrayList<>();

        // Get the root node
        Node current = root;

        // Iterate until current is null or stack is empty
        while (current != null || !stack.isEmpty()) {

            // If the current is non null, add it to the stack and go to its left
            if (current != null) {
                stack.push(current);
                current = current.left;
            }

            // If current is null, go to right first and then continue going left
            else {

                Node temp = stack.peek().right;

                // If temp is null,
                if (temp == null) {

                    // Get the top 
                    temp = stack.pop();

                    // Add temp to the list
                    list.add(temp.data);

                    // Until the stack is not empty and temp is equal to the top's right
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        list.add(temp.data);
                    }
                }
                // If not, assign current to temp
                else
                    current = temp;
            }

        }

        // Return the list as the final postorder traversal
        return list;
    }

    // Traversal-4 -> Level-order Traversal
    public static void levelorderTraversal(Node root, int level, List<List<Integer>> list) {

        // Base case : If the root is null, simply return
        if (root == null)
            return;

        // If the level is equal to the list size, add a new level
        if (level >= list.size())
            list.add(new ArrayList<>());

        // Add the root to the list
        list.get(level).add(root.data);

        // Go to the left subtree
        levelorderTraversal(root.left, level + 1, list);

        // Go to the right subtree
        levelorderTraversal(root.right, level + 1, list);
    }

    // Variation-4 -> Iterative Levelorder Traversal
    public static List<List<Integer>> iterativeLevelorderTraversal(Node root) {

        // Define a list to keep track of the levels and nodes
        List<List<Integer>> list = new ArrayList<>();

        // Define a queue to store the nodes
        Queue<Node> queue = new LinkedList<>();

        // Add the root node in the queue
        queue.add(root);

        // Iterate until the queue is empty
        while (!queue.isEmpty()) {

            // Get current level by getting the size of the queue
            int level = queue.size();

            // Create a list for the current level
            List<Integer> levelList = new ArrayList<>();

            // Iterate over the current level
            for (int i = 0; i < level; i++) {

                // Get the current node from the queue
                Node current = queue.poll();

                // Add the left of current node to the queue
                if (current.left != null)
                    queue.add(current.left);

                // Add the right of current node to the queue
                if (current.right != null)
                    queue.add(current.right);

                // Add the current node to the level list
                levelList.add(current.data);
            }

            // Add the level list to the list of levels
            list.add(levelList);
        }

        // Return result as the final level order traversal
        return list;
    }
}
