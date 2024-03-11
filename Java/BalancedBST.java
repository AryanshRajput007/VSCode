package Java;

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

public class BalancedBST {
    Node root;

    public BalancedBST() {
        root = null;
    }

    // Insert a key into the BST
    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
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

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    boolean isBalanced() {
        return isBalancedRec(root);
    }

    boolean isBalancedRec(Node root) {
        int lh;
        int rh;

        if (root == null) {
            return true;
        }

        lh = getHeight(root.left);
        rh = getHeight(root.right);

        if(Math.abs(lh - rh) <= 1 && isBalancedRec(root.left) && isBalancedRec(root.right)) {
            return true;
        }
        return false;
    }

    int getHeight(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
    

    public static void main(String[] args) {
        BalancedBST tree = new BalancedBST();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder traversal of the constructed BST:");
        tree.inorder();

        boolean a = tree.isBalanced();
        System.out.println("The tree is balanced: " + a);
    }
}
