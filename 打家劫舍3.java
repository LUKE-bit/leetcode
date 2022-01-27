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
    Map<TreeNode,Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        //第一种做法：记忆化递推
        //分为两种情况，偷父节点，不偷父节点，但是有些节点会重复使用，所以使用记忆化递归，使用
        //map来记录使用过的节点
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return root.val;
        }
        if(map.get(root) != null) return map.get(root);
        int val1 = root.val;
        //偷父节点
        if(root.left != null) val1 += rob(root.left.left) + rob(root.left.right);
        if(root.right != null) val1 += rob(root.right.left) + rob(root.right.right);
        //不偷父节点
        int val2 = rob(root.left) + rob(root.right);
        map.put(root,Math.max(val1,val2));
        return Math.max(val1,val2);
    }
}

//动态规划（树形贪心）
