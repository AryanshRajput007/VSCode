package Java;

class TreeNode542 {
    int val;
    TreeNode542 left;
    TreeNode542 right;
    
    TreeNode542(int val) {
        this.val = val;
    }
}

public class Question542 {
    private int maxDiameter;

    public int diameterOfBinaryTree(TreeNode542 root) {
        if (root == null) {
            return 0;
        }
        
        maxDepth(root);
        return maxDiameter;
    }
    
    public int maxDepth(TreeNode542 root) {
        if (root == null) {
            return 0;
        }
        
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);
        // System.out.println("Max Diameter: " + maxDiameter);
        // System.out.println("leftDepth: " + leftDepth);
        // System.out.println("rightDepth: " + rightDepth);
        // System.out.println("Return value: " + (Math.max(leftDepth, rightDepth) + (int)(1)));
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        // Creating the tree from the given list [1, 2]
        TreeNode542 root = new TreeNode542(1);
        root.right = new TreeNode542(2);
    
        // Creating an instance of BinaryTree class
        Question542 tree = new Question542();
    
        // Calculating the diameter of the binary tree
        int diameter = tree.diameterOfBinaryTree(root);
    
        // Printing the diameter
        System.out.println("Diameter of the binary tree: " + diameter);
    }    
}
