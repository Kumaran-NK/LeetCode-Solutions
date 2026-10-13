class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return Arunsamy(coins, amount, coins.length - 1, dp);
    }

    public int Arunsamy(int[] coins, int amount, int i, int[][] dp){

        if(i < 0 || amount < 0) return 0;
        if(amount == 0) return 1;

        if(dp[i][amount] != -1) return dp[i][amount];
        
        int include = Arunsamy(coins, amount - coins[i], i, dp);
        int exclude = Arunsamy(coins, amount, i - 1, dp);

        dp[i][amount] = include + exclude;
        return dp[i][amount];
    }
}