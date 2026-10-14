class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;
        int[][] dp = new int[arr.length][arr.length];
        for(int[] val : dp){
            Arrays.fill(val, -1);
        }
        for(int i = 1; i <= n; i++){
            arr[i] = nums[i - 1];
        } 
        return helper(arr, 0, arr.length - 1, dp);
    }
    public int helper(int[] nums ,int left, int right, int[][] dp){
        if(left + 1 == right) return 0;
        if(dp[left][right] != -1) return dp[left][right];
        int max = 0;
        for(int i = left + 1; i < right; i++){
            max = Math.max(helper(nums, left, i, dp) + helper(nums, i, right, dp) + nums[i] * nums[left] * nums[right], max);
        }

        return dp[left][right] = max;
    }
}