package Java;

import java.util.ArrayList;

class BoundaryNode {
    int data;
    BoundaryNode left;
    BoundaryNode right;

    public BoundaryNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class BoundaryTree {

    ArrayList<Integer> list = new ArrayList<>();

    public BoundaryNode insert(BoundaryNode root, int data) {
        if(root == null) {
            return new BoundaryNode(data);
        }

        if(data < root.data) {
            root.left = insert(root.left, data);
        } else if(data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    public ArrayList<Integer> boundaryTraversal(BoundaryNode root) {
        leftBoundaryTraversal(root);
        leaves(root);
        rightBoundaryTraversal(root);
        return list;
    }

    private void leftBoundaryTraversal(BoundaryNode root) {
        if(root != null) {
            if(root.left != null || root.right != null) {
                list.add(root.data);;
            }
            if(root.left != null) {
                leftBoundaryTraversal(root.left);
            } else if(root.right != null) {
                leftBoundaryTraversal(root.right);
            }
        }
    }

    private void rightBoundaryTraversal(BoundaryNode root) {
        if(root != null) {
            if(root.right != null) {
                rightBoundaryTraversal(root.right);
                list.add(root.data);
            } else if(root.left != null) {
                rightBoundaryTraversal(root.left);
                list.add(root.data);
            }
        }
    }

    private void leaves(BoundaryNode root) {
        if(root != null) {
            if(root.left == null && root.right == null) {
                list.add(root.data);
            }
            leaves(root.left);
            leaves(root.right);
        }
    }
}

public class BoundaryTraversalSelf {
    public static void main(String[] args) {
        BoundaryNode root = null;
        BoundaryTree tree = new BoundaryTree();
        root = tree.insert(root, 20);
        tree.insert(root, 10);
        tree.insert(root, 30);
        tree.insert(root, 5);
        tree.insert(root, 15);
        tree.insert(root, 25);
        tree.insert(root, 35);

        ArrayList<Integer> boundaryNodes = tree.boundaryTraversal(root);
        System.out.println("Boundary Traversal: " + boundaryNodes);
    }
}
