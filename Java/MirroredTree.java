package Java;

class MirrorTreeNode {
    int val;
    MirrorTreeNode left;
    MirrorTreeNode right;

    MirrorTreeNode(int x) {
        val = x;
    }
}

public class MirroredTree {
    public boolean isMirror(MirrorTreeNode root1, MirrorTreeNode root2) {
        if (root1 == null && root2 == null)
            return true;

        if (root1 == null || root2 == null)
            return false;

        return (root1.val == root2.val)
                && isMirror(root1.left, root2.right)
                && isMirror(root1.right, root2.left);
    }

    public static void main(String[] args) {
        MirroredTree checker = new MirroredTree();

        // Create example trees
        MirrorTreeNode tree1 = new MirrorTreeNode(1);
        tree1.left = new MirrorTreeNode(2);
        tree1.right = new MirrorTreeNode(3);
        tree1.left.left = new MirrorTreeNode(4);
        tree1.left.right = new MirrorTreeNode(5);

        MirrorTreeNode tree2 = new MirrorTreeNode(1);
        tree2.left = new MirrorTreeNode(3);
        tree2.right = new MirrorTreeNode(2);
        tree2.right.left = new MirrorTreeNode(5);
        tree2.right.right = new MirrorTreeNode(4);

        if (checker.isMirror(tree1, tree2))
            System.out.println("The trees are mirror images.");
        else
            System.out.println("The trees are not mirror images.");
    }
}
