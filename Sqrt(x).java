class Solution {
    public int mySqrt(int x) {
        int left = 0,right = x;
        int ans = -1;
        while(left <= right) {
            int middle = left + (right-left)/2;
            if((long)middle * middle <= x) {
                ans = middle;
                left = middle + 1;
            }else {
                right = middle - 1;
            }
        }
        return ans;
    }
}
