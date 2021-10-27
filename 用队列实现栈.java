//自己写的垃圾代码
class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;
    public MyStack() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        q1.offer(x);
    }
    
    public int pop() {
        if(!q1.isEmpty()) {
            while(q1.size() > 1) {
                q2.offer(q1.poll());
            }
        }else {
            return -1;
        }
        int ans = q1.poll();
        Queue<Integer> queueTemp;
        queueTemp = q1;
        q1 = q2;
        q2 = queueTemp;
        while(!q2.isEmpty()) {
            q2.poll();
        }
        return ans;
    }
    
    public int top() {
        if(!q1.isEmpty()) {
            while(q1.size() != 1) {
                q2.offer(q1.poll());
            }
        }
        int ans = q1.poll();
        q2.offer(ans);
        Queue<Integer> queueTemp;
        queueTemp = q1;
        q1 = q2;
        q2 = queueTemp;
        while(!q2.isEmpty()) {
            q2.poll();
        }
        return ans;
    }
    
    public boolean empty() {
        if(q1.isEmpty()) {
            return true;
        }else {
            return false;
        }
    }
}

//官方一个队列的优化
class MyStack {
    Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        int n = queue.size();
        queue.offer(x);
        for (int i = 0; i < n; i++) {
            queue.offer(queue.poll());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return queue.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/implement-stack-using-queues/solution/yong-dui-lie-shi-xian-zhan-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
