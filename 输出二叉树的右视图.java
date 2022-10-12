import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 求二叉树的右视图
     * @param xianxu int整型一维数组 先序遍历
     * @param zhongxu int整型一维数组 中序遍历
     * @return int整型一维数组
     */
    public int[] solve (int[] xianxu, int[] zhongxu) {
        // write code here
        if(xianxu.length==0){
            return new int[0];
        }
        TreeNode root = buildTree(xianxu,0,xianxu.length-1,zhongxu,0,zhongxu.length-1);
        ArrayList<Integer> list = rightSide(root);
        int[] res = new int[list.size()];
        for(int i = 0;i < list.size();i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    public TreeNode buildTree(int[] xianxu,int l1,int r1,int[]zhongxu,int l2,int r2) {
        if(l1 > r1 || l2 > r2) {
            return null;
        }
        TreeNode root = new TreeNode(xianxu[l1]);
        int index = 0;
        for(int i = l2;i <= r2;i++) {
            if(zhongxu[i] == xianxu[l1]){
                index = i;
                break;
            }
        }
        int leftSize = index - l2;
        int rightSize = r2 - index;
        root.left = buildTree(xianxu,l1+1,l1 + leftSize,zhongxu,l2,l2 + leftSize - 1);
        root.right = buildTree(xianxu,r1 - rightSize + 1,r1,zhongxu,index + 1,r2);
        return root;
    }
    public ArrayList<Integer> rightSide(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxDepth = -1;
        Stack<TreeNode> nodes = new Stack<>();
        Stack<Integer> depths = new Stack<>();
        nodes.push(root);
        depths.push(0);
        while(!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            int depth = depths.pop();
            if(node != null) {
                maxDepth = Math.max(maxDepth,depth);
                if(map.get(depth) == null){
                    map.put(depth,node.val);
                }
                nodes.push(node.left);
                nodes.push(node.right);
                depths.push(depth+1);
                depths.push(depth+1);
            }
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i = 0;i <= maxDepth;i++) {
            res.add(map.get(i));
        }
        return res;
    }
}
