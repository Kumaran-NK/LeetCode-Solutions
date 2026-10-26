class Solution {

    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return helper(nums, 0, dp);
    }

    public int helper(int[] nums, int i, int[] dp){
        if(i == nums.length - 1) return 0;
        if(dp[i] != -1) return dp[i];

        int val = Integer.MAX_VALUE;
        for(int j = nums[i]; j >= 1; j--){
            if(i + j < nums.length){
                int res = helper(nums, i + j, dp);
                if(res != Integer.MAX_VALUE)
                    val = Math.min(val,1 + res);
            }
        }

        return dp[i] = val;
    }
}