package Java;

// import java.util.HashMap;

class TreeNode {
    int key;
    TreeNode left, right;

    public TreeNode(int item) {
        key = item;
        left = right = null;
    }
}

public class HeightAndDepth {
    TreeNode root;

    public HeightAndDepth() {
        root = null;
    }

    // Insert a key into the BST
    void insert(int key) {
        root = insertRec(root, key);
    }

    TreeNode insertRec(TreeNode root, int key) {
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    // Inorder traversal of the BST
    void inorder() {
        inorderRec(root);
    }

    void inorderRec(TreeNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    int getHeight() {
        return getHeightRec(root);
    }

    int getHeightRec(TreeNode root) {
        int lh;
        int rh;

        if(root == null) {
            return 0;
        }

        lh = heightFinder(root.left);
        rh  = heightFinder(root.right);

        return Math.max(lh + 1, rh + 1);
        // HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // return map;
    }

    int heightFinder(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(heightFinder(root.left), heightFinder(root.right));
    }
    // boolean isBalanced() {
    //     return isBalancedRec(root);
    // }

    // boolean isBalancedRec(TreeNode root) {
    //     int lh;
    //     int rh;

    //     if (root == null) {
    //         return true;
    //     }

    //     lh = getHeight(root.left);
    //     rh = getHeight(root.right);

    //     if(Math.abs(lh - rh) <= 1 && isBalancedRec(root.left) && isBalancedRec(root.right)) {
    //         return true;
    //     }
    //     return false;
    // }

    // int getHeight(TreeNode root) {
    //     if (root == null) {
    //         return 0;
    //     }
    //     return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    // }
    

    public static void main(String[] args) {
        HeightAndDepth tree = new HeightAndDepth();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder traversal of the constructed BST:");
        tree.inorder();

        int a = tree.getHeight();
        System.out.println("\nThe tree is balanced: " + a);
    }
}
