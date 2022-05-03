//输入一个长度为 n 字符串，打印出该字符串中字符的所有排列，你可以以任意顺序返回这个字符串数组。
//例如输入字符串ABC,则输出由字符A,B,C所能排列出来的所有字符串ABC,ACB,BAC,BCA,CBA和CAB。
import java.util.*;
public class Solution {
    public ArrayList<String> Permutation(String str) {
       ArrayList<String> res = new ArrayList<String>();
        if(str == null || str.length() == 0){
            return res;
        }
        boolean[] vis = new boolean[str.length()];
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        Arrays.fill(vis,false);
        Arrays.sort(chars);
        backTracking(sb,chars,vis,res);
        return res;
    }
    public void backTracking(StringBuilder sb,char[] chars,boolean[] vis,ArrayList<String> res){
        if(sb.length() == chars.length){
            res.add(new String(sb));
            return;
        }
        for(int i = 0;i < chars.length;i++){
            if(vis[i]){
                continue;
            }
            if(i>0 && chars[i-1] == chars[i] && vis[i-1]){
                continue;
            }
            vis[i] = true;
            sb.append(chars[i]);
            backTracking(sb,chars,vis,res);
            vis[i] = false;
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
