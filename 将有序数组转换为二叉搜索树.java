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
    public TreeNode sortedArrayToBST(int[] nums) {
        int left = 0,right = nums.length - 1;
        return traverse(nums,left,right);
    }
    public TreeNode traverse(int[] nums,int left,int right) {
        if(left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = traverse(nums,left,mid - 1);
        root.right = traverse(nums,mid + 1,right);
        return root;
    }
}

//迭代法
 public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) {
            return null;
        }
        //迭代法，模拟分割的过程，用三个队列
        TreeNode ans = new TreeNode(-1);
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> leftQueue = new LinkedList<>();
        Queue<Integer> rightQueue = new LinkedList<>();
        nodeQueue.offer(ans);
        leftQueue.offer(0);
        rightQueue.offer(nums.length - 1);
        while(!nodeQueue.isEmpty()) {
            TreeNode root = nodeQueue.poll();
            int left = leftQueue.poll();
            int right = rightQueue.poll();
            int mid = left + (right - left) / 2;
            root.val = nums[mid];
            if(left < mid) {
                root.left = new TreeNode(-1);
                nodeQueue.offer(root.left);
                leftQueue.offer(left);
                rightQueue.offer(mid - 1);
            }

            if(right > mid) {
                root.right = new TreeNode(-1);
                nodeQueue.offer(root.right);
                leftQueue.offer(mid + 1);
                rightQueue.offer(right);
            }
        }
        return ans;
    }
