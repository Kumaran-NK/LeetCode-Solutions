class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] arr : dp){
            Arrays.fill(arr, - 1);
        }
        return travelling(0, 0, m, n, dp);
    }

    public int travelling(int i, int j, int m, int n, int[][] dp){

        if(i == m - 1 && j == n - 1) return 1;
        if(i >= m) return 0;
        if(j >= n) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        int down =  travelling(i + 1, j, m , n, dp);
        int right =  travelling(i, j + 1, m, n, dp);

        return dp[i][j] = down + right;

    }
}