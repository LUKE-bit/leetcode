class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if(s.length() > 12) {
            return ans;
        }
        backTracking(s,0,0);
        return ans;
    }
    public void backTracking(String s,int beginI,int pointNum) {
        if(pointNum == 3) {
            if(isValid(s,beginI,s.length() - 1)) {
                ans.add(s);
            }
        }
        for(int i = beginI;i < s.length();i++) {
            if(isValid(s,beginI,i)) {
                s = s.substring(0,i + 1) + "." + s.substring(i + 1);
                pointNum++;
                backTracking(s,i+2,pointNum);
                s = s.substring(0,i + 1) + s.substring(i + 2);
                pointNum--;
            }else {
                break;
            }
        }
    }
    public boolean isValid(String s,int start,int end) {
        if(start > end) {
            return false;
        }
        if(s.charAt(start) == '0' && start != end) {
            return false;
        }
        int num = 0;
        for(int i = start;i <= end;i++) {
            if(s.charAt(i) > '9' || s.charAt(i) < '0') {
                return false;
            }
            num = num * 10 + s.charAt(i) - '0';
            if(num > 255) {
                return false;
            }
        }
        return true;
    }
}
