class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        Arrays.fill(dp, -1);
        return Math.min(climbing(cost, 0, dp), climbing(cost, 1, dp));
    }

    public int climbing(int[] cost, int i, int[] dp){
        if(i >= cost.length) return 0;

        if(dp[i] != -1) return dp[i];
        int twoStep = climbing(cost, i + 2, dp);
        int oneStep = climbing(cost, i + 1, dp);

        dp[i] = cost[i] + Math.min(twoStep, oneStep);
        return dp[i];
    }
}