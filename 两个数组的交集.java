class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums1.length;i++) {
            map.put(nums1[i],map.getOrDefault(nums1[i],0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i < nums2.length;i++) {
            if(map.get(nums2[i]) != null) {
                set.add(nums2[i]);
            }
        }
        int[] ans = new int[set.size()];
        Iterator it = set.iterator();
        int i = 0;
        while(it.hasNext()) {
            ans[i++] = (int)it.next();
        }
        return ans;
    }
}
