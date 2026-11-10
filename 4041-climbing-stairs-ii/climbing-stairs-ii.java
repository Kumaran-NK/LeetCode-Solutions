class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(n, costs, dp);
    }
    public int helper(int n, int[] costs, int[] dp){

        if(n == 0) return 0;
        if(dp[n] != -1) return dp[n];
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE, third = Integer.MAX_VALUE;
        if(n >= 1){
            first = helper(n - 1, costs, dp) + costs[n - 1] + 1;
        }

        if(n >= 2){
            second = helper(n - 2, costs, dp) + costs[n - 1] + 4;
        }

        if(n >= 3){
            third = helper(n - 3, costs, dp) + costs[n - 1] + 9;
        }

        return dp[n] = Math.min(first, Math.min(second, third));

    }
}