class Solution {
    
    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            max = Math.max(max, num);
        }

        int[] points = new int[max + 1];
        
        for(int num : nums){
            points[num] += num;
        }

        int[] dp = new int[max + 1];
        Arrays.fill(dp, -1);

        return deleting(points, max, dp);
        
    }
    public int deleting(int[] points, int i,  int[] dp){
       if(i < 0) return 0;

        if(dp[i] != -1){
            return dp[i];
        }
       int pick = points[i] + deleting(points, i - 2, dp);
       int skip = deleting(points, i - 1, dp);

       dp[i] = Math.max(pick, skip);
       return dp[i];
    }
}