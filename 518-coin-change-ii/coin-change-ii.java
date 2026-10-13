class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        // Base case: amount 0 can always be formed in one way
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int amt = 1; amt <= amount; amt++) {

                // Exclude the current coin
                int exclude = dp[i - 1][amt];

                // Include the current coin (unlimited usage)
                int include = 0;
                if (amt >= coins[i - 1]) {
                    include = dp[i][amt - coins[i - 1]];
                }

                dp[i][amt] = include + exclude;
            }
        }

        return dp[n][amount];
    }

    // public int func(int[] coins, int amount, int i, int[][] dp){

    //     if(i < 0 || amount < 0) return 0;
    //     if(amount == 0) return 1;

    //     if(dp[i][amount] != -1) return dp[i][amount];
        
    //     int include = func(coins, amount - coins[i], i, dp);
    //     int exclude = func(coins, amount, i - 1, dp);

    //     dp[i][amount] = include + exclude;
    //     return dp[i][amount];
    // }
}