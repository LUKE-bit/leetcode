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
    public List<Integer> largestValues(TreeNode root) {
        Deque<TreeNode> que = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        que.offerLast(root);
        while(!que.isEmpty()) {
            int len = que.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0;i < len;i++) {
                TreeNode node = que.pollFirst();
                if(node.val > max) {
                    max = node.val;
                }
                if(node.left != null) que.offerLast(node.left);
                if(node.right != null) que.offerLast(node.right);
            }
            ans.add(max);
        }
        return ans;
    }
}
