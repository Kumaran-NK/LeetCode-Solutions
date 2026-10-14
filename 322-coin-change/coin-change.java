class Solution {
    public int coinChange(int[] coins, int amount) {

        int[][] dp = new int[coins.length + 1][amount + 1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        int val = helper(coins, 0, amount, dp);
        return val >= Integer.MAX_VALUE / 2 ? -1 : val;
    }
    public int helper(int[] coins, int i, int amount, int[][] dp){
        
        if(amount == 0) return 0;
        if(i >= coins.length) return Integer.MAX_VALUE / 2;
        
        if(dp[i][amount] != -1) return dp[i][amount];
        int take = Integer.MAX_VALUE / 2;
        if(coins[i] <= amount)
        take = 1 + helper(coins, i, amount - coins[i], dp);

        int skip = helper(coins, i + 1, amount, dp);

        return dp[i][amount] = Math.min(take, skip);
    }
}