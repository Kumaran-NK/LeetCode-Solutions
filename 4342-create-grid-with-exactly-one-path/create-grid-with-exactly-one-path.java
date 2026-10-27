class Solution {
    public String[] createGrid(int m, int n) {
        String[][] grid = new String[m][n];
        String[] result = new String[m];

        for(String[] arr : grid){
            Arrays.fill(arr, "#");
        }

        for(int i = 0; i < m; i++){
            grid[i][n - 1] = ".";
        }

        for(int i = 0; i < n; i++){
            grid[0][i] = ".";
        }

  
        for(int i = 0; i < m; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++){
                sb.append(grid[i][j]);
            }
            result[i] = sb.toString();
        }
        return result;

    }
   

}