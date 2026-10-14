class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return helper(k , n, dp);
    }

    public int helper(int k , int n, int[][] dp){
        if(n <= 1) return n;
        if(k == 1) return n;

        if(dp[k][n] != -1) return dp[k][n];
        int min = Integer.MAX_VALUE;

        int low = 1, high = n;
       

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int breaks = helper(k - 1, mid - 1, dp);
            int survives = helper(k, n - mid, dp);

            int worstCase = 1 + Math.max(breaks, survives);
            min = Math.min(min, worstCase);

            if (breaks > survives) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return dp[k][n] = min;
    }
}