// 230. Kth Smallest Element in a BST
// Solved
// Medium
// Topics
// Companies
// Hint
// Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

 

// Example 1:


// Input: root = [3,1,4,null,2], k = 1
// Output: 1
// Example 2:


// Input: root = [5,3,6,2,4,null,null,1], k = 3
// Output: 3
 

// Constraints:

// The number of nodes in the tree is n.
// 1 <= k <= n <= 104
// 0 <= Node.val <= 104
 

// Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


// ======================= Solution -1 ======================
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

import java.util.*;

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        // List<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        inorder(root, minHeap);  

        for(int i =0; i<k-1; i++){
            minHeap.poll();
        }

        return minHeap.poll();
    }

    private void inorder(TreeNode root, PriorityQueue<Integer> minHeap){
        if(root == null){
            return;
        }

        inorder(root.left, minHeap);
        minHeap.add(root.val);
        inorder(root.right, minHeap);

    }
}



// ======================= Solution -2 ======================
// -------------------------------------------//
//          Optimized Solution                //
//--------------------------------------------//

class Solution {
    private int result = Integer.MAX_VALUE;
    private int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);  
        return result;
    }

    private void inorder(TreeNode root, int k){
        if(root == null){
            return;
        }

        inorder(root.left, k);
        count++;
        if(k == count){
            result = root.val;
            return;
        }
        inorder(root.right, k);
    }
}