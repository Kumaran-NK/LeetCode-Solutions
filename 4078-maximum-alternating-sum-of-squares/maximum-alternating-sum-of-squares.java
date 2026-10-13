class Solution {
    public long maxAlternatingSum(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        long n = nums.length / 2;
        long sum = 0;
        for(int i = 0; i < nums.length; i++){
            long val = Math.abs(nums[i]);
            long sqr = val * val;

            if(i < n){
                sum -= sqr;
            }
            else{
                sum += sqr;
            }
        }

        return sum;
    }
}