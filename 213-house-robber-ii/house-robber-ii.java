class Solution {
    public int rob(int[] nums) {
        int[][] dp = new int[nums.length + 1][2];
        
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return helper(nums, 0, dp, false);
    }

    public int helper(int[] nums, int i, int[][] dp, boolean flag){
        if(i >= nums.length) return 0;
        if(i == nums.length - 1 && flag) return 0; 

        int state = flag ? 0 : 1;
        if(dp[i][state] != -1) return dp[i][state];

        

        int take;
        if(i == 0){
            take = nums[i] + helper(nums, i + 2, dp, true);
        }
        else{
            take = nums[i] + helper(nums, i + 2, dp, flag);
        }
        
        int skip = helper(nums, i + 1, dp, flag);

        return dp[i][state] = Math.max(take, skip);
    }
}