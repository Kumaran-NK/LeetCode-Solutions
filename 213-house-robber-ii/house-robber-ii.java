class Solution {
    public int rob(int[] nums) {
        int[][] dp = new int[nums.length + 1][2];
        for(int[] arr : dp){
            Arrays.fill(arr, - 1);
        }
        return robbing(nums, 0 , false, dp);
    }

    public int robbing(int[] nums, int i , boolean flag, int[][] dp){
        if(i >= nums.length) return 0;
        if(i == nums.length - 1 && flag) return 0;
        
        int state;
        if(flag){
            state = 0;
        }
        else{
            state = 1;
        }

        if(dp[i][state] != -1){
            return dp[i][state];
        }
        
        int robb;
        if(i == 0){
            robb = nums[i] + robbing(nums, i + 2, true, dp);
        }
        else{
            robb = nums[i] + robbing(nums, i + 2, flag, dp);
        }
        

        int skip = robbing(nums, i + 1, flag, dp);

        dp[i][state] = Math.max(robb, skip);
        return dp[i][state];
    }
}