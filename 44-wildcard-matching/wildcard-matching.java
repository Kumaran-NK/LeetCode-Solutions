class Solution {
    public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length()][p.length()];
        for(int[] arr : dp){
            Arrays.fill(arr, - 1);
        }
        return matching(s, s.length() - 1, p, p.length() -1, dp);
    }

    public boolean matching(String s, int i, String p, int j, int[][] dp){

        if(j < 0) return i < 0;
        if(i < 0){
            for(int k = 0; k <= j; k++){
                if(p.charAt(k) != '*') return false;
            }
            return true;
        }

        if(dp[i][j] != -1){
            if(dp[i][j] == 0) return false;
            else return true;
        }

        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            boolean val = matching(s, i - 1, p, j - 1, dp);
            if(val) dp[i][j] = 1;
            else dp[i][j] = 0;
            return val;
        }

        if(p.charAt(j) == '*'){
            boolean val = matching(s, i, p, j - 1, dp) || matching(s, i - 1, p, j, dp);
            if(val) dp[i][j] = 1;
            else dp[i][j] = 0;
            return val;
        }

        dp[i][j] = 0;
        return false;
    }
}