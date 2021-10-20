class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length(),m = p.length();
        int[] sCnt = new int[26];
        int[] pCnt = new int[26];
        List ans = new ArrayList();
        for(int i = 0;i < m;i++) {
            pCnt[p.charAt(i) - 'a']++;
        }
        int left = 0;
        for(int right = 0;right < n;right++) {
            int curRight = s.charAt(right) - 'a';
            sCnt[curRight]++;
            while(sCnt[curRight] > pCnt[curRight]) {
                int curLeft = s.charAt(left) - 'a';
                sCnt[curLeft]--;
                left++;
            }
            if(right - left + 1 == m) {
                ans.add(left);
            }
        }
        return ans;
    }
}
