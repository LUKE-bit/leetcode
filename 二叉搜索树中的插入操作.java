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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode start = root;
        if(root == null) {
            return new TreeNode(val);
        }
        while(true) {
            if(val > root.val && root.right == null) {
                TreeNode node = new TreeNode(val);
                root.right = node;
                break;
            }else if(val < root.val && root.left == null) {
                TreeNode node = new TreeNode(val);
                root.left = node;
                break;
            }else if(val > root.val) {
                root = root.right;
            }else {
                root = root.left;
            }
        }
        return start;
    }
}

//递归法
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val);
        }
        if(root.val > val) {
            root.left = insertIntoBST(root.left,val);
        }else if (root.val < val) {
            root.right = insertIntoBST(root.right,val);
        }
        return root;
    }
}
