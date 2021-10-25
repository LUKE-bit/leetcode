class Solution {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder("");
        char[] ans = s.toCharArray();
        for(int i = 0;i < ans.length;i++) {
            if(ans[i] != ' ') {
                sb.append(ans[i]);
            }else {
                sb.append("%20");
            }
        }
        return String.valueOf(sb);
    }
}
