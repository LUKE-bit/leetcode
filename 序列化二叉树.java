/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
import java.util.*;
public class Solution {
    int Inf = 0x3f3f3f3f;
    TreeNode emptyNode = new TreeNode(Inf);
    String Serialize(TreeNode root) {
        if(root==null) return "";
        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while(!deque.isEmpty()) {
            TreeNode poll = deque.poll();
            sb.append(poll.val+"_");
            if(!poll.equals(emptyNode)){
                deque.add(poll.left!=null?poll.left:emptyNode);
                deque.add(poll.right!=null?poll.right:emptyNode);
            }
        }
        return sb.toString();
    }
    TreeNode Deserialize(String str) {
        if(str.equals("")) return null;
        Deque<TreeNode> deque = new LinkedList<>();
        String[] ss = str.split("_");
        int n = ss.length;
        TreeNode root = new TreeNode(Integer.parseInt(ss[0]));
        deque.add(root);
        for(int i = 1;i < n-1;i+=2){
            TreeNode poll = deque.poll();
            int a = Integer.parseInt(ss[i]),b = Integer.parseInt(ss[i+1]);
            if(a!=Inf){
                poll.left = new TreeNode(a);
                deque.add(poll.left);
            }
            if(b!=Inf){
                poll.right = new TreeNode(b);
                deque.add(poll.right);
            }
        }
        return root;
    }
}
