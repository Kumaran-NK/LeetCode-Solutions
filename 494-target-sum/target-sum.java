class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, 0, target);
    }

    public int helper(int[] nums, int i, int target){
        if(i >= nums.length) return target == 0 ? 1 : 0;

        int add = helper(nums, i + 1, target + nums[i]);
        int sub = helper(nums, i + 1, target - nums[i]);

        return add + sub;
    }
}