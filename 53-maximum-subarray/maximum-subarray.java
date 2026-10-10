class Solution {
    
    public int maxSubArray(int[] nums) {
       int max = Integer.MIN_VALUE;
       int[] dp = new int[nums.length + 1];
       Arrays.fill(dp, -1);
       for(int i = 0; i < nums.length; i++){
            max = Math.max(max, helper(nums, i, dp));
       }
       return max;
    }

    public int helper(int[] nums, int i, int[] dp){
        if(i >= nums.length) return 0;
        if(dp[i] != -1) return dp[i];
        
        dp[i] = nums[i] + Math.max(0, helper(nums, i + 1, dp));
        return dp[i];
    }
}