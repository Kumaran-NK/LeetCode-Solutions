class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int i = 0;
        while(i < nums.length){
            if(i + 2 >= nums.length) break;
            if(nums[i] != nums[i + 2]) return nums[i];

            i += 3;
        }
        return nums[nums.length - 1];
    }
}