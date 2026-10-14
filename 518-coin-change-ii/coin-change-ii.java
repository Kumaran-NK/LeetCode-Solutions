class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return helper(coins, 0, amount, dp);
    }

    public int helper(int[] coins, int i, int amount, int[][] dp){
        if(i >= coins.length) return 0;
        if(amount == 0) return 1;
        if(dp[i][amount] != -1) return dp[i][amount];
        int take = 0;
        if(coins[i] <= amount){
            take = helper(coins, i, amount - coins[i], dp);
        }

        int skip = helper(coins, i + 1, amount, dp);

        return dp[i][amount] = take + skip;
    }
}