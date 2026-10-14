class Solution {
    public int removeDuplicates(int[] nums) {
        int ind = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[ind] != nums[i]){
                ind++;
                nums[ind] = nums[i];
            }
        }
        return ind + 1;
    }
}