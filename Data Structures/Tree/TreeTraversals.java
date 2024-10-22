import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}



class BinaryTree {
    TreeNode root;

    // Inorder Traversal
    public List<Integer> inorderTraversal(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(node, result);
        return result;
    }

    private void inorderHelper(TreeNode node, List<Integer> result) {
        if (node != null) {
            inorderHelper(node.left, result);   // Visit left subtree
            result.add(node.val);                // Visit node
            inorderHelper(node.right, result);  // Visit right subtree
        }
    }

    // Preorder Traversal
    public List<Integer> preorderTraversal(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        preorderHelper(node, result);
        return result;
    }

    private void preorderHelper(TreeNode node, List<Integer> result) {
        if (node != null) {
            result.add(node.val);                // Visit node
            preorderHelper(node.left, result);   // Visit left subtree
            preorderHelper(node.right, result);  // Visit right subtree
        }
    }

    // Postorder Traversal
    public List<Integer> postorderTraversal(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        postorderHelper(node, result);
        return result;
    }

    private void postorderHelper(TreeNode node, List<Integer> result) {
        if (node != null) {
            postorderHelper(node.left, result);  // Visit left subtree
            postorderHelper(node.right, result); // Visit right subtree
            result.add(node.val);                // Visit node
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        
        System.out.println("Inorder Traversal: " + tree.inorderTraversal(tree.root));   // Output: [4, 2, 5, 1, 3]
        System.out.println("Preorder Traversal: " + tree.preorderTraversal(tree.root)); // Output: [1, 2, 4, 5, 3]
        System.out.println("Postorder Traversal: " + tree.postorderTraversal(tree.root)); // Output: [4, 5, 2, 3, 1]
    }
}
