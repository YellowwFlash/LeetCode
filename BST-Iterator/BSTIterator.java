import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BSTIterator {

    // Reference node class for BST
    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    // Approach-1 -> Using the inorder traversal storage
    private List<Integer> inorder;
    private int index = -1;

    public BSTIterator(Node root) {
        inorder = new ArrayList<>();
        inorderTraversal(root);
    }

    private void inorderTraversal(Node root) {
        if (root == null)
            return;
        inorderTraversal(root.left);
        inorder.add(root.data);
        inorderTraversal(root.right);
    }

    public int next() {
        return inorder.get(++index);
    }

    public boolean hasNext() {
        return index < inorder.size() - 1;
    }

    // Approach-2 -> Using stack
    private Stack<Node> stack;

    public void BSTIterator2(Node root) {
        stack = new Stack<>();

        // Add all the lefts of the tree to the stack
        addLefts(root, stack);
    }

    private void addLefts(Node root, Stack<Node> stack) {

        // Define reference node for traversal
        Node ref = root;

        // Iterate the tree
        while (ref != null) {

            // Add current node in stack
            stack.push(ref);

            // Move to the left
            ref = ref.left;
        }
    }
    
    public int next2() {

        // Get the top node from stack
        Node current = stack.pop();

        // If the current's right is non null, add its lefts
        if (current.right != null)
            addLefts(current.right, stack);

        // Return the value of current  
        return current.data;
    }
    
    public boolean hasNext2() {
        
        // Return whether the stack is empty
        return !stack.isEmpty();
    }
}