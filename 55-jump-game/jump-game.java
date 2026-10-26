class Solution {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        return jump(nums, 0, dp);
    }

    public boolean jump(int[] nums, int i, int[] dp){
        if(i >= nums.length - 1) return true;
        if(dp[i] != -1){
            return dp[i] == 0 ? false : true;
        }
        for(int ind = nums[i]; ind >= 1; ind--){
            if(jump(nums, i + ind, dp)){
                dp[i] = 1;
                return true;
            }
        }
        
        dp[i] = 0;
        return false;
        
    }
}