class Solution {
    public int trap(int[] height) {
        //双指针法,按列计算,这样水柱的宽度默认为1,所以只需计算计算高度即可
        int sum = 0;
        for(int i = 0;i < height.length;i++) {
            if(i == 0 || i == height.length - 1) continue;//左边第一个柱子和右边第一个不接雨水
            int lheight = height[i];
            int rheight = height[i];
            for(int j = i + 1;j < height.length;j++) {
                if(height[j] > rheight) rheight = height[j];
            }
            for(int j = i - 1;j >= 0;j--) {
                if(height[j] > lheight) lheight = height[j];
            }
            int count = Math.min(lheight,rheight) - height[i];
            if(count > 0) sum += count;
        }
        return sum;
    }
}

//动态规划优化,因为有大量重复调用
class Solution {
    public int trap(int[] height) {
        int length = height.length;
        if (length <= 2) return 0;
        int[] maxLeft = new int[length];
        int[] maxRight = new int[length];
        
        // 记录每个柱子左边柱子最大高度
        maxLeft[0] = height[0];
        for (int i = 1; i< length; i++) maxLeft[i] = Math.max(height[i], maxLeft[i-1]);
        
        // 记录每个柱子右边柱子最大高度
        maxRight[length - 1] = height[length - 1];
        for(int i = length - 2; i >= 0; i--) maxRight[i] = Math.max(height[i], maxRight[i+1]);
        
        // 求和
        int sum = 0;
        for (int i = 0; i < length; i++) {
            int count = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (count > 0) sum += count;
        }
        return sum;
    }
}

//单调栈解法
class Solution {
    public int trap(int[] height) {
        //本题可以使用单调栈来解,按照行方向来计算雨水
        Stack<Integer> stack = new Stack<>();//存放下标
        //栈顶到栈底从小到大,因为遇到大的元素形成凹槽
        stack.push(0);
        int sum = 0;
        for(int i = 1;i < height.length;i++) {
            while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int mid = stack.pop();
                if(!stack.isEmpty()) {
                    int h = Math.min(height[stack.peek()],height[i]) - height[mid];
                    int w = i - stack.peek() - 1;
                    sum += h * w;
                }
            }
            stack.push(i);
        }
        return sum;
    }
}
