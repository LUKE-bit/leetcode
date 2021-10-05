class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet set = new HashSet();
        int left = 0,right = -1;
        int ans = 0;
        for(;left < s.length();left++) {
            if(left!=0) {
                set.remove(s.charAt(left-1));
            }
            while(right < s.length()-1 && !set.contains(s.charAt(right+1))) {
                set.add(s.charAt(right+1));
                right++;
            }
            ans = Math.max(ans,right-left + 1);
        }
        return ans;
    }
}
//判断字符是否重复用HashSet
