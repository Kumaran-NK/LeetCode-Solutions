class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return travelling(obstacleGrid, 0, 0, dp);
    }

    public int travelling(int[][] grid, int i, int j, int[][] dp){

       
        
        if(i >= grid.length || j >= grid[0].length) return 0;
         if(grid[i][j] == 1) return 0;
         if(i == grid.length - 1 && j == grid[0].length - 1) return 1;
        
        if(dp[i][j] != -1) return dp[i][j];
        int down = travelling(grid, i + 1, j, dp);
        int right = travelling(grid, i, j + 1, dp);

        return dp[i][j] = down + right;
    } 
}