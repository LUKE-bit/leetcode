import java.util.*;


public class Solution {
    /**
     * 
     * @param strs string字符串一维数组 
     * @return string字符串
     */
    public String longestCommonPrefix (String[] strs) {
        // write code here
        if(strs.length==0){
            return "";
        }
        for(int i = 0;i < strs[0].length();i++) {
            char temp = strs[0].charAt(i);
            for(int j = 1;j < strs.length;j++) {
                if(i == strs[j].length() || strs[j].charAt(i) != temp) {
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
}
