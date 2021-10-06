public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        for(int i = 0;i < 32;i++) {
            int ans = (n>>>i) & 1;
            if(ans==1) {
                res++;
            }
        }
        return res;
    }
}