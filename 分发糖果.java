class Solution {
    public int candy(int[] ratings) {
        int[] candyNum = new int[ratings.length];
        Arrays.fill(candyNum,1);
        int count = 0;
        for(int i = 1;i < ratings.length;i++) {
            if(ratings[i] > ratings[i - 1]) {
                candyNum[i] = candyNum[i - 1] + 1;
            }
        }
        for(int i = ratings.length - 2;i >= 0;i--) {
            if(ratings[i] > ratings[i + 1]) {
                candyNum[i] = Math.max(candyNum[i],candyNum[i + 1] + 1);
            }
        }
        for(int i = 0;i < ratings.length;i++) {
            count += candyNum[i];
        }
        return count;
    }
}
