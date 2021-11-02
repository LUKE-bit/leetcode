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
     public List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        order(root);
        Collections.reverse(ans);
        return ans;
    }
    public void order(TreeNode node) {
        if(node == null) return;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(node);
        while(!que.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int len = que.size();
            while(len > 0) {
                TreeNode tmp = que.poll();
                list.add(tmp.val);
                if(tmp.left != null) que.offer(tmp.left);
                if(tmp.right != null) que.offer(tmp.right);
                len--;
            }
            ans.add(list);
        }
    }
}
