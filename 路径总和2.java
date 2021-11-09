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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        List<Integer> list = new ArrayList<>();
        hasPathSum(root,targetSum,list,ans);
        return ans;
    }
    public void hasPathSum(TreeNode node,int targetSum,List<Integer> list,List<List<Integer>> ans) {
        list.add(node.val);
        if(node.left == null && node.right == null) {
            if(targetSum == node.val) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        if(node.left != null) {
            hasPathSum(node.left,targetSum-node.val,list,ans);
            list.remove(list.size() - 1);
        }
        if(node.right != null) {
            hasPathSum(node.right,targetSum-node.val,list,ans);
            list.remove(list.size() - 1);
        }
    }
}
