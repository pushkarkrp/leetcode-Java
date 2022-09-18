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
class Solution {
    public int largestBSTSubtree(TreeNode root) {
        int[] result = postOrder(root);
        return result[2];
    }
    
    public int[] postOrder(TreeNode root) {
        if (root == null) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }
        int[] left = postOrder(root.left);
        int[] right = postOrder(root.right);
        
        if (root.val > left[1] && root.val < right[0]) {
            return new int[] {Math.min(root.val, left[0]), Math.max(root.val, right[1]), left[2] + 1 + right[2]};
        }
        return new int[] {Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left[2],right[2])};
    }
}