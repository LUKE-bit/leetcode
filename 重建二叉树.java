import java.util.*;
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] vin) {
        return dfs(0,0,vin.length-1,pre,vin);
    }
    public TreeNode dfs(int preStart,int inStart,int inEnd,int[] pre,int[] vin){
        if(preStart > pre.length || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        int index = 0;
        for(int i = inStart;i <= inEnd;i++) {
            if(vin[i] == root.val){
                index = i;
                break;
            }
        }
        root.left = dfs(preStart+1,inStart,index-1,pre,vin);
        root.right = dfs(preStart + index - inStart + 1,index + 1,inEnd,pre,vin);
        return root;
    }
}
