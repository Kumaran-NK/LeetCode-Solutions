class Solution {
    public int[] singleNumber(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();

        int i = 0;
        while(i < nums.length){
            if(i + 1 >= nums.length){
                list.add(nums[i]);
                break;
            } 
            if(nums[i] != nums[i + 1]){
                list.add(nums[i]);
                i++;
            }
            else{
                i += 2;
            }
        }

        int[] arr = new int[list.size()];
        for(int j = 0; j < list.size(); j++){
            arr[j] = list.get(j);
        }

        return arr;
    }
}