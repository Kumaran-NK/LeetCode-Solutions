class Solution {
    int findPivot(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        if(target >= nums[pivot] && target <= nums[nums.length - 1]){
            int left = pivot;
            int right = nums.length - 1;
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(nums[mid] == target) return mid;
                else if(nums[mid] < target) left = mid + 1;
                else right = mid - 1;
            }
        }
        else{
            int left = 0;
            int right = pivot -1 ;
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(nums[mid] == target) return mid;
                else if(nums[mid] < target) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }
}