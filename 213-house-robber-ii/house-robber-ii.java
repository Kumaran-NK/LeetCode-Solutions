class Solution {
    public int rob(int[] nums) {
        int[][] dp = new int[nums.length + 1][2];

        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        
        return robbing(nums, 0, dp, false);
    }

    public int robbing(int[] nums, int i,int[][] dp, boolean flag){
        if(i == nums.length - 1 && flag) return 0;
        if(i >= nums.length) return 0;

        int start;
        if(flag){
            start = 0;
        }
        else{
            start = 1;
        }

        if(dp[i][start] != -1) return dp[i][start];

        int rob;
        if(i == 0){
          rob = nums[i] + robbing(nums, i + 2, dp, true);
        }
        else{
           rob = nums[i] + robbing(nums, i + 2, dp,flag);
        }
        
        
        int skip = robbing(nums, i + 1,dp, flag);
        
        

        dp[i][start] = Math.max(rob, skip);

        return dp[i][start];
    }
}