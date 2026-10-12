class Solution {
    public int uniquePathsIII(int[][] grid) {
        int startX = 0, startY = 0;
        int empty = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    startX = i;
                    startY = j;
                }
                if(grid[i][j] == 0) empty++;
            }
        }
        return travelling(grid, startX, startY,empty + 1);
    }

    public int travelling(int[][] grid, int i, int j,  int empty){

        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return 0;
        if(grid[i][j] == -1) return 0;
        if(grid[i][j] == 2) return empty == 0 ? 1 : 0;

        

        int temp = grid[i][j];
        grid[i][j] = -1;  

           
           
        int down = travelling(grid, i + 1, j,  empty - 1);
        int right = travelling(grid, i, j + 1,  empty - 1);
        int up = travelling(grid, i - 1, j,  empty - 1);
        int left = travelling(grid, i, j - 1, empty - 1);

        grid[i][j] = temp;
    
        return  down + right + up + left;
    }
}