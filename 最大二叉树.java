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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums,0,nums.length - 1);
    }
    public TreeNode helper(int[] nums,int left,int right) {
        if(left > right) {
            return null;
        }
        int pos = find(nums,left,right);
        TreeNode root = new TreeNode(nums[pos]);
        root.left = helper(nums,left,pos - 1);
        root.right = helper(nums,pos + 1,right);
        return root;
    }
    public int find(int[] nums,int left,int right) {
        int max = -1;
        int id = -1;
        for(int i = left;i <= right;i++) {
            if(nums[i] > max) {
                max = nums[i];
                id = i;
            }
        }
        return id;
    }
}
