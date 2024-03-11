package Java;

import Structures.TreeTraversal;
import Structures.TreeNode;

import java.util.ArrayList;

public class BoundaryTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.right = new TreeNode(70);
        root.right.left = new TreeNode(40);
        root.right.left.left = new TreeNode(100); // Corrected this line
        root.right.right = new TreeNode(50);
        root.right.right.left = new TreeNode(80);
        root.right.right.right = new TreeNode(90);

        TreeTraversal traverse = new TreeTraversal();
        ArrayList<Integer> list = traverse.boundaryTraversal(root);
        for (int ele : list) {
            System.out.print(ele + " ");
        }
    }
}
