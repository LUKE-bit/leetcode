class Solution {
    public boolean isHappy(int n) {
        int cnt = 0;
        int count = 0;
        while(n!=1 && count < 33) {
            while(n != 0) {
                int num = n % 10;
                cnt+=num * num;
                n /= 10;
            }
            n = cnt;
            count++;
            cnt = 0;
        }
        if(n==1) {
            return true;
        }
        return false;
    }
}


class Solution {
    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }
}

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/happy-number/solution/kuai-le-shu-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
