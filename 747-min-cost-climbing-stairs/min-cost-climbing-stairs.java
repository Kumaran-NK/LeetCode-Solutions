class Solution {
    int sum = 0;
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        Arrays.fill(dp, -1);
        return Math.min(climbing(cost, dp, 0), climbing(cost,dp, 1));
    }
    public int climbing(int[] cost,int[] dp, int i){
        if(i >= cost.length){
            return 0;
        }
        
        if(dp[i] != -1){
            return dp[i];
        }

        int firstStep = climbing(cost, dp,i + 1);
        int secondStep = climbing(cost,dp, i + 2);

        dp[i] = cost[i] + Math.min(firstStep, secondStep);
        return dp[i];
    }
}