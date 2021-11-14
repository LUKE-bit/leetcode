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
    List<Integer> ans;
    int maxCount;
    int count;
    TreeNode pre;
    public int[] findMode(TreeNode root) {
        ans = new ArrayList<>();
        maxCount = 0;
        count = 0;
        pre = null;
        findMode1(root);
        int[] res = new int[ans.size()];
        for(int i = 0;i < res.length;i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    public void findMode1(TreeNode root) {
        if(root == null) {
            return;
        }
        findMode1(root.left);

        int rootValue = root.val;
        if(pre == null || rootValue != pre.val) {
            count = 1;
        }else {
            count++;
        }
        //更新
        if(count > maxCount) {
            ans.clear();
            maxCount = count;
            ans.add(rootValue);
        }else if(count == maxCount) {
            ans.add(rootValue);
        }
        pre = root;
        findMode1(root.right);
    }
}
