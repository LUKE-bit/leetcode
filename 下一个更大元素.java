class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums1.length];
        Arrays.fill(res,-1);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums1.length;i++) {
            map.put(nums1[i],i);
        }
        for(int j = 0;j < nums2.length;j++) {
            while(!stack.isEmpty() && nums2[j] > nums2[stack.peek()]) {
                if(map.containsKey(nums2[stack.peek()])) {
                    int index = map.get(nums2[stack.peek()]);//找到nums2这个元素在nums1的下标
                    res[index] = nums2[j];
                }
                stack.pop();
            }
            stack.push(j);
        }
        return res;
    }
}
