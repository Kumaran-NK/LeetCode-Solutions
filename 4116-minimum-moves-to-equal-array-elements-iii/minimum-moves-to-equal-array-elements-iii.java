class Solution {
    public int minMoves(int[] nums) {
        int max = 0;
        for(int i : nums){
            max = Math.max(max, i);
        }

        int result = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == max){
                continue;
            }
            int val = nums[i];
            while(val != max){
                result++;
                val++;
            }
        }
        return result;
    }
}