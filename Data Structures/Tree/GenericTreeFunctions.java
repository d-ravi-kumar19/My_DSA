
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


class Solution {
    
    // Function to calculate the height of the binary tree
    public int height(TreeNode node) {
        if (node == null) {
            return -1; // Return -1 for empty tree
        } else {
            int leftHeight = height(node.left);
            int rightHeight = height(node.right);
            return Math.max(leftHeight, rightHeight) + 1; // Add 1 for the current node
        }
    }

    // Function to calculate the depth of a given node
    public int depth(TreeNode root, TreeNode node) {
        return findDepth(root, node, 0);
    }

    private int findDepth(TreeNode current, TreeNode node, int d) {
        if (current == null) {
            return -1; // Node not found
        }
        if (current == node) {
            return d; // Depth found
        }
        int leftDepth = findDepth(current.left, node, d + 1);
        if (leftDepth != -1) {
            return leftDepth; // Node found in left subtree
        }
        return findDepth(current.right, node, d + 1); // Search in right subtree
    }

    // Function to calculate the sum of all elements in the tree
    public int sumOfElements(TreeNode node) {
        if (node == null) {
            return 0; // Base case for empty tree
        }
        return node.val + sumOfElements(node.left) + sumOfElements(node.right); // Sum the current node and its subtrees
    }

    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Height of the tree: " + solution.height(root));            // Height
        System.out.println("Sum of all elements: " + solution.sumOfElements(root));   // Sum of elements

        TreeNode nodeToFind = root.left; // Example node to find the depth of
        System.out.println("Depth of node " + nodeToFind.val + ": " + solution.depth(root, nodeToFind)); // Depth
    }
}
