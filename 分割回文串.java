class Solution {
    List<List<String>> ans = new ArrayList<>();
    List<String> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        List<String> res = new ArrayList<>();
        backTracking(s,0);
        return ans;
    }
    public void backTracking(String s,int beginI) {
        if(beginI >= s.length()) {
            ans.add(new ArrayList<>(res));
            return;
        }
        for(int i = beginI;i < s.length();i++) {
            if(isHuiWen(s,beginI,i)) {
                String str = s.substring(beginI,i+1);
                res.add(str);
            }else {
                continue;
            }
            backTracking(s,i+1);
            res.remove(res.size() - 1);
        }
    }
    public boolean isHuiWen(String s,int start,int end) {
        boolean flag = true;
        while(start < end) {
            if(s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
                continue;
            }else {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
