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
    int post_id;
    int[] inorder;
    int[] postorder;
    Map<Integer, Integer> idx = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        post_id = postorder.length - 1;
        int id = 0;
        for(Integer val : inorder) {
            idx.put(val,id++);
        }
        return helper(0,inorder.length - 1);
    }
    public TreeNode helper(int left,int right) {
        if(left > right) {
            return null;
        }
        int root_val = postorder[post_id];
        TreeNode root = new TreeNode(root_val);
        int index = idx.get(root_val);
        post_id--;
        root.right = helper(index+1,right);
        root.left = helper(left,index - 1);
        return root;
    }
}
