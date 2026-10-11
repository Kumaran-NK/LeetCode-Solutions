class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        } 

        return converting(word1, word1.length() - 1, word2, word2.length() - 1, dp);
    }

    public int converting(String word1, int i, String word2, int j, int[][] dp){
        
        if(i < 0) return j + 1;
        if(j < 0) return i + 1;

        if(dp[i][j] != -1) return dp[i][j];
        if(word1.charAt(i) == word2.charAt(j)){
            dp[i][j] = converting(word1, i - 1, word2, j - 1, dp);
            return dp[i][j];
        }

        int insert = converting(word1, i, word2, j - 1, dp);
        int delete = converting(word1, i - 1, word2, j, dp);
        int replace = converting(word1, i - 1, word2, j - 1, dp);

        dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));

        return dp[i][j];
    }
}