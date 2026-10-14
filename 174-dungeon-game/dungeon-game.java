class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length][dungeon[0].length ];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return helper(dungeon, 0, 0, dp);
    }

    public int helper(int[][] dungeon, int i, int j, int[][] dp){
        if(i >= dungeon.length || j >= dungeon[0].length) return Integer.MAX_VALUE;
        if(i == dungeon.length - 1 && j == dungeon[0].length - 1) return Math.max(1, 1 - dungeon[i][j]);

        if(dp[i][j] != -1) return dp[i][j];

        int right =  helper(dungeon, i, j + 1, dp);
        int down =  helper(dungeon, i + 1, j, dp);

        int minPath = Math.min(right, down);

        return dp[i][j] = Math.max(1, minPath - dungeon[i][j]);

    }
}