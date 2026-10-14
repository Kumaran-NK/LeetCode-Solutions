class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        double max = -Double.MAX_VALUE;
        int i = 0;
        while(i + k <= nums.length){
            int sum = 0;
            for(int j = i; j < i + k; j++){
                sum += nums[j];
            }

            max = Math.max(max, (double) sum / k);
            i++;

        }
        return max;
    }
}