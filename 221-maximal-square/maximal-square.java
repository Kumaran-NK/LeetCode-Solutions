class Solution {
    int max = 0;

    public int maximalSquare(char[][] matrix) {
        

        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        helper(matrix, matrix.length - 1, matrix[0].length - 1, dp);
        return max;
    }

    public int helper(char[][] matrix, int i, int j, int[][] dp) {
        if (i < 0 || j < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int up = helper(matrix, i - 1, j, dp);
        int left = helper(matrix, i, j - 1, dp);
        int diagonal = helper(matrix, i - 1, j - 1, dp);

        int val = 0;

        if (matrix[i][j] == '1') {
            

            val = 1 + Math.min(up, Math.min(left, diagonal));
        }

        max = Math.max(max, val * val);
        dp[i][j] = val;
        return val;
    }
}