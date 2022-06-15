public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if(index <= 6) return index;
        int[] res = new int[index];
        res[0] = 1;
        int i2 = 0,i3 = 0,i5 = 0;
        for(int i = 1;i < index;i++){
            res[i] = Math.min(res[i2] * 2,Math.min(res[i3] * 3,res[i5] * 5));
            if(res[i] == res[i2] * 2){
                i2++;
            }
            if(res[i] == res[i3] * 3){
                i3++;
            }
            if(res[i] == res[i5] * 5){
                i5++;
            }
        }
        return res[index - 1];
    }
}
//小顶堆
import java.util.*;
public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if(index == 0) return 0;
        int[] factors = new int[]{2,3,5};
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashMap<Long,Integer> map = new HashMap<>();
        map.put(1L,1);
        pq.offer(1L);
        long res = 0;
        for(int i = 0;i < index;i++) {
            res = pq.poll();
            for(int j = 0;j < 3;j++) {
                long next = res * factors[j];
                if(!map.containsKey(next)){
                    map.put(next,1);
                    pq.offer(next);
                }
            }
        }
        return (int)res;
    }
}
