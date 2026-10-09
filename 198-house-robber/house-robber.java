class Solution {
    
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, - 1);
        return robbing(nums, dp, 0);
        
         
    }

    
    public int robbing(int[] nums, int[] dp, int i){
        if(i >= nums.length) return 0;

        if(dp[i] != -1){
            return dp[i];
        }
        int nonAdj = nums[i] + robbing(nums,dp, i + 2);
        int adj = robbing(nums, dp,  i + 1);

        dp[i] = Math.max(nonAdj, adj);
        return dp[i];
        
    }
}