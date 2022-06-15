import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int i = 1;
        int total = 0;
        while(i <= sum / 2){    
            for(int j = i;j < sum;j++) {
                total += j;
                if(total==sum){
                    ArrayList<Integer> ans = new ArrayList<>();
                    for(int k = i;k <= j;k++)
                        ans.add(k);
                    total = 0;
                    res.add(ans);
                    break;
                }else if(total > sum) {
                    total = 0;
                    break;
                }
            }
            i++;
        }
        return res;
    }
}
