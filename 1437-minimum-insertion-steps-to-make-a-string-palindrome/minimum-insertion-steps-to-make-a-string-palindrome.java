class Solution {
    public int minInsertions(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int[] arr : dp){
            Arrays.fill(arr, - 1);
        }
        return transform(new StringBuilder(s), 0, s.length() - 1, dp);
    }

    public int transform(StringBuilder s, int i, int j, int[][] dp){
        if(i >= j) return 0;
        if(i >= s.length()) return 0;
       

       if(dp[i][j] != -1){
            return dp[i][j];
       }

        if(s.charAt(i) == s.charAt(j)) return transform(s, i + 1, j - 1, dp);
        else{
            return dp[i][j] = 1 + Math.min(transform(s, i + 1, j, dp),transform(s, i, j - 1, dp));
        }
    }

}