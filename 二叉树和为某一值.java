import java.util.ArrayList;
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int expectNumber) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        find(root,arr,expectNumber);
        return res;
    }
    
    public void find(TreeNode root,ArrayList<Integer> arr,int num){
        if(root==null)return;
        
        num-=root.val;
        arr.add(root.val);
        if(num==0 && root.left==null && root.right == null){
            res.add(new ArrayList<>(arr));
        }
        
        find(root.left,arr,num);
        find(root.right,arr,num);
        arr.remove(arr.size()-1);
    }
}
