// 在地下室里放着n种颜色的手套，手套分左右手，但是每种颜色的左右手手套个数不一定相同。A先生现在要出门，所以他要去地下室选手套。但是昏暗的灯光让他无法分辨手套的颜色，只能分辨出左右手。所以他会多拿一些手套，然后选出一双颜色相同的左右手手套。现在的问题是，他至少要拿多少只手套(左手加右手)，才能保证一定能选出一双颜色相同的手套。

// 给定颜色种数n(1≤n≤13),同时给定两个长度为n的数组left,right,分别代表每种颜色左右手手套的数量。数据保证左右的手套总数均不超过26，且一定存在至少一种合法方案。
import java.util.*;

public class Gloves {
    public int findMinimum(int n, int[] left, int[] right) {
        //覆盖问题，贪心，一边拿完，另一边拿一个即可，但是是至少，所以只要覆盖所有颜色的最少再加上另一边的1个即可
        // 即sum - min + 1是一边的最少，左边右边找一个最小的即可，但要注意有一边为0，要把左右两边都加上，不然
        //可能被它破坏整个计划,
        int leftSum = 0,rightSum = 0;
        int leftMin = Integer.MAX_VALUE,rightMin = Integer.MAX_VALUE;
        int sumZero = 0;
        for(int i = 0;i < n;i++) {
            if(left[i] * right[i] == 0) {
                sumZero += left[i] + right[i];
            }else{
                leftSum += left[i];
                leftMin = Math.min(left[i],leftMin);
                rightSum += right[i];
                rightMin = Math.min(right[i],rightMin);
            }
        }
        return sumZero + Math.min(leftSum - leftMin + 1,rightSum - rightMin + 1) + 1;
    }
}
