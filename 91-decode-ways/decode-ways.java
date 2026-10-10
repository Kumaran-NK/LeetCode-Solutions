class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        return helper(s, 0, dp);
    }

    public int helper(String s, int i, int[] dp){
        if(i == s.length()) return 1;
        if(s.charAt(i) == '0') return 0;

        if(dp[i] != -1) return dp[i];

        int count = helper(s, i + 1, dp);
        if(i + 1 < s.length()){
            int pair = (s.charAt(i) - '0') * 10 + s.charAt(i + 1) - '0';

            if(pair >= 10 && pair <= 26){
                count += helper(s, i + 2, dp);
            }
        
        }
        dp[i] = count;
        return dp[i];
    }
}