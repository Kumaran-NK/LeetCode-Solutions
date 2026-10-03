class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == val) {
                nums[i] = -1;
                count++;
            }
        }
    
        int len = nums.length - count;
        System.out.println(Arrays.toString(nums) + "\n5");

        for(int i = 0; i < len; i++){
            if(nums[i] < 0){
                int j = i + 1;
                while(j < nums.length){
                    if(nums[j] >= 0){
                        swap(nums, i, j);
                        break;
                    }
                    j++;
                }
            }
            
        }
        System.out.println(Arrays.toString(nums));
        return len;
    }
    public void swap(int[] arr, int val1, int val2){
        int temp = arr[val1];
        arr[val1] = arr[val2];
        arr[val2] = temp;
    }
}