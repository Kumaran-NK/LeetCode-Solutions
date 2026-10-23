class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int count = 0;
        int max = 0;
        int j = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[j]){
                j++;
                continue;
            }
            else if(nums[j] + 1 == nums[i]){
                count++;
                max = Math.max(max, count);
                j++;
            }
            else{
                count = 0;
                j++;
            }
        }
        return max + 1;
    }
}