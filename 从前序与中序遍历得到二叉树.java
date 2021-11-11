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
    Map<Integer,Integer> inorderID = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for(int i = 0;i < inorder.length;i++) {
            inorderID.put(inorder[i],i);
        }
        return helper(preorder,inorder,0,n - 1,0,n - 1);
    }
    public TreeNode helper(int[] preorder,int[] inorder,int preorderLeft,int preorderRight,int inorderLeft,int inorderRight) {
        if(preorderLeft > preorderRight) {
            return null;
        }
        int rootID = preorderLeft;
        int inorderRoot = inorderID.get(preorder[rootID]);
        TreeNode root = new TreeNode(preorder[rootID]);
        int sum = inorderRoot - inorderLeft;
        root.left = helper(preorder,inorder,preorderLeft + 1,preorderLeft + sum,inorderLeft,inorderRoot - 1);
        root.right = helper(preorder,inorder,preorderLeft + 1 + sum,preorderRight,inorderRoot + 1,inorderRight);
        return root;
    }
}
