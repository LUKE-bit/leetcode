class Solution {
    public int jump(int[] nums) {
        int curDistance = 0;//当前一步最大下标
        int nextDistance = 0;//下一步的最大下标
        int count = 0;
        for(int i = 0;i < nums.length - 1;i++) { //关键，到nums.length - 2位置
            nextDistance = Math.max(i + nums[i],nextDistance);
            if(i == curDistance) {
                count++;
                curDistance = nextDistance;
            }
        }
        return count;
    }
}
