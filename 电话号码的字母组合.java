class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits == null || digits.length() == 0) {
            return ans;
        }
        String[] strings = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        StringBuilder sb = new StringBuilder("");
        backTracking(digits,strings,0,ans,sb);
        return ans;
    }
    public void backTracking(String digits,String[] strings,int beginI,List<String> ans,StringBuilder sb) {
        if(beginI == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        
        int num = Integer.parseInt(String.valueOf(digits.charAt(beginI)));
        String tar = strings[num - 2];
        for(int j = 0;j < tar.length();j++) {
            sb.append(tar.charAt(j));
            beginI+=1;
            backTracking(digits,strings,beginI,ans,sb);
            beginI-=1;
            sb.deleteCharAt(sb.length() - 1);
        }   
        
    }
}
