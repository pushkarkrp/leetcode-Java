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
    public TreeNode sortedArrayToBST(int[] nums) {
        return balancedTree(nums, 0, nums.length-1);
    }
    
    public TreeNode balancedTree(int[] nums, int l, int r) {
        if(l > r) return null;
        int m = l + (r - l) / 2;
        TreeNode node = new TreeNode(nums[m], null, null);
        node.left = balancedTree(nums, l, m - 1);
        node.right = balancedTree(nums, m + 1, r);
        return node;
    }
}