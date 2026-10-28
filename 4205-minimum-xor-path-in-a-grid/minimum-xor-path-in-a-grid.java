class Solution {
    public int minCost(int[][] grid) {
        int[][][] dp = new int[grid.length][grid[0].length][1500];
        for(int[][] arr1 : dp){
            for(int[] arr2: arr1){
                Arrays.fill(arr2, -1);
            }
        }

        return helper(grid, 0, 0, 0, dp);
    }

    public int helper(int[][] grid, int i , int j, int val, int[][][] dp){

        if(i >= grid.length || j >= grid[0].length){
            return Integer.MAX_VALUE;
        }

        if(dp[i][j][val] != -1){
            return dp[i][j][val];
        }

        int newVal = val ^ grid[i][j];

        if(i == grid.length - 1 && j == grid[0].length - 1){
            return newVal;
        }
        

        int right = helper(grid, i, j + 1, newVal, dp);
        int down = helper(grid, i + 1, j, newVal, dp);

        return dp[i][j][val] = Math.min(right, down);

    }
}