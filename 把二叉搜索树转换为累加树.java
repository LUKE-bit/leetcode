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
    //迭代法
    int pre = 0;
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }
    public void traverse(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()) {
            if(cur != null) {//右
                stack.push(cur);
                cur = cur.right;
            }else {
                cur = stack.pop();//中
                cur.val += pre;
                pre = cur.val;
                cur = cur.left;//左
            }
        }
    }
}
//递归法
class Solution {
    int pre = 0;
    public TreeNode convertBST(TreeNode root) {
        add(root);
        return root;
    }
    public void add(TreeNode root) {
        if(root == null) {
            return;
        }
        //反中序遍历
        add(root.right);
        root.val += pre;
        pre = root.val;
        add(root.left);
    }
}
