// 98. Validate Binary Search Tree
// Solved
// Medium
// Topics
// Companies
// Given the root of a binary tree, determine if it is a valid binary search tree (BST).

// A valid BST is defined as follows:

// The left 
// subtree
//  of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.
 

// Example 1:


// Input: root = [2,1,3]
// Output: true
// Example 2:


// Input: root = [5,1,4,null,null,3,6]
// Output: false
// Explanation: The root node's value is 5 but its right child's value is 4.
 

// Constraints:

// The number of nodes in the tree is in the range [1, 104].
// -231 <= Node.val <= 231 - 1



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
    
    // Function to validate if the tree is a valid BST
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // Helper function to check the validity of the BST
    private boolean isValidBSTHelper(TreeNode node, long min, long max) {
        if (node == null) {
            return true; // An empty node is a valid BST
        }
        
        // Check the current node's value against min and max bounds
        if (node.val <= min || node.val >= max) {
            return false; // Invalid BST
        }
        
        // Recursively check left and right subtrees with updated bounds
        return isValidBSTHelper(node.left, min, node.val) && 
               isValidBSTHelper(node.right, node.val, max);
    }

    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();

        // Example 1: Valid BST
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        System.out.println("Is valid BST: " + solution.isValidBST(root1)); // Output: true

        // Example 2: Invalid BST
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3); // This makes it invalid
        root2.right.right = new TreeNode(6);
        System.out.println("Is valid BST: " + solution.isValidBST(root2)); // Output: false
    }
}
