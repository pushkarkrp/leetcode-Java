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
    List<Integer> sums = new ArrayList<>();
    public int maxProduct(TreeNode root) {
        long totalSum = getSum(root);
        long result = 0;
        for (int sum : sums) {
            result = Math.max(result, sum*(totalSum-sum));
        }
        return (int)(result%1000000007);
    }
    public int getSum(TreeNode root) {
        if (root == null) return 0;
        int leftSum = getSum(root.left);
        int rightSum = getSum(root.right);
        int sum = (leftSum + rightSum + root.val);
        sums.add(sum);
        return sum;
    } 
}