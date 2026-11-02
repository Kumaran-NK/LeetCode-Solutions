class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int val = 0;
        if(n % 2 == 0){
            val = (nums[n/2 - 1] + nums[n / 2])/2;
        }
        else{
            val = nums[n / 2];
        }

        int result = 0;
        for(int i : nums){
            result += Math.abs(i - val);
        }
        return result;
    }
}