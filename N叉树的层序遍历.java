/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> que = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        que.offer(root);
        while(!que.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int len = que.size();
            for(int i = 0;i < len;i++) {
                Node node = que.poll();
                list.add(node.val);
                que.addAll(node.children);
            }
            ans.add(list);
        }
        return ans;
    }
}
