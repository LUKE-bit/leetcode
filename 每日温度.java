class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //找任一元素左边或右边第一个比自己大或小的元素的位置,我们可以用单调栈来实现,
        //时间复杂度为O(n),以空间换时间,当然暴力两层for也行,O(n^2)
        //使用单调栈需要明确三个概念,第一:单调栈里存什么,这里存放元素的下标.
        //第二:单调栈里顺序如何,本题必须从栈顶到栈底递增,因为只有这样我们才能知道加入元素i,栈顶元素在数组中右边第一个比它大的元素是i
        //使用单调栈主要有三个判断条件:当前元素比栈顶元素大,相等,小
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for(int i = 0;i < temperatures.length;i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                res[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
}
