class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int i : nums) total += i;

        if(total % 2 != 0) return false;
        int[][] dp = new int[nums.length][(total / 2) + 1];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        return helper(nums, 0, total / 2, dp);
    }

    public boolean helper(int[] nums, int i, int total, int[][] dp){
        if(i >= nums.length) return false;
        if(total == 0) return true;
        if(total < 0) return false;
        if(dp[i][total] != -1){
            if(dp[i][total] == 0) return false;
            else return true;
        }
        boolean take = helper(nums, i + 1, total - nums[i], dp);
        boolean skip = helper(nums, i + 1, total, dp);

        boolean val = take || skip;
        if(val) dp[i][total] = 1;
        else dp[i][total] = 0;

        return val;
    }
}