class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length][k + 1][2];
        for(int[][] arr : dp){
            for(int[] arrr : arr){
                Arrays.fill(arrr, -1);
            }
        }
        return helper(prices, 0, k, 1, dp);
    }
    public int helper(int[] prices, int i, int k, int val, int[][][] dp){
        if(i >= prices.length || k == 0) return 0;

        if(dp[i][k][val] != -1) return dp[i][k][val];
        if(val == 1){
            int buy = -prices[i] + helper(prices, i + 1, k, 0, dp);
            int skip = helper(prices, i + 1, k , 1, dp);

            return dp[i][k][val] =  Math.max(buy, skip);
        }
        else{
            int sell = prices[i] + helper(prices, i + 1, k - 1, 1, dp);
            int skip = helper(prices, i + 1, k, 0, dp);

            return dp[i][k][val] = Math.max(sell, skip);
        }
    }
}