class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int max = 0;
        int i = 0;
        for(int j = 0;j < s.length;j++) {
            if(i == g.length) {
                break;
            }
            if(s[j] >= g[i]) {
                max++;
                i++;
            }
        }
        return max;
    }
}
