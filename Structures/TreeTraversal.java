package Structures;

import java.util.ArrayList;

public class TreeTraversal {
    public ArrayList<Integer> boundaryTraversal(TreeNode root) {
        BoundaryTraversal traversal = new BoundaryTraversal();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(root.data); // Add root to the list
        traversal.printLeftBoundary(root.left, list); // Call printLeftBoundary with list parameter
        traversal.printLeaves(root.left, list); // Call printLeaves with list parameter
        traversal.printLeaves(root.right, list); // Call printLeaves with list parameter
        traversal.printRightBoundary(root.right, list); // Call printRightBoundary with list parameter
        return list;
    }
}

class BoundaryTraversal {

    public void printLeftBoundary(TreeNode root, ArrayList<Integer> list) {
        if (root != null) {
            if(root.left != null) {
                list.add(root.data);
                printLeftBoundary(root.left, list); // Recursively call printLeftBoundary with list parameter
            } else if (root.right != null) {
                list.add(root.data);
                printLeftBoundary(root.right, list); // Recursively call printLeftBoundary with list parameter
            }
        }
    }

    public void printRightBoundary(TreeNode root, ArrayList<Integer> list) {
        if(root != null) {
            if(root.right != null) {
                printRightBoundary(root.right, list); // Recursively call printRightBoundary with list parameter
                list.add(root.data);
            } else if(root.left != null) {
                printRightBoundary(root.left, list); // Recursively call printRightBoundary with list parameter
                list.add(root.data);
            }
        }
    }

    public void printLeaves(TreeNode root, ArrayList<Integer> list) {
        if(root != null) {
            printLeaves(root.left, list); // Recursively call printLeaves with list parameter

            if (root.left == null && root.right == null) {
                list.add(root.data);
            }

            printLeaves(root.right, list); // Recursively call printLeaves with list parameter
        }
    }
}
