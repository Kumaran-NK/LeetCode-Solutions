class Solution {
    public int sortPermutation(int[] nums) {
        int val = Integer.MAX_VALUE;
        for(int i = 1;  i < nums.length; i++){
            if(nums[i] != i){
                val &= nums[i];
            }
        }
        return val == Integer.MAX_VALUE ? 0 : val;
    }
}