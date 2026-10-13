class Solution {
    public int coinChange(int[] coins, int amount) {
        long[][] dp = new long[coins.length][amount + 1];
        for(long[] arr : dp){
            Arrays.fill(arr, -1);
        }
        

        long val = combine(coins, coins.length - 1, amount, dp);
        return val>=Integer.MAX_VALUE ? -1 : (int)val;
    }

    public long combine(int[] coins, int i, int amount, long[][] dp){
        if(i < 0){
            return amount==0 ? 0 : Integer.MAX_VALUE;
        }

        if(dp[i][amount] != -1) return dp[i][amount];
        
        long include = Integer.MAX_VALUE;
        if(coins[i] <= amount)
        include = 1 + combine(coins, i, amount - coins[i], dp);

        long exclude =  combine(coins, i - 1, amount, dp);
        
        dp[i][amount] = Math.min(include, exclude);
        return dp[i][amount];
    }
}