class Solution {
    
    public int countIslands(int[][] grid, int k) {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] > 0){
                    long sum = dfs(grid, i, j);
                    if(sum % k == 0) count++;
                }
            }
            
        }
        return count;
    }

    public long dfs(int[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return 0;
        }

        if(grid[i][j] == 0){
            return 0;
        }

        long val = grid[i][j];

        grid[i][j] = 0;

        long left = dfs(grid, i, j - 1);
        long right = dfs(grid, i, j + 1);
        long top = dfs(grid, i + 1, j);
        long bottom = dfs(grid, i - 1, j);

        long sum = val + left + top + bottom + right;

        return sum;
    }
}