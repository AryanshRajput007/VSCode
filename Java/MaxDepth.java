package Java;

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        return Math.max(leftDepth, rightDepth) + 1;
    }
    
    public static void main(String[] args) {
        MaxDepth solution = new MaxDepth();
        
        // Example usage:
        // Constructing a sample tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        
        // Finding the maximum depth of the tree
        int maxDepth = solution.maxDepth(root);
        System.out.println("Max depth of the tree: " + maxDepth); // Output should be 3 for the given sample tree
    }
}
