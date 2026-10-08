class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        Arrays.fill(dp, -1);
        int val1 = climbing(cost, dp, 0);
        int val2 = climbing(cost, dp, 1);

        System.out.println(Arrays.toString(dp) + " " + val1 + " " + val2);
        return Math.min(val1, val2);
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