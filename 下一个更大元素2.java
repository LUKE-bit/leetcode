class Solution {
    public int[] nextGreaterElements(int[] nums) {
        //寻找下一个更大元素，想到可以用单调栈来实现，右边找更大，所以单调栈顺序栈顶到
        //栈底从小到大
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res,-1);
        for(int i = 0;i < nums.length * 2;i++) {
            while(!stack.isEmpty() && nums[i % nums.length] > nums[stack.peek()]) {
                res[stack.peek()] = nums[i % nums.length];
                stack.pop();
            }
            stack.push(i % nums.length);
        }
        return res;
    }
}
