class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        return helper(word1, word2, 0, 0, dp);

    }
    public int helper(String a, String b, int i, int j, int[][] dp){
        if(i >= a.length()) return b.length() - j;
        if(j >= b.length()) return a.length() - i;

        if(dp[i][j] != -1) return dp[i][j];
        if(a.charAt(i) == b.charAt(j)) return helper(a, b, i + 1, j + 1, dp);

        int insert = 1 + helper(a, b, i, j + 1, dp);
        int delete = 1 + helper(a, b, i + 1, j, dp);
        int replace = 1 + helper(a, b, i + 1, j + 1, dp);

        return dp[i][j] = Math.min(insert, Math.min(delete, replace));
    }
}