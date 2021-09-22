class Solution {
    public List<String> letterCasePermutation(String s) {
        List<StringBuilder> ans = new ArrayList<>();
        ans.add(new StringBuilder(""));
        for(char c: s.toCharArray()) {
            int n = ans.size();
            if(Character.isLetter(c)) {
                for(int i = 0;i < n;i++) {
                    ans.add(new StringBuilder(ans.get(i)));
                    ans.get(i).append(Character.toLowerCase(c));
                    ans.get(i+n).append(Character.toUpperCase(c));
                }
            }
            else {
                for(int j = 0;j < n;j++) {
                    ans.get(j).append(c);
                }
            }
        }
        List<String> fans = new ArrayList<>();
        for(StringBuilder ss:ans) {
            fans.add(ss.toString());
        }
        return fans;
    }
}
