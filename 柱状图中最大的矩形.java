class Solution {
    public int largestRectangleArea(int[] heights) {
        //双指针法,直接循环去找左右第一个小于height[i]的下标会超时,时间复杂度为O(n^2)
        //使用动态规划,保留左右第一个..的下标
        int size = heights.length;
        int[] minLeftIndex = new int[heights.length];
        minLeftIndex[0] = -1;//初始化,避免下面死循环
        for(int i = 1;i < size;i++) {
            int t = i - 1;
            while(t >= 0 && heights[t] >= heights[i]) t = minLeftIndex[t];
            minLeftIndex[i] = t; 
        }
        int[] minRightIndex = new int[heights.length];
        minRightIndex[size - 1] = size;
        for(int i = size - 2;i >= 0;i--) {
            int t = i + 1;
            while(t < size && heights[t] >= heights[i]) t = minRightIndex[t];
            minRightIndex[i] = t;
        }
        int res = 0;
        for(int i = 0;i < size;i++) {
            int sum = (minRightIndex[i] - minLeftIndex[i] - 1) * heights[i];
            res = Math.max(sum,res);
        }
        return res;
    }
}

//单调栈
class Solution {
    public int largestRectangleArea(int[] heights) {
        //单调栈,和接雨水类似,只不过这个是找两边第一个小于height[i]的,所以单调栈的
        //顺序是栈顶到栈底从大到小
        Stack<Integer> stack = new Stack<>();
        int[] newHeights = new int[heights.length + 2];//扩容,为了不漏掉两边的柱子
        newHeights[0] = 0;newHeights[heights.length + 1] = 0;
        for(int i = 0;i < heights.length;i++) {
            newHeights[i + 1] = heights[i];
        }
        heights = newHeights;
        stack.push(0);
        int res = 0;
        for(int i = 1;i < heights.length;i++) {
            if(heights[i] > heights[stack.peek()]) {
                stack.push(i);
            }else if(heights[i] == heights[stack.peek()]) {
                stack.pop();
                stack.push(i);
            }else {
                while(heights[i] < heights[stack.peek()]) {
                    int mid = stack.pop();
                    int left = stack.peek();
                    int w = i - left - 1;
                    res = Math.max(res,w * heights[mid]);
                }
                stack.push(i);
            }
        }
        return res;
    }
}
