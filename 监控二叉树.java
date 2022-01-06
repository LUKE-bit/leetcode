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
    int result = 0;
    public int minCameraCover(TreeNode root) {
        if(traverse(root) == 0) {
            result++;
        }
        return result;
    }
    public int traverse(TreeNode cur) {
        //判断空节点是什么状态
        //0代表无覆盖，1代表有摄像头，2代表有覆盖
        if(cur == null) {
            return 2;
        }
        int left = traverse(cur.left);
        int right = traverse(cur.right);
        //情况一：左右节点里有一个是无覆盖，则
        //父节点需有一个摄像头
        if(left == 0 || right == 0) {
            result++;
            return 1;
        }
        //情况二：左右节点有一个是摄像头
        if(left == 1 || right == 1) {
            return 2;
        }
        //情况三：左右节点都有覆盖
        if(left == 2 && right == 2) {
            return 0;
        }
        return -1;
    }
}
