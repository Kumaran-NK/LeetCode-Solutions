class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 3;
        int max = Integer.MAX_VALUE;
        System.out.println(Arrays.toString(nums));
        while(left <= 2){
            max = Math.min(max, nums[right] - nums[left]);
            
            right++;
            left++;
        }
        
        return max;
    }
}