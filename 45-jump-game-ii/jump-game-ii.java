class Solution {
    public int jump(int[] nums) {
        int count = 0;
        int i = 0, j = 0;
        while(j < nums.length - 1){
            int max = 0;
            for(int left = i; left <= j; left++){
                max = Math.max(max, left + nums[left]);
            }
            i = j + 1;
            j = max;
            count++;
        }
        return count;
    }
}