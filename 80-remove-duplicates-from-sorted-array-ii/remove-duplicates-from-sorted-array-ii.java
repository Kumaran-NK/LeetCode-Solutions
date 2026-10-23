
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;

        int seq = 1;
        int j = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                seq++;
            } else {
                seq = 1;
            }

            if (seq <= 2) {
                nums[j] = nums[i];
                j++;
            }
        }

        return j;
    }
}
