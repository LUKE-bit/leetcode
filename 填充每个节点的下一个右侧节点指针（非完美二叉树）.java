/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Deque<Node> que = new LinkedList<>();
        que.offerLast(root);
        if(root == null) {
            return root;
        }
        while(!que.isEmpty()) {
            int len = que.size();
            Node nodepre = null;
            Node node = null;
            for(int i = 0;i < len;i++) {
                if(i == 0) {
                    nodepre = que.pollFirst();
                    node = nodepre;
                }else {
                    node = que.pollFirst();
                    nodepre.next = node;
                    nodepre = nodepre.next;
                }
                if(node.left != null) que.offerLast(node.left);
                if(node.right != null) que.offerLast(node.right);
            }
            nodepre.next = null;
        }
        return root;
    }
}
