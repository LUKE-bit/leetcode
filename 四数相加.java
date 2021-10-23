class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums1.length;i++) {
            for(int j = 0;j < nums2.length;j++) {
                int temp = nums1[i] + nums2[j];
                map.put(temp,map.getOrDefault(temp,0) + 1);
            }
        }
        int count = 0;
        for(int i = 0;i < nums3.length;i++) {
            for(int j = 0;j < nums4.length;j++) {
                int ans = -(nums3[i] + nums4[j]);
                if(map.containsKey(ans)) {
                    count+=map.get(ans);
                }
            }
        }
        return count;
    }
}
