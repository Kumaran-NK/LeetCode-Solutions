class Solution {
    public boolean canJump(int[] nums) {
        int maxInd = 0;
        for(int i = 0; i < nums.length; i++){
            if(i > maxInd) return false;
            maxInd = Math.max(maxInd, i + nums[i]);
        }   
        return true;
    }
}


// 2 3 1 1 4
// 0 1 2 3 4

// 0 > 0 false max = 0 + 2 = 2
// 1 > 2 false max = 2 + 3 = 5
// 2 > 5 false max = 5 + 1 = 6
// 3 > 6 false max = 6 + 1 = 7
// 4 > 7 false max = 7 + 4 = 11

// True

// 3 2 1 0 4
// 0 1 2 3 4

// 0 > 0 3
// 1 > 3 5
// 2 > 5 6
// 3 > 6 6
// 4 > 


