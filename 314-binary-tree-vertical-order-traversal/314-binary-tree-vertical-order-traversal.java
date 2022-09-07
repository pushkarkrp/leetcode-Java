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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> col = new LinkedList<>();       
        q.add(root);
        col.add(0);
        int max = 0;
        int min = 0;
        while (!q.isEmpty()) {
            TreeNode current = q.poll();
            Integer val = col.poll();
            map.putIfAbsent(val, new ArrayList<Integer>());
            map.get(val).add(current.val);
            if (current.left != null) {
                q.add(current.left);
                col.add(val-1);
                min = Math.min(min, val-1);
            }
            if (current.right != null) {
                q.add(current.right);
                col.add(val+1);
                max = Math.max(max, val+1);
            }
        }
        for (int i = min; i <= max; i++) {
            result.add(map.get(i));
        }
        return result;
    }
}