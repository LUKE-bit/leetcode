class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int profit = 0;
        int buy = prices[0] + fee;
        for(int i = 1;i < n;i++) {
            if(prices[i] + fee < buy) {
                buy = prices[i] + fee;
            }else if(prices[i] > buy) {
                profit += prices[i] - buy;
                buy = prices[i];
            }
        }
        return profit;
    }
}
