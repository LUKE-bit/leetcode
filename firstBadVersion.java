/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int t = -1,left = 1,right = n;
        int ans = -1;
        while(left<=right) {
            t = left + (right-left)/2;
            if(isBadVersion(t) == false) {
                left = t + 1;
            }else{
                right = t - 1;
                ans = t;
            }
        }
        return ans;
    }
}
