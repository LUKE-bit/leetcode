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
    TreeNode pre;
    int result = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if(root == null) {
            return 0;
        }
        traverse(root);
        return result;
    }
    public void traverse(TreeNode node) {
        if(node == null) {
            return;
        }
        traverse(node.left);

        if(pre!=null) {
            result = Math.min(result,node.val - pre.val);
        }
        pre = node;

        traverse(node.right);
    }
}
