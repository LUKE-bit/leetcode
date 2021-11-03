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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        que.offer(root);
        while(!que.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int len = que.size();
            while(len > 0) {
                TreeNode node = que.poll();
                list.add(node.val);
                if(node.left != null) {
                    que.offer(node.left);
                }
                if(node.right != null) {
                    que.offer(node.right);
                }
                len--;
            }
            ans.add(list.get(list.size() - 1));
        }
        return ans;
    }
}
