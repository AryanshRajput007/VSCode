package Java;

class LCATreeNode {
    int data;
    LCATreeNode left;
    LCATreeNode right;

    public LCATreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class LowestCommonAncestorbinaryTree {

    void inorder(LCATreeNode root) {
        if(root != null) {
            inorder(root.left);
            System.out.println(root.data);
            inorder(root.right);
        }
    }

    // Method to find the lowest common ancestor of two nodes
    public LCATreeNode lowestCommonAncestor(LCATreeNode root, LCATreeNode p, LCATreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }

        LCATreeNode left_lca = lowestCommonAncestor(root.left, p, q);
        LCATreeNode right_lca = lowestCommonAncestor(root.right,p, q);

        if (left_lca != null && right_lca != null) {
            return root;
        }
        else if(left_lca == null) {
            return right_lca;
        }
        else {
            return left_lca;
        }
    }

    public static void main(String[] args) {
        LCATreeNode root = new LCATreeNode(3);
        root.left = new LCATreeNode(5);
        root.right = new LCATreeNode(1);
        root.right.left = new LCATreeNode(0);
        root.right.right = new LCATreeNode(8);
        root.left.left = new LCATreeNode(6);
        root.left.right = new LCATreeNode(2);
        root.left.right.left = new LCATreeNode(7);
        root.left.right.right = new LCATreeNode(4);

        LowestCommonAncestorbinaryTree obj = new LowestCommonAncestorbinaryTree();
        obj.inorder(root);
        
        LCATreeNode p = root.left;
        LCATreeNode q = root.right;
        
        LCATreeNode lca = obj.lowestCommonAncestor(root, p, q);
        System.out.println("Lowest Common Ancestor of " + p.data + " and " + q.data + " is " + lca.data);
    }
}
