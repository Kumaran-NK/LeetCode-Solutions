class Solution {
    public int searchInsert(int[] nums, int target) {
        int val = Arrays.binarySearch(nums, target);
        return val < 0 ? Math.abs(val) -1 : val;
    }
}