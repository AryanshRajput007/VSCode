package Java.Aarzoo;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

// BST 
// class TreeA {
//     TreeNode root;

//     TreeA() {
//         root = null;
//     }

//     void inorder() {
//         inorderRec(root);
//     }

//     void inorderRec(TreeNode root) {
//         if(root != null) {
//             inorderRec(root.left);
//             System.out.println((root.data) + " ");
//             inorderRec(root.right);
//         }
//     }
// }

public class Tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        
        printInOrder(root);
    }

    static void printInOrder(TreeNode root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.print(root.data + " ");
            printInOrder(root.right);
        }
    }
}


